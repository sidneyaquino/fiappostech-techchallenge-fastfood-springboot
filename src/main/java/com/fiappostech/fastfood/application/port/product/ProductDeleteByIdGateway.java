package com.fiappostech.fastfood.application.port.product;

import java.util.UUID;

public interface ProductDeleteByIdGateway {
   public void execute(UUID productId);
}
