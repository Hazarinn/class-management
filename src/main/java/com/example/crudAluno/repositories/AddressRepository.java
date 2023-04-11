package com.example.crudAluno.repositories;

import com.example.crudAluno.entities.Address;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT ad FROM Address ad WHERE ad.id =:id")
    Address getAddressById(@Param("id")Long id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM adresses ad WHERE ad.id = ?1", nativeQuery = true)
    void deleteAdress(@Param("id")Long id);

}
