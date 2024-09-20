package com.webservice.sales.Controller;

import com.webservice.sales.Models.Customer;
import com.webservice.sales.Models.Order;

public class OrderRequest {
    private Customer customer;
    private Order order;

    // Getters and setters
    public Customer getCustomer() {
        //System.out.println(customer.toString());
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        //System.out.println(order.toString());
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
