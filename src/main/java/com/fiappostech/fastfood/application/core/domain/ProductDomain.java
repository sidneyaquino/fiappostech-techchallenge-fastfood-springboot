package com.fiappostech.fastfood.application.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public class ProductDomain {

   private UUID productId;
   private String name;
   private String description;
   private Category category;
   private BigDecimal value;

   public ProductDomain() {
   }

   public ProductDomain(
         UUID productId,
         String name,
         String description,
         Category category,
         BigDecimal value) {

      this.productId = productId;
      this.name = name;
      this.description = description;
      this.category = category;
      this.value = value;
   }

   public ProductDomain(ProductResponse productResponse) {
      this.productId = productResponse.productId();
      this.name = productResponse.name();
      this.description = productResponse.description();
      this.category = productResponse.category();
      this.value = productResponse.value();
   }

   public ProductDomain(ProductRequest productRequest) {
      this.productId = productRequest.productId();
      this.name = productRequest.name();
      this.description = productRequest.description();
      this.category = productRequest.category();
      this.value = productRequest.value();
   }

   public UUID getProductId() {
      return productId;
   }

   public void setProductId(UUID productId) {
      this.productId = productId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public BigDecimal getValue() {
      return value;
   }

   public void setValue(BigDecimal value) {
      this.value = value;
   }

   public ProductRequest toProductRequest() {
      return new ProductRequest(
            this.getProductId(),
            this.getName(),
            this.getDescription(),
            this.getCategory(),
            this.getValue());
   }

   public ProductResponse toProductResponse() {
      return new ProductResponse(
            this.getProductId(),
            this.getName(),
            this.getDescription(),
            this.getCategory(),
            this.getValue());
   }
}