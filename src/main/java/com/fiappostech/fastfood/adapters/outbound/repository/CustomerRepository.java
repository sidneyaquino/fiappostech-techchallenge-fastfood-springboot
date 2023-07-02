package com.fiappostech.fastfood.adapters.outbound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.adapters.outbound.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
   List<CustomerEntity> findByNameContains(String name);  
}