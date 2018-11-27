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

		List<Resource<Order>> lOrders = orderRepository.findAll().stream().map(orderResourceAssembler::toResource)
				.collect(Collectors.toList());

		return new Resources<>(lOrders, linkTo(methodOn(OrderController.class).all()).withSelfRel());
	}

	@Override
	public Resource<Order> findById(int pId) {
		return orderResourceAssembler
				.toResource(orderRepository.findById(pId).orElseThrow(() -> new OrderNotFoundException(pId)));
	}

	@Override
	public ResponseEntity<Resource<Order>> save(Order pOrder) {

		pOrder.setStatus(Status.IN_PROGRESS);
		Order lNewOrder = orderRepository.save(pOrder);

		return ResponseEntity.created(linkTo(methodOn(OrderController.class).one(lNewOrder.getId())).toUri())
				.body(orderResourceAssembler.toResource(lNewOrder));
	}

	@Override
	public ResponseEntity<ResourceSupport> cancelById(int id) {
		Order lOrder = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

		if (lOrder.getStatus() == Status.IN_PROGRESS) {
			lOrder.setStatus(Status.CANCELLED);
			return ResponseEntity.ok(orderResourceAssembler.toResource(orderRepository.save(lOrder)));
		}

		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new VndErrors.VndError("Method not allowed",
				"You can't cancel an order that is in the " + lOrder.getStatus() + " status"));
	}

	@Override
	public ResponseEntity<ResourceSupport> completeById(int pId) {
		Order lOrder = orderRepository.findById(pId).orElseThrow(() -> new OrderNotFoundException(pId));

		if (lOrder.getStatus() == Status.IN_PROGRESS) {
			lOrder.setStatus(Status.COMPLETED);
			return ResponseEntity.ok(orderResourceAssembler.toResource(orderRepository.save(lOrder)));
		}

		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new VndErrors.VndError("Method not allowed",
				"You can't complete an order that is in the " + lOrder.getStatus() + " status"));
	}

}
