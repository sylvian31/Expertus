package com.expertus.microServiceOrder.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expertus.microServiceOrder.assembler.OrderResourceAssembler;
import com.expertus.microServiceOrder.bean.Order;
import com.expertus.microServiceOrder.bean.Status;
import com.expertus.microServiceOrder.controller.OrderController;
import com.expertus.microServiceOrder.exception.OrderNotFoundException;
import com.expertus.microServiceOrder.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderResourceAssembler orderResourceAssembler;

	@Override
	public Resources<Resource<Order>> findAll() {

		List<Resource<Order>> orders = orderRepository.findAll().stream().map(orderResourceAssembler::toResource)
				.collect(Collectors.toList());

		return new Resources<>(orders, linkTo(methodOn(OrderController.class).all()).withSelfRel());
	}

	@Override
	public Resource<Order> findById(int pId) {
		return orderResourceAssembler
				.toResource(orderRepository.findById(pId).orElseThrow(() -> new OrderNotFoundException(pId)));
	}

	@Override
	public ResponseEntity<Resource<Order>> save(Order order) {

		order.setStatus(Status.IN_PROGRESS);
		Order newOrder = orderRepository.save(order);

		return ResponseEntity.created(linkTo(methodOn(OrderController.class).one(newOrder.getId())).toUri())
				.body(orderResourceAssembler.toResource(newOrder));
	}

	@Override
	public ResponseEntity<ResourceSupport> cancelById(int id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

		if (order.getStatus() == Status.IN_PROGRESS) {
			order.setStatus(Status.CANCELLED);
			return ResponseEntity.ok(orderResourceAssembler.toResource(orderRepository.save(order)));
		}

		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new VndErrors.VndError("Method not allowed",
				"You can't cancel an order that is in the " + order.getStatus() + " status"));
	}

	@Override
	public ResponseEntity<ResourceSupport> completeById(int id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

		if (order.getStatus() == Status.IN_PROGRESS) {
			order.setStatus(Status.COMPLETED);
			return ResponseEntity.ok(orderResourceAssembler.toResource(orderRepository.save(order)));
		}

		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new VndErrors.VndError("Method not allowed",
				"You can't complete an order that is in the " + order.getStatus() + " status"));
	}

}
