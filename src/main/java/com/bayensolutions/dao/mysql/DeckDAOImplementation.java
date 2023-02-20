package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.DeckDAO;
import com.bayensolutions.model.Deck;
import com.bayensolutions.model.Item;
import com.bayensolutions.model.PrefabricatedItem;
import com.bayensolutions.util.ConnectionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeckDAOImplementation implements DeckDAO {
    @Override
    public List<Deck> getDecks() {
        List<Deck> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihPlatformi()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Deck(rs.getInt(1), rs.getString(2), rs.getDouble(5), rs.getString(6), rs.getDouble(3), rs.getDouble(4), rs.getDouble(7), rs.getString(8)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
        }
        return list;
    }

    @Override
    public boolean createDeck(Deck deck) {
        ItemDAOImplementation itemDAOImplementation = new ItemDAOImplementation();
        int index = itemDAOImplementation.createItem(new Item(deck.getId(), deck.getName(), deck.getPrice(), deck.getDescription()));
        PrefabricatedItemDAOImplementation prefabricatedItemDAOImplementation = new PrefabricatedItemDAOImplementation();
        prefabricatedItemDAOImplementation.createPrefabricatedItem(new PrefabricatedItem(index, deck.getName(), deck.getPrice(), deck.getDescription(), deck.getPoolDiameter(), deck.getPoolDepth()));


        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call kreiranjePlatforme(?,?,?)}";
        boolean result;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatementItem);
            callableStatement.setInt(1, index);
            callableStatement.setDouble(2, deck.getScope());
            callableStatement.setString(3, deck.getTypeOfMaterial());
            result = callableStatement.executeUpdate() == 1;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDeck(Deck deck) {
        ItemDAOImplementation itemDAOImplementation = new ItemDAOImplementation();
        PrefabricatedItemDAOImplementation prefabricatedItemDAOImplementation = new PrefabricatedItemDAOImplementation();
        boolean itemSuccess = itemDAOImplementation.updateItem(new Item(deck.getId(), deck.getName(), deck.getPrice(), deck.getDescription()));
        boolean prefabricatedItemSuccess = prefabricatedItemDAOImplementation.updatePrefabricatedItem(new PrefabricatedItem(deck.getId(), deck.getName(), deck.getPrice(), deck.getDescription(), deck.getPoolDiameter(), deck.getPoolDepth()));

        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call izmjenaPlatforme(?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, deck.getId());
            callableStatement.setDouble(2, deck.getScope());
            callableStatement.setString(3, deck.getTypeOfMaterial());
            result = callableStatement.executeUpdate() == 1;
            return (result && itemSuccess && prefabricatedItemSuccess);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return false;
    }
}
