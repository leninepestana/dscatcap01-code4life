package com.code4life.dscatcap01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code4life.dscatcap01.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
