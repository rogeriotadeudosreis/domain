package com.rogerioreis.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rogerioreis.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	

}
