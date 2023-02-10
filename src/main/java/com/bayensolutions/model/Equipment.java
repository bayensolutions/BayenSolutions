package com.bayensolutions.model;

public class Equipment extends Item{
    private Integer warrantyDuration;
    private EquipmentProducer equipmentProducer;
    private EquipmentType equipmentType;

    public Equipment(Integer id, String name, Double price, String description, Integer warrantyDuration, EquipmentProducer equipmentProducer, EquipmentType equipmentType) {
        super(id, name, price, description);
        this.warrantyDuration=warrantyDuration;
        this.equipmentProducer=equipmentProducer;
        this.equipmentType=equipmentType;
    }

    public Integer getWarrantyDuration() {
        return warrantyDuration;
    }

    public void setWarrantyDuration(Integer warrantyDuration) {
        this.warrantyDuration = warrantyDuration;
    }

    public EquipmentProducer getEquipmentProducer() {
        return equipmentProducer;
    }

    public void setEquipmentProducer(EquipmentProducer equipmentProducer) {
        this.equipmentProducer = equipmentProducer;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "warrantyDuration=" + warrantyDuration +
                ", equipmentProducer=" + equipmentProducer +
                ", equipmentType=" + equipmentType +
                "} " + super.toString();
    }
}
