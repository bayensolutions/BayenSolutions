package com.bayensolutions.model;

public class Pool {

    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Double diameter;
    private Double depth;

    public Pool(){
        super();
    }

    public Pool(Integer id, String name, Double price, String description, Double diameter, Double depth) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.diameter = diameter;
        this.depth = depth;
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

    @Override
    public String toString() {
        return "Pool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", diameter=" + diameter +
                ", depth=" + depth +
                '}';
    }
}
