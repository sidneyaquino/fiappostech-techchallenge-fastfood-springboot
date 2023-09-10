package com.fiappostech.fastfood.infrastructure.config.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.presenter.product.ProductDeleteByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductDeleteByIdControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductFindByCategoryPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductFindByCategoryControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductFindByIdControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductInsertPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductInsertControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductUpdatePresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductUpdateControllerPresenter;
import com.fiappostech.fastfood.application.usecase.product.ProductDeleteByIdUseCase;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByCategoryUseCase;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByIdUseCase;
import com.fiappostech.fastfood.application.usecase.product.ProductSaveUseCase;

@Configuration
public class ProductPresenterConfig {

   @Bean
   public ProductInsertPresenter productInsertControllerPresenter(
         ProductSaveUseCase productSaveUseCase) {

      return new ProductInsertControllerPresenter(productSaveUseCase);
   }

   @Bean
   public ProductUpdatePresenter productUpdateControllerPresenter(
         ProductSaveUseCase productSaveUseCase) {

      return new ProductUpdateControllerPresenter(productSaveUseCase);
   }

   @Bean
   public ProductFindByIdPresenter productFindByIdControllerPresenter(
         ProductFindByIdUseCase productFindByIdUseCase) {

      return new ProductFindByIdControllerPresenter(productFindByIdUseCase);
   }

   @Bean
   public ProductFindByCategoryPresenter productFindByCategoryControllerPresenter(
         ProductFindByCategoryUseCase productFindByCategoryUseCase) {

      return new ProductFindByCategoryControllerPresenter(productFindByCategoryUseCase);
   }

   @Bean
   public ProductDeleteByIdPresenter productDeleteByIdControllerPresenter(
         ProductDeleteByIdUseCase productDeleteByIdUseCase) {

      return new ProductDeleteByIdControllerPresenter(productDeleteByIdUseCase);
   }
}