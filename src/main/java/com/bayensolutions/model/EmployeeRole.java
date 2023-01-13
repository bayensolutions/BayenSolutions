package com.bayensolutions.model;

public class EmployeeRole {
    private Integer id;
    private String role;

    public EmployeeRole(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

}
