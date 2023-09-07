package com.fiappostech.fastfood.domain.port.product;

import java.util.UUID;

public interface ProductDeleteByIdUseCase {
   void execute(UUID productId);
}