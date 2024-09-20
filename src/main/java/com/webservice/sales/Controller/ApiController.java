package com.webservice.sales.Controller;

import com.webservice.sales.Models.Customer;
import com.webservice.sales.Models.Order;
import com.webservice.sales.Repo.CustomerRepo;
import com.webservice.sales.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderRepo orderRepo;
    @GetMapping(value = "/")
    public String landingPage(){
        return "Hello";
    }
    @GetMapping(value = "/customers")
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    @GetMapping(value = "/orders")
    public List<Order> getOrders(){
        return orderRepo.findAll();
    }

    @GetMapping(value = "/order/{id}")
    public OrderRequest getOrder(@PathVariable int id){
        Order order = orderRepo.findById(id).orElse(null);
        Customer customer = customerRepo.findById(order.getCustomer_id()).orElse(null);
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrder(order);
        orderRequest.setCustomer(customer);
        return orderRequest;
    }

    @PostMapping(value = "/customers/post")
    public int saveCustomer(@RequestBody Customer customer){
        System.out.println(customer.getEmailAddress());

        Optional<Customer> existingCustomer = customerRepo.findCustomerByEmailAddress(customer.getEmailAddress());

        if(existingCustomer.isPresent()) customer.setCustomer_id(existingCustomer.get().getCustomer_id());

        return customerRepo.save(customer).getCustomer_id();
    }

    @PostMapping(value = "/orders/post")
    public int saveOrder(@RequestBody OrderRequest orderRequest){
        Customer customer = orderRequest.getCustomer();
        Order order = orderRequest.getOrder();
        order.setStatus("Sipariş Alındı.");
        saveCustomer(customer);
        Optional<Customer> customer1 = customerRepo.findCustomerByEmailAddress(customer.getEmailAddress());
        order.setCustomer_id(customer1.get().getCustomer_id());
        Order savedOrder = orderRepo.save(order);

        return savedOrder.getOrder_id();
    }

    @PutMapping(value = "/orders/put/{id}")
    public void updateOrder(@PathVariable int id){
        Order order = orderRepo.findById(id).orElse(null);
        order.setStatus("İade Edildi.");
        orderRepo.save(order);
    }


}
