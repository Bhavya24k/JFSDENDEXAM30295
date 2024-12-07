package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.model.Order;   
                          
import com.klef.jfsd.exam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/insertorder")
    public ModelAndView insertOrder(HttpServletRequest request) {
        String orderId = request.getParameter("orderId");
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String orderDate = request.getParameter("orderDate");
        String customerName = request.getParameter("customerName");

        Order order = new Order();
        order.setOrderId(orderId);
        order.setProductName(productName);
        order.setQuantity(quantity);
        order.setOrderDate(LocalDate.parse(orderDate));
        order.setCustomerName(customerName);

        String message = orderService.addOrder(order);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ordersuccess");
        mv.addObject("message", message);
        return mv;
    }
}