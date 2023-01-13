package com.bayensolutions.model;

public class Employee extends Person {

    private String nickname;
    private String passwordHash;
    private Double salary;
    private EmployeeRole employeeRole;
    private String uniqueIdentificationNumber;

    public Employee(int id, String name, String surname, String telephone, Place place, String nickname, String passwordHash, Double salary, EmployeeRole employeeRole, String uniqueIdentificationNumber) {
        super(id, name, surname, telephone, place);
        this.nickname = nickname;
        this.passwordHash = passwordHash;
        this.salary = salary;
        this.employeeRole = employeeRole;
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getUniqueIdentificationNumber() {
        return uniqueIdentificationNumber;
    }

    public void setUniqueIdentificationNumber(String uniqueIdentificationNumber) {
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nickname='" + nickname + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", salary=" + salary +
                ", employeeRole=" + employeeRole +
                ", uniqueIdentificationNumber='" + uniqueIdentificationNumber + '\'' +
                '}';
    }
}