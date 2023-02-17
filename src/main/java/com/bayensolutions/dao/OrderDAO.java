package com.bayensolutions.dao;

import com.bayensolutions.model.Order;
import com.bayensolutions.model.Item;
import com.bayensolutions.model.OrderItem;

import java.util.List;

public interface OrderDAO {

    int createOrder(Order order);

    boolean changeOrderStatus(Order order, int status);

    boolean addOrderItemToOrder(Item item, Order order, int quantity);

    List<OrderItem> getOrderItems(Order order);

    double calculateTotalPrice(Order order);

    boolean changeTotalPrice(Order order, double price);

    List<Order> getOrders();

    boolean deleteOrder(Order order);

    boolean editOrderInfo(Order newOrder);
}
