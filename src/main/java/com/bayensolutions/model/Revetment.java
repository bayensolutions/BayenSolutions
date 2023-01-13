package com.bayensolutions.model;

public class Revetment {

    public Revetment(Integer id, String name, Double price, String description, Double scope, Double depth, String typeOfMaterial) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.scope = scope;
        this.depth = depth;
        this.typeOfMaterial = typeOfMaterial;
    }

    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Double scope;
    private Double depth;
    private String typeOfMaterial;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getScope() {
        return scope;
    }

    public void setScope(Double scope) {
        this.scope = scope;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", scope=" + scope +
                ", depth=" + depth +
                ", typeOfMaterial='" + typeOfMaterial + '\'' +
                '}';
    }
}
