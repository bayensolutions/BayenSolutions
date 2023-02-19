package com.bayensolutions.model;

public class Pool extends PrefabricatedItem {
    public Pool(Integer id, String name, Double price, String description, Double poolDiameter, Double poolDepth) {
        super(id, name, price, description, poolDiameter, poolDepth);
    }

    @Override
    public String toString() {
        return "Pool{} " + super.toString();
    }
}
