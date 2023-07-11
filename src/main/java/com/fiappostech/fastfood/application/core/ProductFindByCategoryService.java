package com.fiappostech.fastfood.application.core;

import java.util.List;

import com.fiappostech.fastfood.application.core.domain.ProductDomain;
import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductFindByCategoryInputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductFindByCategoryOutputPort;

public class ProductFindByCategoryService implements ProductFindByCategoryInputPort {
   
   private final ProductFindByCategoryOutputPort productFindByCategoryOutputPort;

   public ProductFindByCategoryService(ProductFindByCategoryOutputPort productFindByCategoryOutputPort) {
      this.productFindByCategoryOutputPort = productFindByCategoryOutputPort;
   }

   @Override
   public List<ProductResponse> execute(Category category) {
      
      //
      // Business Rules before Request.
      //
      var listProductResponse = this.productFindByCategoryOutputPort.execute(category);
      var listProductDomain = listProductResponse.stream().map(ProductDomain::new).toList();
      //
      // Business Rules before Response.
      //

      return listProductDomain.stream().map(item -> item.toProductResponse()).toList();
   }
}