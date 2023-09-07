package com.fiappostech.fastfood.domain.valueobject;

import java.util.regex.Pattern;

public record PersonalIdDomain(String personalId) {
   public PersonalIdDomain {
      if (personalId == null) {
         throw new IllegalArgumentException("Personal ID cannot be null");
      }
      if (personalId.length() != 11) {
         throw new IllegalArgumentException("Personal ID should be exactly 11 digits");
      }
      if (!Pattern.matches("^[0-9]+$", personalId)) {
         throw new IllegalArgumentException("Personal ID should only have numbers");
      }
      if (personalId.equals("00000000000") || personalId.equals("11111111111") ||
            personalId.equals("22222222222") || personalId.equals("33333333333") ||
            personalId.equals("44444444444") || personalId.equals("55555555555") ||
            personalId.equals("66666666666") || personalId.equals("77777777777") ||
            personalId.equals("88888888888") || personalId.equals("99999999999")) {

         throw new IllegalArgumentException("Personal ID should have different digits");
      }
   }
};