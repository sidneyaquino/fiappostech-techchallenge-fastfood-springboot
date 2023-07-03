package com.fiappostech.fastfood.application.core.domain;

import com.fiappostech.fastfood.application.core.valueobject.EmailAdress;
import com.fiappostech.fastfood.application.core.valueobject.PersonalId;
import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

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

   public CustomerDomain(CustomerRequest customerRequest) {
      this.personalId = new PersonalId(customerRequest.personalId());
      this.emailAdress = new EmailAdress(customerRequest.email());
      this.name = customerRequest.name();
   }

   public CustomerDomain(CustomerResponse customerResponse) {
      this.personalId = new PersonalId(customerResponse.personalId());
      this.emailAdress = new EmailAdress(customerResponse.email());
      this.name = customerResponse.name();
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

   public CustomerRequest toCustomerRequest() {
      return new CustomerRequest(this.getPersonalId().personalId(), this.emailAdress.emailAddress(), this.getName());
   }

   public CustomerResponse toCustomerResponse() {
      return new CustomerResponse(this.getPersonalId().personalId(), this.emailAdress.emailAddress(), this.getName());
   }
}