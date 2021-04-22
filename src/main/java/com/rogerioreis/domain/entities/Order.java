package com.rogerioreis.domain.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "tb_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long Id;

	private Instant moment;

	private OrderStatus status;

	/*
	 * A notação ManyToOne abaixo, neste modelo de projeto indica que pode haver
	 * vários pedidos para um mesmo cliente.
	 * 
	 */

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	/*
	 * E a notação OneToMany, indica que um pedido tem uma lista de itens.
	 */
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items = new ArrayList<>();

	public Order() {

	}

	public Order(Long id, Instant moment, OrderStatus status, Client client) {
		super();
		Id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Double getTotal() {
		double sum = 0.0;

		for (OrderItem item : items) {
			sum += item.getSubTotal();
		}
		return sum;
	}

}
