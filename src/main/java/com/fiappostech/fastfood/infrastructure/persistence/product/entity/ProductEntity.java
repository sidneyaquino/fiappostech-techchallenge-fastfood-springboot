package com.fiappostech.fastfood.infrastructure.persistence.product.entity;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fiappostech.fastfood.domain.dto.product.ProductRequest;
import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.domain.entity.ProductCategory;

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

@EqualsAndHashCode(of = "productId")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE products SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@Entity
@Table(name = "products")
public class ProductEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   @Column(name = "id")
   private UUID productId;

   @Column(length = 150, nullable = false)
   private String name;

   @Column(columnDefinition = "TEXT", nullable = false)
   private String description;

   @Enumerated(EnumType.ORDINAL)
   @Column(nullable = false)
   private ProductCategory category;

   @Column(nullable = false)
   private BigDecimal value;

   @Column(nullable = false)
   private boolean deleted = false;

   public ProductEntity(ProductRequest productRequest) {
      this.productId = productRequest.productId();
      this.name = productRequest.name();
      this.description = productRequest.description();
      this.category = productRequest.category();
      this.value = productRequest.value();
   }

   public ProductResponse toProductResponse() {
      return new ProductResponse(
            this.getProductId(),
            this.getName(),
            this.getDescription(),
            this.getCategory(),
            this.getValue());
   }

   public void update(ProductRequest productRequest) {
      if (productRequest.name() != null) {
         this.name = productRequest.name();
      }
      if (productRequest.description() != null) {
         this.description = productRequest.description();
      }
      if (productRequest.category() != null) {
         this.category = productRequest.category();
      }
      if (productRequest.value() != null) {
         this.value = productRequest.value();
      }
   }
}