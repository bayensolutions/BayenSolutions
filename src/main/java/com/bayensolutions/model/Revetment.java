package com.bayensolutions.model;

public class Revetment extends PrefabricatedItem {
    private String typeOfMaterial;

    public Revetment(Integer id, String name, Double price, String description, Double poolDiameter, Double poolDepth, String typeOfMaterial) {
        super(id, name, price, description, poolDiameter, poolDepth);
        this.typeOfMaterial=typeOfMaterial;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    @Override
    public String toString() {
        return "Revetment{" +
                "typeOfMaterial='" + typeOfMaterial + '\'' +
                "} " + super.toString();
    }
}
