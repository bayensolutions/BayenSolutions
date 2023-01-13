package com.bayensolutions.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Bill {

    private Integer id;
    private LocalDateTime dateTime;
    private Double transportPrice;
    private Double totalPrice;
    private Set<Item> itemSet =new HashSet<>();

    public Bill(Integer id, LocalDateTime dateTime, Double transportPrice, Double totalPrice) {
        this.id = id;
        this.dateTime = dateTime;
        this.transportPrice = transportPrice;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(Double transportPrice) {
        this.transportPrice = transportPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", transportPrice=" + transportPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
