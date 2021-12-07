package com.example.grocery;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrderItemRepository extends JpaRepository<Order_item, Long> {

}