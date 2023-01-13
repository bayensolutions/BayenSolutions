package com.bayensolutions.dao;

import com.bayensolutions.model.Employee;
import com.bayensolutions.model.Material;

import java.util.List;

public interface PurchaseOrderDAO {
    int createPurchaseOrder(int partnerCompanyId, int employeeId);

    boolean addMaterialToPurchaseOrder(int materialId, int purchaseOrderId, double quantity, double purchasePrice);

    boolean changePurchaseOrderStatus(int orderId, int status);

    boolean changeMaterialQuantity(int orderId);

    List<Material> getPurchaseOrderItems(int purchaseOrderId);

}
