package com.bayensolutions.model;

public class Person {
    private Integer id;
    private String name;
    private String surname;
    private String telephone;
    private Place place;

    public Person(int id, String name, String surname, String telephone, Place place) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return name+" "+surname;
    }
}
