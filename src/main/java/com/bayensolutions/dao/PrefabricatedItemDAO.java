package com.bayensolutions.dao;

import com.bayensolutions.model.PrefabricatedItem;

public interface PrefabricatedItemDAO {
    boolean createPrefabricatedItem(PrefabricatedItem prefabricatedItem);

    boolean updatePrefabricatedItem(PrefabricatedItem prefabricatedItem);
}
