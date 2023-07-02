package com.fiappostech.fastfood.application.core.domain;

import com.fiappostech.fastfood.application.core.valueobject.EmailAdress;
import com.fiappostech.fastfood.application.core.valueobject.PersonalId;
import com.fiappostech.fastfood.application.ports.dto.Customer;

public class CustomerDomain {

   private PersonalId personalId;
   private EmailAdress emailAdress;
   private String name;

   public CustomerDomain() {
   }

   public CustomerDomain(PersonalId personalId, EmailAdress emailAdress, String name) {
      this.personalId = personalId;
      this.emailAdress = emailAdress;
      this.name = name;
   }

   public CustomerDomain(Customer customer) {
      this.personalId = new PersonalId(customer.personalId());
      this.emailAdress = new EmailAdress(customer.email());
      this.name = customer.name();
   }

   public Customer toCustomer(){
      return new Customer(this.getPersonalId().personalId(), this.emailAdress.emailAddress(), this.getName());
   }

   public PersonalId getPersonalId() {
      return personalId;
   }

   public void setPersonalId(PersonalId personalId) {
      this.personalId = personalId;
   }

   public EmailAdress getEmailAdress() {
      return emailAdress;
   }

   public void setEmailAddress(EmailAdress emailAddress) {
      this.emailAdress = emailAddress;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}