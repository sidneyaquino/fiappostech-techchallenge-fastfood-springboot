package com.fiappostech.fastfood.application.usecase.product;

import java.util.UUID;

public interface ProductDeleteByIdUseCase {
   void execute(UUID productId);
}