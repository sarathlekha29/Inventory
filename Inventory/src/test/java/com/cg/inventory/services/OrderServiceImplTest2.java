package com.cg.inventory.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.inventory.model.Category;
import com.cg.inventory.model.Customer;
import com.cg.inventory.model.Order;
import com.cg.inventory.model.Product;
import com.cg.inventory.repositories.OrdersRepository;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = OrderServiceImpl.class)
class OrderServiceImplTest2 {

	private List<Product> products;
	private Customer customer;
	private Category category;

	@MockBean
	private OrdersRepository ordersRepository;

	@Autowired
	private OrderServiceImpl orderService;

	@Before
	public void setUp() throws Exception {
		category = new Category("School", "This category contains school stuff");
		category.setCategoryId(1L);
		Product product = new Product("bag", "bag for school", 30L, 200f, category);
		product.setProductId(10L);
		products = new ArrayList<>();
		products.add(product);
		customer = new Customer("shariq", "9901738798", "bangalore", "shariq@gmail.com", "shariq store");
		customer.setCustomerId(10L);
	}

	@After
	public void tearDown() throws Exception {
		products.clear();
		customer = null;
		category = null;
	}

	@Test
	public void testViewAllOrders() {
		Order order = new Order(LocalDate.now(), LocalDate.of(2021, 7, 30), 1200f, customer, products);
		Order order1 = new Order(LocalDate.now(), LocalDate.of(2021, 8, 30), 1400f, customer, products);
		Order order2 = new Order(LocalDate.now(), LocalDate.of(2021, 9, 30), 1600f, customer, products);

		List<Order> orders = new ArrayList<>();
		orders.add(order2);
		orders.add(order1);
		orders.add(order);

		Mockito.when(ordersRepository.findAll()).thenReturn(orders);
		assertThat(orderService.viewAllOrders()).isEqualTo(orders);
		assertEquals(3, orderService.viewAllOrders().size());

		verify(ordersRepository, times(2)).findAll();
	}

	@Test
	public void testCreateOrder() {
		Order order = new Order(LocalDate.now(), LocalDate.of(2021, 7, 30), 1200f, customer, products);

		Mockito.when(ordersRepository.saveAndFlush(order)).thenReturn(order);
		assertThat(orderService.createOrder(order)).isEqualTo(order);

		verify(ordersRepository).saveAndFlush(order);
	}

	@Test
	public void testDeleteOrder() {
		Order order = new Order(LocalDate.now(), LocalDate.of(2021, 7, 30), 1200f, customer, products);
		order.setOrderId(10L);

		orderService.deleteOrder(order.getOrderId());
		verify(ordersRepository, times(1)).deleteById(order.getOrderId());
	}

	@Test
	public void testViewOrderById() {
		Order order = new Order(LocalDate.now(), LocalDate.of(2021, 7, 30), 1200f, customer, products);
		order.setOrderId(20L);

		Mockito.when(ordersRepository.findById(order.getOrderId())).thenReturn(Optional.of(order));
		assertThat(orderService.viewOrderById(20L)).isEqualTo(order);

		verify(ordersRepository).findById(order.getOrderId());
	}

	@Test
	public void testUpdateOrder() {
		Order order = new Order(LocalDate.now(), LocalDate.of(2021, 7, 30), 1200f, customer, products);
		order.setOrderId(30L);

		Order updatedOrder = order;
		updatedOrder.setOrderId(30L);
		updatedOrder.setCustomer(customer);
		updatedOrder.setProducts(products);
		updatedOrder.setDeliveryDate(LocalDate.of(2021, 6, 30));
		updatedOrder.setOrderAmount(500f);
		updatedOrder.setOrderDate(LocalDate.of(2021, 5, 15));

		Mockito.when(ordersRepository.saveAndFlush(updatedOrder)).thenReturn(updatedOrder);
		Mockito.when(ordersRepository.findById(order.getOrderId())).thenReturn(Optional.of(order));
		orderService.updateOrder(order.getOrderId(), updatedOrder);

		assertThat(order.getOrderAmount()).isEqualTo(updatedOrder.getOrderAmount());
		verify(ordersRepository).saveAndFlush(updatedOrder);
	}


}
