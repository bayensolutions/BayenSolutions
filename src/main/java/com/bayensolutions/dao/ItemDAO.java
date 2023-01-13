package com.bayensolutions.dao;

import com.bayensolutions.model.Item;
import java.util.List;

public interface ItemDAO {
    int createItem(Item item);

    boolean changeItemInformation(Item oldItem, Item newItem);

    List<Item> getItems();

    boolean deleteItem(Item item);
}
