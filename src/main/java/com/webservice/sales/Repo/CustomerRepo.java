package com.webservice.sales.Repo;

import com.webservice.sales.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.emailAddress = :emailAddress")
    Optional<Customer> findCustomerByEmailAddress(@Param("emailAddress") String emailAddress);


}
