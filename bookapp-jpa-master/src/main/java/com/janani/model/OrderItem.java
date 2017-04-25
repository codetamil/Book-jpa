package com.janani.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Column(name = "quantity")
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
}
