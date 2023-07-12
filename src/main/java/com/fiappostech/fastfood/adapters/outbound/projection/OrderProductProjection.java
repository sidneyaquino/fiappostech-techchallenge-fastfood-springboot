package com.fiappostech.fastfood.adapters.outbound.projection;

import java.math.BigDecimal;
import java.util.UUID;

public interface OrderProductProjection {
   UUID getOrderId();
   UUID getProductId();
   String getDescription();
   Short getQuantity();
   BigDecimal getValue();
}