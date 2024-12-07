package com.klef.jfsd.exam.service;

import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Order;

@Service
public interface OrderService {

    public String addOrder(Order order);

    public Order getOrderById(String orderId);
}