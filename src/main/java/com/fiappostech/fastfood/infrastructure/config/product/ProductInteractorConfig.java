package com.fiappostech.fastfood.infrastructure.config.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.gateway.product.ProductDeleteByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByCategoryGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductSaveGateway;
import com.fiappostech.fastfood.application.usecase.product.ProductDeleteByIdInteractor;
import com.fiappostech.fastfood.application.usecase.product.ProductDeleteByIdUseCase;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByCategoryInteractor;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByCategoryUseCase;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByIdInteractor;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByIdUseCase;
import com.fiappostech.fastfood.application.usecase.product.ProductSaveInteractor;
import com.fiappostech.fastfood.application.usecase.product.ProductSaveUseCase;

@Configuration
public class ProductInteractorConfig {

   @Bean
   public ProductSaveUseCase productSaveUseCase(
         ProductSaveGateway productSaveGateway) {

      return new ProductSaveInteractor(productSaveGateway);
   }

   @Bean
   public ProductFindByIdUseCase productFindByIdUseCase(
         ProductFindByIdGateway productFindByIdGateway) {

      return new ProductFindByIdInteractor(productFindByIdGateway);
   }

   @Bean
   public ProductFindByCategoryUseCase productFindByCategoryUseCase(
         ProductFindByCategoryGateway productFindByCategoryGateway) {

      return new ProductFindByCategoryInteractor(productFindByCategoryGateway);
   }

   @Bean
   public ProductDeleteByIdUseCase productDeleteByIdUseCase(
         ProductDeleteByIdGateway productDeleteByIdGateway) {

      return new ProductDeleteByIdInteractor(productDeleteByIdGateway);
   }
}