package com.fiappostech.fastfood.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.presenter.product.ProductDeleteByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductFindByCategoryPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductInsertPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductUpdatePresenter;
import com.fiappostech.fastfood.application.usecase.product.ProductDeleteByIdInteractor;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByCategoryInteractor;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByIdInteractor;
import com.fiappostech.fastfood.application.usecase.product.ProductSaveInteractor;
import com.fiappostech.fastfood.domain.port.product.ProductDeleteByIdUseCase;
import com.fiappostech.fastfood.domain.port.product.ProductFindByCategoryUseCase;
import com.fiappostech.fastfood.domain.port.product.ProductFindByIdUseCase;
import com.fiappostech.fastfood.domain.port.product.ProductSaveUseCase;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductDeleteByIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductFindByCategoryRepository;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductFindByIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductSaveRepository;

@Configuration
public class ProductConfig {

   @Bean
   public ProductInsertPresenter productInsertPresenter(  
         ProductSaveUseCase productSaveUseCase) {

      return new ProductInsertPresenter(productSaveUseCase);
   }

   @Bean
   public ProductUpdatePresenter productUpdatePresenter(  
         ProductSaveUseCase productSaveUseCase) {

      return new ProductUpdatePresenter(productSaveUseCase);
   }

   @Bean
   public ProductFindByIdPresenter productFindByIdPresenter(
         ProductFindByIdUseCase productFindByIdUseCase) {

      return new ProductFindByIdPresenter(productFindByIdUseCase);
   }

   @Bean
   public ProductFindByCategoryPresenter productFindByCategoryPresenter(
         ProductFindByCategoryUseCase productFindByCategoryUseCase) {

      return new ProductFindByCategoryPresenter(productFindByCategoryUseCase);
   }

   @Bean
   public ProductDeleteByIdPresenter productDeleteByIdPresenter(
      ProductDeleteByIdUseCase productDeleteByIdUseCase) {

      return new ProductDeleteByIdPresenter(productDeleteByIdUseCase);
   }

   @Bean
   public ProductSaveInteractor productSaveInteractor(  
         ProductSaveRepository productSaveRepository) {

      return new ProductSaveInteractor(productSaveRepository);
   }

   @Bean
   public ProductFindByIdInteractor productFindByIdInteractor(
         ProductFindByIdRepository productFindByIdRepository) {

      return new ProductFindByIdInteractor(productFindByIdRepository);
   }

   @Bean
   public ProductFindByCategoryInteractor productFindByCategoryInteractor(
         ProductFindByCategoryRepository productFindByCategoryRepository) {

      return new ProductFindByCategoryInteractor(productFindByCategoryRepository);
   }

   @Bean
   public ProductDeleteByIdInteractor productDeleteByIdInteractor(
         ProductDeleteByIdRepository productDeleteByIdRepository) {

      return new ProductDeleteByIdInteractor(productDeleteByIdRepository);
   }
}