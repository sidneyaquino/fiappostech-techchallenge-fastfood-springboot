package com.fiappostech.fastfood.application.ports.inbound;

import java.util.UUID;

public interface ProductDeleteByIdInputPort {
   void execute(UUID productId);
}