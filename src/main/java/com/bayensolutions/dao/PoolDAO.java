package com.bayensolutions.dao;

import com.bayensolutions.model.Material;
import com.bayensolutions.model.Pool;

import java.util.List;

public interface PoolDAO {
    List<Pool> getPools();

    boolean createPool(Pool pool);

    boolean updatePool(Pool pool);

    boolean deletePool(Pool pool);
}
