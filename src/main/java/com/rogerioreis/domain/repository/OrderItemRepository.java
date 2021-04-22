package com.rogerioreis.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogerioreis.domain.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
