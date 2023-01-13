package com.bayensolutions.model;

public class MeasurementUnit {

    private Integer id;
    private String mark;

    public MeasurementUnit(Integer id, String mark) {
        this.id = id;
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "MeasurementUnit{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                '}';
    }

}
