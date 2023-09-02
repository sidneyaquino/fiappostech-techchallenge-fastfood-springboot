package com.fiappostech.fastfood.application.ports.dto;

public enum ProductCategory {
   BURGER,
   SIDE,
   DRINK,
   DESERT;

   public int getValue() {
      return ordinal() + 1;
   }
}