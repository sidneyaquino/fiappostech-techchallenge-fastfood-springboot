package com.fiappostech.fastfood.adapters.outbound.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "productId")
@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private UUID productId;

   @Column(length = 150, nullable = false)
   private String name;

   @Column(columnDefinition = "TEXT", nullable = false)
   private String description;

   @Enumerated(EnumType.ORDINAL)
   @Column(nullable = false)
   private Category category;

   @Column(nullable = false)
   private BigDecimal value;

   // @Column(nullable = false)   
   // private boolean deleted = false;

   public ProductEntity(ProductRequest productRequest) {
      this.productId = productRequest.productId();
      this.name = productRequest.name();
      this.description = productRequest.description();
      this.category = productRequest.category();
      this.value = productRequest.value();
   }

   public ProductResponse toProductResponse() {
      return new ProductResponse(this.getProductId(), this.getName(), this.getDescription(), this.getCategory(), this.getValue());
   } 
}