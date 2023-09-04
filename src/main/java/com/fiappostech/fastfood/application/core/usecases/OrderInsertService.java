package com.fiappostech.fastfood.application.core.usecases;

import java.math.BigDecimal;

import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.core.domain.OrderProductDomain;
import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.exception.ApplicationException;
import com.fiappostech.fastfood.application.ports.inbound.OrderInsertInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerIdentifyOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderInsertOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductFindByIdOutputPort;

public class OrderInsertService implements OrderInsertInputPort {

   private final OrderInsertOutputPort orderInsertOutputPort;
   private final ProductFindByIdOutputPort productFindByIdOutputPort;
   private final CustomerIdentifyOutputPort customerIdentifyOutputPort;

   public OrderInsertService(
         OrderInsertOutputPort orderInsertOutputPort,
         ProductFindByIdOutputPort productFindByIdOutputPort,
         CustomerIdentifyOutputPort customerIdentifyOutputPort) {

      this.orderInsertOutputPort = orderInsertOutputPort;
      this.productFindByIdOutputPort = productFindByIdOutputPort;
      this.customerIdentifyOutputPort = customerIdentifyOutputPort;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      if (orderRequest.customer() != null) {
         var personalId = orderRequest.customer().personalId();
         var customerResponse = this.customerIdentifyOutputPort.execute(personalId);

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
         throw new ApplicationException("Input products list cannot be empty");
      }
      var value = new BigDecimal(0);
      for (OrderProductDomain orderProductDomain : orderDomain.getProducts()) {
         if (orderProductDomain.getQuantity() < 1) {
            throw new ApplicationException("The minimum quantity value is one (1)");
         }
         var productrResponse = this.productFindByIdOutputPort.execute(orderProductDomain.getProductId());
         value = value.add(productrResponse.value().multiply(new BigDecimal(orderProductDomain.getQuantity())));
      }
      orderDomain.setValue(value);
      //
      // Request.
      //
      var orderResponse = this.orderInsertOutputPort.execute(orderDomain.toOrderRequest());
      orderDomain = new OrderDomain(orderResponse);
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}