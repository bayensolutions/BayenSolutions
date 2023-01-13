package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.PurchaseOrderDAO;
import com.bayensolutions.model.Material;
import com.bayensolutions.model.PurchaseOrder;
import com.bayensolutions.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderDAOImplementation implements PurchaseOrderDAO {

    @Override
    public int createPurchaseOrder(int partnerCompanyId, int employeeId){
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call kreiranjeNarudžbenice(?,?,?)}";
        int result;

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setInt(1,partnerCompanyId);
            callableStatement.setInt(2,employeeId);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.executeUpdate();
            result = callableStatement.getInt(3);
            //System.out.println("Rezultat: " + result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean addMaterialToPurchaseOrder(int materialId, int purchaseOrderId, double quantity, double purchasePrice) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call dodavanjeMaterijalaNaNarudžbenicu(?,?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, materialId);
            callableStatement.setInt(2,purchaseOrderId);
            callableStatement.setDouble(3,quantity);
            callableStatement.setDouble(4,purchasePrice);

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
    public boolean changePurchaseOrderStatus(int orderId, int status) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call promjenaStatusaNarudžbenice(?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, orderId);
            callableStatement.setInt(2,status);
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
    public boolean changeMaterialQuantity(int orderId) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call promjenaKoličineMaterijala(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, orderId);
            result=callableStatement.executeUpdate() == 1;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return false;
    }

    @Override
    public List<Material> getPurchaseOrderItems(int purchaseOrderId) {

        List<Material> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeMaterijalaNaNarudžbenici(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, purchaseOrderId);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Material(rs.getInt("MATERIJAL_IdMaterijal"),rs.getString("Naziv"),rs.getDouble("Količina"),rs.getInt("MJERNA_JEDINICA_IdMjernaJedinica"),rs.getInt("PARTNERSKA_KOMPANIJA_IdPartnerskaKompanija")));
            System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }
}
