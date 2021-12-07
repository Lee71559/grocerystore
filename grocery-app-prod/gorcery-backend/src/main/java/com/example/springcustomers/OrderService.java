package com.example.springcustomers;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.springcustomers.*;
import java.util.ArrayList;
import java.util.List;



@Service
@Transactional
public class OrderService {

	@Autowired
	private OrdersRepository orderRepository;

	public List<Orders> listAllOrders() {
		return orderRepository.findAll();
	}

	public Long count() {
		return orderRepository.count();
	}

	public Orders findOrderById(Long id) {
		return orderRepository.findById(id);
	}

	public void updateOrder( String details, Double amount, String status, Long id){
		orderRepository.updateOrder( details, amount, status, id);
	}

	public void save(Orders order) {
		orderRepository.save(order);
	}

	public void updateOrderStatus(String status, Long id){
		orderRepository.updateOrderStatus(status, id);
	}
	
}