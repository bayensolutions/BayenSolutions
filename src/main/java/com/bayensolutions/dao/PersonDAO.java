package com.bayensolutions.dao;

import com.bayensolutions.model.Employee;
import com.bayensolutions.model.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getPersons();

    int addPerson(Person person);

    boolean deletePerson(Person person);

    boolean updatePerson(Person person);

    List<Employee> getEmployees();

    boolean addEmployee(Employee employee);

    boolean deleteEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    List<Person> getClients();

}
