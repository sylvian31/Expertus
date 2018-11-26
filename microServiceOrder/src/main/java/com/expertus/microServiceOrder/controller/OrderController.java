package com.expertus.microServiceOrder.controller;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expertus.microServiceOrder.GlobalPropertiesPath;
import com.expertus.microServiceOrder.bean.Order;
import com.expertus.microServiceOrder.service.OrderService;

@RestController
public class OrderController {

	/** The order service */
	private final OrderService orderService;

	/**
	 * Constructor
	 * @param pOrderService
	 */
	public OrderController(OrderService pOrderService) {
		this.orderService = pOrderService;
	}
	
	/* -------------- Get -------------- */

	/**
	 * Home show
	 * 
	 * @return service name
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_ORDER_HOME_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String home() {
		return "Welcome to Order api";
	}

	/**
	 * Get all orders
	 * 
	 * @return list order
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_ORDER_ALL_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<Resource<Order>> all() {
		return orderService.findAll();
	}

	/**
	 * Get a order by id
	 * 
	 * @param id
	 * @return a order
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_ORDER_ID_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Order> one(@PathVariable int id) {
		return orderService.findById(id);
	}
	
	/* -------------- Post -------------- */
	/**
	 * Add a new Order
	 * 
	 * @param order
	 * @return
	 */
	@PostMapping(value = "${" + GlobalPropertiesPath.ROUTE_ORDER_ADD_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource<Order>> newOrder(@RequestBody Order order) {
		return orderService.save(order);
	}

	/**
	 * cancel a Order by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "${" + GlobalPropertiesPath.ROUTE_ORDER_CANCEL_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResourceSupport> cancel(@PathVariable int id) {
		return orderService.cancelById(id);
	}

	/**
	 * Update a order by id
	 * 
	 * @param id
	 * @return Order
	 */
	@PutMapping(value = "${" + GlobalPropertiesPath.ROUTE_ORDER_COMPLETE_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResourceSupport> complete(@PathVariable int id) {
		return orderService.completeById(id);
	}

}
