package com.fiappostech.fastfood.application.core.valueobject;

import java.util.regex.*;  

public record EmailAdressDomain(String emailAddress) {
   public EmailAdressDomain
   {
      if (emailAddress == null) {
         throw new IllegalArgumentException("Email Address cannot be null");
      }

      if (!Pattern.matches("^(.+)@(\\S+)$", emailAddress)) {
         throw new IllegalArgumentException("Invalid Format Email Address");
      }
   }
}