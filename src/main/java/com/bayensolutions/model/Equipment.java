package com.bayensolutions.model;

public class Equipment {

    private Integer id;
    private Integer warrantyDuration;
    private Integer equipmentProducerId;
    private Integer equipmentTypeId;

    public Equipment(Integer id, Integer warrantyDuration, Integer equipmentProducerId, Integer equipmentTypeId) {
        this.id = id;
        this.warrantyDuration = warrantyDuration;
        this.equipmentProducerId = equipmentProducerId;
        this.equipmentTypeId = equipmentTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarrantyDuration() {
        return warrantyDuration;
    }

    public void setWarrantyDuration(Integer warrantyDuration) {
        this.warrantyDuration = warrantyDuration;
    }

    public Integer getEquipmentProducerId() {
        return equipmentProducerId;
    }

    public void setEquipmentProducerId(Integer equipmentProducerId) {
        this.equipmentProducerId = equipmentProducerId;
    }

    public Integer getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Integer equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", warrantyDuration=" + warrantyDuration +
                ", equipmentProducerId=" + equipmentProducerId +
                ", equipmentTypeId=" + equipmentTypeId +
                '}';
    }
}
