package com.fiappostech.fastfood.domain.entity;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;
import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;
import com.fiappostech.fastfood.domain.valueobject.EmailAdressDomain;
import com.fiappostech.fastfood.domain.valueobject.PersonalIdDomain;

public class CustomerDomain {

   private UUID customerId;
   private PersonalIdDomain personalId;
   private EmailAdressDomain emailAdress;
   private String name;

   public CustomerDomain() {
   }

   public CustomerDomain(
         UUID customerId,
         PersonalIdDomain personalId,
         EmailAdressDomain emailAdress,
         String name) {

      this.customerId = customerId;
      this.personalId = personalId;
      this.emailAdress = emailAdress;
      this.name = name;
   }

   public CustomerDomain(CustomerRequest customerRequest) {
      this.customerId = customerRequest.customerId();
      this.personalId = new PersonalIdDomain(customerRequest.personalId());
      this.emailAdress = new EmailAdressDomain(customerRequest.email());
      this.name = customerRequest.name();
   }

   public CustomerDomain(CustomerResponse customerResponse) {
      this.customerId = customerResponse.customerId();
      this.personalId = new PersonalIdDomain(customerResponse.personalId());
      this.emailAdress = new EmailAdressDomain(customerResponse.email());
      this.name = customerResponse.name();
   }

   public UUID getCustomerId() {
      return customerId;
   }

   public PersonalIdDomain getPersonalId() {
      return personalId;
   }

   public void setPersonalId(UUID customerId) {
      this.customerId = customerId;
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
      return new CustomerRequest(
            this.getCustomerId(),
            this.getPersonalId().personalId(),
            this.emailAdress.emailAddress(),
            this.getName());
   }

   public CustomerResponse toCustomerResponse() {
      return new CustomerResponse(
            this.getCustomerId(),
            this.getPersonalId().personalId(),
            this.emailAdress.emailAddress(),
            this.getName());
   }
}