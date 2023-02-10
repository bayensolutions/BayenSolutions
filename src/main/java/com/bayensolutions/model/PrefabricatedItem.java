package com.bayensolutions.model;

public class PrefabricatedItem extends Item{
    private double poolDiameter;
    private double poolDepth;

    public PrefabricatedItem(Integer id, String name, Double price, String description,Double poolDiameter,Double poolDepth) {
        super(id, name, price, description);
        this.poolDepth=poolDepth;
        this.poolDiameter=poolDiameter;
    }

    public double getPoolDiameter() {
        return poolDiameter;
    }

    public void setPoolDiameter(double poolDiameter) {
        this.poolDiameter = poolDiameter;
    }

    public double getPoolDepth() {
        return poolDepth;
    }

    public void setPoolDepth(double poolDepth) {
        this.poolDepth = poolDepth;
    }

    @Override
    public String toString() {
        return "PrefabricatedItem{" +
                "poolDiameter=" + poolDiameter +
                ", poolDepth=" + poolDepth +
                "} " + super.toString();
    }
}
