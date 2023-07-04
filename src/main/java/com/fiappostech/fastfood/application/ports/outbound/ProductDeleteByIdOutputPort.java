package com.fiappostech.fastfood.application.ports.outbound;

import java.util.UUID;

public interface ProductDeleteByIdOutputPort {
   public void execute(UUID productId);
}
