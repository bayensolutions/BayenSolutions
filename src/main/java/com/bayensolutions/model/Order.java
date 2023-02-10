package com.bayensolutions.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private Integer id;
    private Person person;
    private LocalDateTime dateTime;
    private Integer status;
    private Double totalPrice;
    private String poolMountingAddress;

    public Order(Integer id, Person person, LocalDateTime dateTime, Integer status, Double totalPrice, String poolMountingAddress) {
        this.id = id;
        this.person = person;
        this.dateTime = dateTime;
        this.status = status;
        this.totalPrice = totalPrice;
        this.poolMountingAddress = poolMountingAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPoolMountingAddress() {
        return poolMountingAddress;
    }

    public void setPoolMountingAddress(String poolMountingAddress) {
        this.poolMountingAddress = poolMountingAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", person=" + person +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                ", poolMountingAddress='" + poolMountingAddress + '\'' +
                '}';
    }
}
