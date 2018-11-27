package com.expertus.microServiceOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import com.expertus.microServiceOrder.service.IOrderService;

@RestController
public class OrderController {

	/**
	 * The Environment
	 */
	private final Environment env;

	/** The order service */
	private final IOrderService orderService;

	/**
	 * Constructor
	 * 
	 * @param pOrderService
	 */
	public OrderController(IOrderService pOrderService, Environment pEnv) {
		this.orderService = pOrderService;
		this.env = pEnv;
	}

	/* -------------- Get -------------- */

	/**
	 * Home show
	 * 
	 * @return service name
	 */
	@GetMapping(value = GlobalPropertiesPath.ROUTE_ORDER_HOME, produces = MediaType.APPLICATION_JSON_VALUE)
	public String home() {
		return "Hello from Order Service running at port: " + env.getProperty("local.server.port");
	}

	/**
	 * Get all orders
	 * 
	 * @return list order
	 */
	@GetMapping(value = GlobalPropertiesPath.ROUTE_ORDER_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<Resource<Order>> all() {
		return orderService.findAll();
	}

	/**
	 * Get a order by id
	 * 
	 * @param id
	 * @return a order
	 */
	@GetMapping(value = GlobalPropertiesPath.ROUTE_ORDER_ID, produces = MediaType.APPLICATION_JSON_VALUE)
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
	@PostMapping(value = GlobalPropertiesPath.ROUTE_ORDER_ADD, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource<Order>> newOrder(@RequestBody Order order) {
		return orderService.save(order);
	}

	/**
	 * cancel a Order by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = GlobalPropertiesPath.ROUTE_ORDER_CANCEL, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResourceSupport> cancel(@PathVariable int id) {
		return orderService.cancelById(id);
	}

	/**
	 * Update a order by id
	 * 
	 * @param id
	 * @return Order
	 */
	@PutMapping(value = GlobalPropertiesPath.ROUTE_ORDER_COMPLETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResourceSupport> complete(@PathVariable int id) {
		return orderService.completeById(id);
	}

}
