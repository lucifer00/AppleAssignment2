package com.ratemovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratemovie.entity.Customer;
/*Jpa repository for Customer entity*/
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
