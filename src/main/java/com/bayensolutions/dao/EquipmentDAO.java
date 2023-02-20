package com.bayensolutions.dao;

import com.bayensolutions.model.Equipment;
import java.util.List;

public interface EquipmentDAO {
    List<Equipment> getEquipment();

    boolean createEquipment(Equipment equipment);

    boolean updateEquipment(Equipment equipment);
}
