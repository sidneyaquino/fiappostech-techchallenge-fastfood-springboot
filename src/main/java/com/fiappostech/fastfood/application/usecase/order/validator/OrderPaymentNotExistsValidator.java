package com.fiappostech.fastfood.application.usecase.order.validator;

import com.fiappostech.fastfood.application.exception.ApplicationException;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public class OrderPaymentNotExistsValidator implements OrderUpdateValidator {
   
   @Override
   public void validate(OrderRequest orderRequest, OrderResponse orderResponse) {
      if (orderResponse.tracking() == null) {
         throw new ApplicationException("Order pending payment process...");
      }
   }
}