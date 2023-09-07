package com.fiappostech.fastfood.application.usecase.order;

import java.math.BigDecimal;

import com.fiappostech.fastfood.application.exception.BusinessException;
import com.fiappostech.fastfood.application.port.customer.CustomerIdentifyGateway;
import com.fiappostech.fastfood.application.port.order.OrderInsertGateway;
import com.fiappostech.fastfood.application.port.product.ProductFindByIdGateway;
import com.fiappostech.fastfood.domain.entity.OrderDomain;
import com.fiappostech.fastfood.domain.entity.OrderProductDomain;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerRequest;
import com.fiappostech.fastfood.domain.port.order.OrderInsertUseCase;
import com.fiappostech.fastfood.domain.port.order.dto.OrderRequest;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public class OrderInsertInteractor implements OrderInsertUseCase {

   private final OrderInsertGateway orderInsertGateway;
   private final ProductFindByIdGateway productFindByIdGateway;
   private final CustomerIdentifyGateway customerIdentifyGateway;

   public OrderInsertInteractor(
         OrderInsertGateway orderInsertGateway,
         ProductFindByIdGateway productFindByIdGateway,
         CustomerIdentifyGateway customerIdentifyGateway) {

      this.orderInsertGateway = orderInsertGateway;
      this.productFindByIdGateway = productFindByIdGateway;
      this.customerIdentifyGateway = customerIdentifyGateway;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      if (orderRequest.customer() != null) {
         var personalId = orderRequest.customer().personalId();
         var customerResponse = this.customerIdentifyGateway.execute(personalId);

         orderRequest = new OrderRequest(
               orderRequest.orderId(),
               new CustomerRequest(customerResponse),
               orderRequest.created(),
               orderRequest.tracked(),
               orderRequest.tracking(),
               orderRequest.value(),
               orderRequest.products()
         );
      }
      var orderDomain = new OrderDomain(orderRequest);

      //
      // Business Rules before Request (validation).
      //
      if (orderDomain.getProducts() == null) {
         throw new BusinessException("Input products list cannot be empty");
      }
      var value = new BigDecimal(0);
      for (OrderProductDomain orderProductDomain : orderDomain.getProducts()) {
         if (orderProductDomain.getQuantity() < 1) {
            throw new BusinessException("The minimum quantity value is one (1)");
         }
         var productrResponse = this.productFindByIdGateway.execute(orderProductDomain.getProductId());
         value = value.add(productrResponse.value().multiply(new BigDecimal(orderProductDomain.getQuantity())));
      }
      orderDomain.setValue(value);
      //
      // Request.
      //
      var orderResponse = this.orderInsertGateway.execute(orderDomain.toOrderRequest());
      orderDomain = new OrderDomain(orderResponse);
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}