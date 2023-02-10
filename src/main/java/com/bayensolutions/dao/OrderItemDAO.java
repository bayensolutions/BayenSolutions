package com.bayensolutions.dao;

import com.bayensolutions.model.Item;
import com.bayensolutions.model.Order;
import com.bayensolutions.model.OrderItem;
import java.util.List;

public interface OrderItemDAO {
    List<OrderItem> getOrderItems(Order order);

    boolean addOrderItem(Order order, Item item, Integer quantity);
}