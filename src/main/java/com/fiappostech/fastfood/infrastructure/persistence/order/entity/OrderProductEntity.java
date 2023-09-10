package com.fiappostech.fastfood.infrastructure.persistence.order.entity;

import java.math.BigDecimal;

import com.fiappostech.fastfood.domain.dto.order.OrderProductResponse;
import com.fiappostech.fastfood.infrastructure.persistence.product.entity.ProductEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(of = "pkId")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_products")
public class OrderProductEntity {

   @EmbeddedId
   // @Column(name = "id")
   private OrderProductPk pkId = new OrderProductPk();

   @Column(nullable = false)
   private Short quantity;

   @Column(nullable = false)
   private BigDecimal value;

   public OrderProductEntity(OrderEntity orderEntity, ProductEntity productEntity, Short quantity) {
      this.pkId.setOrder(orderEntity);
      this.pkId.setProduct(productEntity);
      this.value = productEntity.getValue();
      this.quantity = quantity;
   }

   public OrderProductResponse toOrderProductResponse() {
      return new OrderProductResponse(
            this.getPkId().getProduct().getProductId(),
            this.getPkId().getProduct().getName(),
            this.getQuantity(),
            this.getValue());
   }
}