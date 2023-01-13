package com.bayensolutions.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private Integer id;
    private Integer personId;
    private LocalDateTime dateTime;
    private Integer status;
    private Double totalPrice;
    private String poolMountingAddress;

    public Order(){
        super();
    }

    public Order(Integer id, Integer personId, LocalDateTime dateTime, Integer status, Double totalPrice, String poolMountingAddress) {
        this.id = id;
        this.personId = personId;
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

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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
                ", personId='" + personId + '\'' +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                ", poolMountingAddress='" + poolMountingAddress + '\'' +
                '}';
    }
}
