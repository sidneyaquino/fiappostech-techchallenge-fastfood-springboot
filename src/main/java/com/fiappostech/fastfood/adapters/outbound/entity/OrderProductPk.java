package com.fiappostech.fastfood.adapters.outbound.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
// @AllArgsConstructor
// @NoArgsConstructor
@Getter
@Setter
@Embeddable
public class OrderProductPk {
   
   @ManyToOne
   @JoinColumn(name = "order_id")
   private OrderEntity order;
   
   @ManyToOne
   @JoinColumn(name = "product_id")
   private ProductEntity product;

   public OrderProductPk() {
   }

   public OrderProductPk(OrderEntity order, ProductEntity product) {
      this.order = order;
      this.product = product;
   }
}