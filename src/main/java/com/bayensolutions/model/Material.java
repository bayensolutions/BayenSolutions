package com.bayensolutions.model;

public class Material {

    private Integer id;
    private String name;
    private Double quantity;
    private Integer idMaterialType;
    private Integer idMeasurementUnit;

    public Material(Integer id, String name, Double quantity, Integer idMeasurementUnit, Integer idMaterialType) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.idMaterialType = idMaterialType;
        this.idMeasurementUnit = idMeasurementUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getIdMaterialType() {
        return idMaterialType;
    }

    public void setPurchasePrice(Integer idMaterialType) {
        this.idMaterialType = idMaterialType;
    }

    public Integer getIdMeasurementUnit() {
        return idMeasurementUnit;
    }

    public void setIdMeasurementUnit(Integer idMeasurementUnit) {
        this.idMeasurementUnit = idMeasurementUnit;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", idMaterialType=" + idMaterialType +
                ", idMeasurementUnit=" + idMeasurementUnit +
                '}';
    }
}
