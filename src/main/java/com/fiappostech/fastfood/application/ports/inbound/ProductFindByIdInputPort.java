package com.fiappostech.fastfood.application.ports.inbound;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public interface ProductFindByIdInputPort {
   ProductResponse execute(UUID productId);
}