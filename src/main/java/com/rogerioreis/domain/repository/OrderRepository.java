package com.rogerioreis.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rogerioreis.domain.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	

}
