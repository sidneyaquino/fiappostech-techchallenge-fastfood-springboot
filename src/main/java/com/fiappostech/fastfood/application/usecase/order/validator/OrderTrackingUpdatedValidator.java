package com.fiappostech.fastfood.application.usecase.order.validator;

import com.fiappostech.fastfood.application.exception.ApplicationException;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public class OrderTrackingUpdatedValidator implements OrderUpdateValidator {

   @Override
   public void validate(OrderRequest orderRequest, OrderResponse orderResponse) {
      if (orderResponse.tracking().equals(orderRequest.tracking())) {
         throw new ApplicationException("Order already updated...");
      }
   }
}