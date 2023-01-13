package com.bayensolutions.dao;

import com.bayensolutions.model.Material;

import java.util.List;

public interface MaterialDAO {

    double checkMaterialQuantity(int materialId,double materialQuantity);

    boolean createMaterial(String name, double materialQuantity, int measurementUnitId, int materialTypeId);

    boolean deleteMaterial(int materialId);

    List<Material> getMaterialItems(String name);

   boolean updateMaterial(Material material);
}
