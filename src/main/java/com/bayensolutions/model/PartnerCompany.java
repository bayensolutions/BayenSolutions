package com.bayensolutions.model;

public class PartnerCompany {

    private Integer id;
    private String name;
    private String telephone;
    private String email;
    private String address;

    public PartnerCompany(Integer id, String name, String telephone, String email, String address) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PartnerCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
