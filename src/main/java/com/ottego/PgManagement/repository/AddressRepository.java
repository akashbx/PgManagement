package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
