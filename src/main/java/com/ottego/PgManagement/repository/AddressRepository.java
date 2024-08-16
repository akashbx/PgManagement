package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.Dto.AddressDetail;
import com.ottego.PgManagement.model.Address;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> , JpaSpecificationExecutor<Address> {


}
