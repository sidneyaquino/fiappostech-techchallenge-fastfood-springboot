package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.request.CustomerRequestDTO;
import com.fiappostech.fastfood.adapters.inbound.dto.response.CustomerResponseDTO;
import com.fiappostech.fastfood.application.ports.inbound.CustomerRegistryInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerPostControllerAdapter {

   private final CustomerRegistryInputPort customerRegistryInputPort;

   @PostMapping
   public ResponseEntity<CustomerResponseDTO> save(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {

      try {
         var customerResponse = customerRegistryInputPort.execute(customerRequestDTO.toCustomerRequest());
         return ResponseEntity.status(HttpStatus.CREATED).body(new CustomerResponseDTO(customerResponse));

      // } catch (DataIntegrityViolationException e) {
      //    return ResponseEntity.status(HttpStatus.CONFLICT).build();

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }
}