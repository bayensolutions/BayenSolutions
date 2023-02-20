package com.bayensolutions.dao;

import com.bayensolutions.model.Item;
import java.util.List;

public interface ItemDAO {
    int createItem(Item item);

    boolean changeItemInformation(Item oldItem, Item newItem);

    Item getItemById(Integer id);

    boolean updateItem(Item item);

    boolean deleteItem(Item item);
}
