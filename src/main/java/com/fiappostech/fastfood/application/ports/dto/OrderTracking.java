package com.fiappostech.fastfood.application.ports.dto;

public enum OrderTracking {
   RECEIVED,
   PREPARING,
   READY,
   FINISHED;

   public int getValue() {
      return ordinal() + 1;
   }
}