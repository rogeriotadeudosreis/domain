package com.rogerioreis.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private Integer quantity;
	private Double price;

	/*
	 * A notação ManyToOne abaixo neste modelo de projeto indica que nesta entidade
	 * são muitos itens podem indicar apenas para o mesmo produto
	 * 
	 */

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	/*
	 * A notação ManyToOne abaixo neste modelo de projeto também indica nesta
	 * entidade que pode haver muitos itens para apenas um pedido
	 * 
	 * A notação JsonIgnore, impede que o retorno dos dados entre em um lupe
	 * pela associação bidirecional entre itens e pedido.
	 * 
	 */

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderItem() {

	}

	public OrderItem(Long id, Integer quantity, Double price, Product product, Order order) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.order = order;
	}

	public Double getSubTotal() {
		return quantity * price;
	}

}
