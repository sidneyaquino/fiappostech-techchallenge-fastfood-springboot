package com.fiappostech.fastfood.application.ports.dto;

public enum Category {
   BURGER,
   SIDE,
   DRINK,
   DESERT;

   public int getValue() {
      return ordinal() + 1;
   }
}