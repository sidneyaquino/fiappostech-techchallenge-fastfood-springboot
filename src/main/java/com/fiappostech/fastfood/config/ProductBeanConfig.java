package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.ProductFindByCategoryServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.ProductFindByIdServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.ProductInsertServiceAdapter;
import com.fiappostech.fastfood.application.core.ProductAddUseCase;
import com.fiappostech.fastfood.application.core.ProductFindByCategoryUseCase;
import com.fiappostech.fastfood.application.core.ProductFindByIdUseCase;

@Configuration
public class ProductBeanConfig {
   
   @Bean
   public ProductAddUseCase productAddUseCase(ProductInsertServiceAdapter productInsertServiceAdapter) {
      return new ProductAddUseCase(productInsertServiceAdapter);
   }

   @Bean
   public ProductFindByIdUseCase productFindByIdUseCase(ProductFindByIdServiceAdapter productFindByIdServiceAdapter) {
      return new ProductFindByIdUseCase(productFindByIdServiceAdapter);
   }

   @Bean
   public ProductFindByCategoryUseCase productFindUseCase(ProductFindByCategoryServiceAdapter productFindByCategoryServiceAdapter) {
      return new ProductFindByCategoryUseCase(productFindByCategoryServiceAdapter);
   }
}