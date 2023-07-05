package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.ProductDeleteByIdServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.ProductFindByCategoryServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.ProductFindByIdServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.ProductSaveServiceAdapter;
import com.fiappostech.fastfood.application.core.ProductDeleteByIdUseCase;
import com.fiappostech.fastfood.application.core.ProductFindByCategoryUseCase;
import com.fiappostech.fastfood.application.core.ProductFindByIdUseCase;
import com.fiappostech.fastfood.application.core.ProductInsertUseCase;

@Configuration
public class ProductBeanConfig {

   @Bean
   public ProductInsertUseCase productAddUseCase(ProductSaveServiceAdapter productSaveServiceAdapter) {
      return new ProductInsertUseCase(productSaveServiceAdapter);
   }

   @Bean
   public ProductFindByIdUseCase productFindByIdUseCase(ProductFindByIdServiceAdapter productFindByIdServiceAdapter) {
      return new ProductFindByIdUseCase(productFindByIdServiceAdapter);
   }

   @Bean
   public ProductFindByCategoryUseCase productFindUseCase(
         ProductFindByCategoryServiceAdapter productFindByCategoryServiceAdapter) {

      return new ProductFindByCategoryUseCase(productFindByCategoryServiceAdapter);
   }

   @Bean
   public ProductDeleteByIdUseCase productDeleteByIdUseCase(
         ProductDeleteByIdServiceAdapter productDeleteByIdServiceAdapter) {

      return new ProductDeleteByIdUseCase(productDeleteByIdServiceAdapter);
   }
}