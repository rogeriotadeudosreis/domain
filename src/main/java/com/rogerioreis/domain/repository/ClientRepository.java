package com.rogerioreis.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogerioreis.domain.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
