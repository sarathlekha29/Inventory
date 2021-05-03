package com.cg.inventory.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is an entity class for orders with getters, setters, and constructors
 * 
 * @author sharique nooman
 *
 */
@Entity(name = "orders")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	@JsonIgnore
	@NotNull
	@FutureOrPresent
	//@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "order_date", nullable = false)
	private LocalDate orderDate;

	@JsonIgnore
	@Future
	@NotNull
	//@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "delivery_date", nullable = false)
	private LocalDate deliveryDate;

	@Positive
	@NotNull
	@Column(name = "order_amount", nullable = false)
	private Float orderAmount;

	@Positive
	@Column(name = "discount_percentage", nullable = true)
	private Float discountPercentage;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToMany
	@JoinTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> product;

	public Order() {
	}

	public Order(LocalDate orderDate, LocalDate deliveryDate, Float orderAmount, Customer customer,
			List<Product> product) {
		super();
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.orderAmount = orderAmount;
		this.customer = customer;
		this.product = product;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Float getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Float orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return product;
	}

	public void setProducts(List<Product> products) {
		this.product = products;
	}

}