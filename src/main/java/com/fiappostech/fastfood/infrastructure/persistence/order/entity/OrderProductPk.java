package com.fiappostech.fastfood.infrastructure.persistence.order.entity;

import com.fiappostech.fastfood.infrastructure.persistence.product.entity.ProductEntity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
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

   // public OrderProductPk() {
   // }

   // public OrderProductPk(OrderEntity order, ProductEntity product) {
   //    this.order = order;
   //    this.product = product;
   // }
}