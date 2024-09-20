package com.webservice.sales.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    @Column
    private String item_description; // This would be orderline in a proper database design
    @Column
    private String price_paid;
    @Column
    private int customer_id;
    @Column
    private String status;

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", item_description='" + item_description + '\'' +
                ", price_paid='" + price_paid + '\'' +
                ", status='" + status + '\'' +
                ", customer_id=" + customer_id +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getPrice_paid() {
        return price_paid;
    }

    public void setPrice_paid(String price_paid) {
        this.price_paid = price_paid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
