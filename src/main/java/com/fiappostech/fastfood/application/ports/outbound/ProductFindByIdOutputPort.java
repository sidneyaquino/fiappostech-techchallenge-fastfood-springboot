package com.fiappostech.fastfood.application.ports.outbound;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public interface ProductFindByIdOutputPort {
   public ProductResponse execute(UUID productId);
}
