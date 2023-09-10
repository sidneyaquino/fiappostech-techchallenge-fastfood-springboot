package com.fiappostech.fastfood.infrastructure.config.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.gateway.product.ProductDeleteByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductDeleteByIdRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByCategoryGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByCategoryRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByIdRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductSaveGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductSaveRepositoryGateway;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductDeleteByIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductFindByCategoryRepository;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductFindByIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductSaveRepository;

@Configuration
public class ProductGatewayConfig {

   @Bean
   public ProductSaveGateway productSaveGateway(
         ProductSaveRepository productSaveRepository) {

      return new ProductSaveRepositoryGateway(productSaveRepository);
   }

   @Bean
   public ProductFindByIdGateway productFindByIdGateway(
         ProductFindByIdRepository productFindByIdRepository) {

      return new ProductFindByIdRepositoryGateway(productFindByIdRepository);
   }

   @Bean
   public ProductFindByCategoryGateway productFindByCategoryGateway(
         ProductFindByCategoryRepository productFindByCategoryRepository) {

      return new ProductFindByCategoryRepositoryGateway(productFindByCategoryRepository);
   }

   @Bean
   public ProductDeleteByIdGateway productDeleteByIdGateway(
         ProductDeleteByIdRepository productDeleteByIdRepository) {

      return new ProductDeleteByIdRepositoryGateway(productDeleteByIdRepository);
   }
}