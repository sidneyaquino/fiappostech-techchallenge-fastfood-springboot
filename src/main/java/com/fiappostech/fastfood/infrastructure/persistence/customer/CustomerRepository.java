package com.fiappostech.fastfood.infrastructure.persistence.customer;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.infrastructure.persistence.customer.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
   CustomerEntity findByPersonalId(String personalId);
   List<CustomerEntity> findByNameContains(String name);
}