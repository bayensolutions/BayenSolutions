package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.DeckDAO;
import com.bayensolutions.model.Deck;
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
                list.add(new Deck(rs.getInt(1),rs.getString(2),rs.getDouble(5),rs.getString(6),rs.getDouble(3),rs.getDouble(4),rs.getDouble(7),rs.getString(8)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
        }
        return list;
    }
}
