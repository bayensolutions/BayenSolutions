package com.bayensolutions.dao;

import com.bayensolutions.model.Revetment;

import java.util.List;

public interface RevetmentDAO {
    List<Revetment> getRevetments();

    boolean createRevetment(Revetment revetment);

    boolean updateRevetment(Revetment revetment);
}
