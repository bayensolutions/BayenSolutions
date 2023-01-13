package com.bayensolutions.model;

public class Deck {

    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Double size;
    private Double typeOfMaterial;

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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(Double typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    public Deck(Integer id, String name, Double price, String description, Double size, Double typeOfMaterial) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.size = size;
        this.typeOfMaterial = typeOfMaterial;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", typeOfMaterial=" + typeOfMaterial +
                '}';
    }
}
