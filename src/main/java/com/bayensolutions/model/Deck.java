package com.bayensolutions.model;

public class Deck extends PrefabricatedItem{

    private Double scope;
    private String typeOfMaterial;

    public Deck(Integer id, String name, Double price, String description, Double poolDiameter, Double poolDepth, Double scope, String typeOfMaterial) {
        super(id, name, price, description, poolDiameter, poolDepth);
        this.scope=scope;
        this.typeOfMaterial=typeOfMaterial;
    }

    public Double getScope() {
        return scope;
    }

    public void setScope(Double scope) {
        this.scope = scope;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "scope=" + scope +
                ", typeOfMaterial='" + typeOfMaterial + '\'' +
                "} " + super.toString();
    }
}
