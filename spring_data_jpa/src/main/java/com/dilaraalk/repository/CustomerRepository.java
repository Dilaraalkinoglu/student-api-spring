package com.dilaraalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dilaraalk.entites.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
