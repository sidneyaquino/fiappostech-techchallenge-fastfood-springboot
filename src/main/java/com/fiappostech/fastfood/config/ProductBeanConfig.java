package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.ProductDeleteByIdRepository;
import com.fiappostech.fastfood.adapters.outbound.ProductFindByCategoryRepository;
import com.fiappostech.fastfood.adapters.outbound.ProductFindByIdRepository;
import com.fiappostech.fastfood.adapters.outbound.ProductSaveRepository;
import com.fiappostech.fastfood.application.core.usecases.ProductDeleteByIdService;
import com.fiappostech.fastfood.application.core.usecases.ProductFindByCategoryService;
import com.fiappostech.fastfood.application.core.usecases.ProductFindByIdService;
import com.fiappostech.fastfood.application.core.usecases.ProductSaveService;

@Configuration
public class ProductBeanConfig {

   @Bean
   public ProductSaveService productSaveService(  
         ProductSaveRepository productSaveRepository) {

      return new ProductSaveService(productSaveRepository);
   }

   @Bean
   public ProductFindByIdService productFindByIdService(
         ProductFindByIdRepository productFindByIdRepository) {

      return new ProductFindByIdService(productFindByIdRepository);
   }

   @Bean
   public ProductFindByCategoryService productFindByCategoryService(
         ProductFindByCategoryRepository productFindByCategoryRepository) {

      return new ProductFindByCategoryService(productFindByCategoryRepository);
   }

   @Bean
   public ProductDeleteByIdService productDeleteByIdService(
         ProductDeleteByIdRepository productDeleteByIdRepository) {

      return new ProductDeleteByIdService(productDeleteByIdRepository);
   }
}