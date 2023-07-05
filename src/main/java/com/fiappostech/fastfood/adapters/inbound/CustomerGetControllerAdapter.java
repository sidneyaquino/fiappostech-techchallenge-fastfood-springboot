package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.response.CustomerResponseDTO;
import com.fiappostech.fastfood.application.ports.inbound.CustomerIdentifyInputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerGetControllerAdapter {

   private final CustomerIdentifyInputPort customerIdentifyInputPort;

   @GetMapping("/{personalId}")
   public ResponseEntity<Object> customerFindById(@PathVariable String personalId) {
      try {
         var customerResponse = customerIdentifyInputPort.execute(personalId);
         return ResponseEntity.status(HttpStatus.OK).body(new CustomerResponseDTO(customerResponse));

      // } catch (CustomerNotFoundException e) {
      //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }
}