package com.ratemovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratemovie.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
