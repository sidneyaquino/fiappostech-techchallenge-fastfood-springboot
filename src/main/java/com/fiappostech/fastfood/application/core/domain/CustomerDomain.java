package com.fiappostech.fastfood.application.core.domain;

import com.fiappostech.fastfood.application.core.valueobject.EmailAdressDomain;
import com.fiappostech.fastfood.application.core.valueobject.PersonalIdDomain;
import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public class CustomerDomain {

   private PersonalIdDomain personalId;
   private EmailAdressDomain emailAdress;
   private String name;

   public CustomerDomain() {
   }

   public CustomerDomain(PersonalIdDomain personalId, EmailAdressDomain emailAdress, String name) {
      this.personalId = personalId;
      this.emailAdress = emailAdress;
      this.name = name;
   }

   public CustomerDomain(CustomerRequest customerRequest) {
      this.personalId = new PersonalIdDomain(customerRequest.personalId());
      this.emailAdress = new EmailAdressDomain(customerRequest.email());
      this.name = customerRequest.name();
   }

   public CustomerDomain(CustomerResponse customerResponse) {
      this.personalId = new PersonalIdDomain(customerResponse.personalId());
      this.emailAdress = new EmailAdressDomain(customerResponse.email());
      this.name = customerResponse.name();
   }

   public PersonalIdDomain getPersonalId() {
      return personalId;
   }

   public void setPersonalId(PersonalIdDomain personalId) {
      this.personalId = personalId;
   }

   public EmailAdressDomain getEmailAdress() {
      return emailAdress;
   }

   public void setEmailAddress(EmailAdressDomain emailAddress) {
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