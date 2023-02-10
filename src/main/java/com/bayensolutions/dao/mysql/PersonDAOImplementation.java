package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.PersonDAO;
import com.bayensolutions.model.*;
import com.bayensolutions.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImplementation implements PersonDAO {

    @Override
    public List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihOsoba()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),new Place(rs.getString(5),rs.getString(6))));
            System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }

    @Override
    public int addPerson(Person person) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        String callStatementItem = "{call dodavanjeOsobe(?,?,?,?,?)}";
        boolean result=false;
        int personId = 0;

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setString(1,person.getName());
            callableStatement.setString(2,person.getSurname());
            callableStatement.setString(3,person.getTelephone());
            callableStatement.setString(4,person.getPlace().getZipCode());
            callableStatement.registerOutParameter(5, Types.INTEGER);
            result=callableStatement.executeUpdate() == 1;
            personId=callableStatement.getInt(5);
            return personId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean deletePerson(Person person) {
        boolean result = false;
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        String callStatementItem = "{call brisanjeOsobe(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatementItem);
            callableStatement.setInt(1, person.getId());
            result = callableStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return result;
    }

    @Override
    public boolean updatePerson(Person person) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call izmjenaOsobe(?,?,?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, person.getId());
            callableStatement.setString(2,person.getName());
            callableStatement.setString(3,person.getSurname());
            callableStatement.setString(4,person.getTelephone());
            callableStatement.setString(5,person.getPlace().getZipCode());
            result=callableStatement.executeUpdate() == 1;
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return false;
    }

    @Override
    public boolean addEmployee(Employee employee) {

        int personId=addPerson(new Person(employee.getId(),employee.getName(),employee.getSurname(),employee.getTelephone(),new Place(employee.getPlace().getZipCode(),employee.getPlace().getName())));

        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call dodavanjeZaposlenog(?,?,?,?,?,?)}";
        boolean result=false;

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setInt(1,personId);
            callableStatement.setString(2,employee.getNickname());
            callableStatement.setString(3,employee.getPasswordHash());
            callableStatement.setDouble(4,employee.getSalary());
            callableStatement.setString(5,employee.getUniqueIdentificationNumber());
            callableStatement.setInt(6,employee.getEmployeeRole().getId());

            result=callableStatement.executeUpdate() == 1;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee){
        boolean result = false;
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        String callStatementItem = "{call brisanjeZaposlenog(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatementItem);
            callableStatement.setInt(1, employee.getId());
            result = callableStatement.executeUpdate() == 1;
            if(result==true)
                deletePerson(new Person(employee.getId(),employee.getName(),employee.getSurname(),employee.getTelephone(),new Place(employee.getPlace().getZipCode(),employee.getPlace().getName())));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return result;

    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call izmjenaZaposlenog(?,?,?,?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1,employee.getId());
            callableStatement.setString(2,employee.getNickname());
            callableStatement.setString(3,employee.getPasswordHash());
            callableStatement.setDouble(4,employee.getSalary());
            callableStatement.setString(5,employee.getUniqueIdentificationNumber());
            callableStatement.setInt(6,employee.getEmployeeRole().getId());

            result=callableStatement.executeUpdate() == 1;
            if(result==true)
                updatePerson(new Person(employee.getId(),employee.getName(),employee.getSurname(),employee.getTelephone(),new Place(employee.getPlace().getZipCode(),employee.getPlace().getName())));
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return false;
    }

    @Override
    public List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihZaposlenih()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),new Place(rs.getString(5),rs.getString(6)), rs.getString(7),rs.getString(8),rs.getDouble(9),new EmployeeRole(rs.getInt(10),rs.getString(11)),rs.getString(12)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }

    @Override
    public List<Person> getClients(){
        List<Person> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihKlijenata()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),new Place(rs.getString(5),rs.getString(6))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }


}
