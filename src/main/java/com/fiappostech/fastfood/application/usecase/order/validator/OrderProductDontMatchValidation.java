package com.fiappostech.fastfood.application.usecase.order.validator;

import com.fiappostech.fastfood.application.exception.ApplicationException;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public class OrderProductDontMatchValidation implements OrderCheckoutValidator{

   @Override
   public void validate(OrderRequest orderRequest, OrderResponse orderResponse) {
      if (orderResponse.products().size() != orderRequest.products().size()) {
         throw new ApplicationException("Order Products are different");
      }
      for (var product : orderResponse.products()) {
         orderRequest.products().stream()         
            .filter(item -> item.productId().equals(product.productId()))
            .filter(item -> item.quantity().equals(product.quantity()))
            .findFirst().orElseThrow(() -> new ApplicationException("Order Products are different"));
      }
   }
}