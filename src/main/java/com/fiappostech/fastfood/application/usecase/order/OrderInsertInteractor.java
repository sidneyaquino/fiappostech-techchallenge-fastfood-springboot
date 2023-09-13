package com.fiappostech.fastfood.application.usecase.order;

import java.math.BigDecimal;
import java.util.List;

import com.fiappostech.fastfood.adapter.gateway.customer.CustomerIdentifyGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderInsertGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByIdGateway;
import com.fiappostech.fastfood.application.exception.ApplicationException;
import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;
import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;
import com.fiappostech.fastfood.domain.dto.order.OrderProductRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.CustomerDomain;
import com.fiappostech.fastfood.domain.entity.OrderDomain;

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
      
      //
      // Business Rules before Request (validation).
      //
      CustomerResponse customerResponse = customerValidate(orderRequest.customer());
      BigDecimal value = productsValidate(orderRequest.products());
      
      var orderDomain = new OrderDomain(orderRequest);
      orderDomain.setCustomer(new CustomerDomain(customerResponse));
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

   private CustomerResponse customerValidate(CustomerRequest customerRequest) {
      CustomerResponse customerResponse = null;

      if (customerRequest != null) {
         var personalId = customerRequest.personalId();
         customerResponse = this.customerIdentifyGateway.execute(personalId);
      }
      return customerResponse;
   }

   private BigDecimal productsValidate(List<OrderProductRequest> products) {
      if (products == null) {
         throw new ApplicationException("Input products list cannot be empty");
      }

      var value = new BigDecimal(0);
      for (OrderProductRequest item : products) {
         if (item.quantity() < 1) {
            throw new ApplicationException("The minimum quantity value is one (1)");
         }
         var productrResponse = this.productFindByIdGateway.execute(item.productId());
         value = value.add(productrResponse.value().multiply(new BigDecimal(item.quantity())));
      }
      return value;
   }
}