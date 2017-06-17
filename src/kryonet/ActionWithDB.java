/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rober
 */
public class ActionWithDB {

    public ActionWithDB() {

    }

    private Connection connect() throws SQLException {
        Connection connection = null;
        String url = "jdbc:sqlite:bingo.db";
        connection = DriverManager.getConnection(url);
        return connection;
    }

    public void createClientTable() {
        String sqlClientTable = "CREATE TABLE IF NOT EXISTS Client (\n"
                + "VariationID INTEGER PRIMARY KEY AUTOINCREMENT, \n"
                + "NumberOne INTEGER, \n"
                + "NumberTwo INTEGER, \n"
                + "NumberThree INTEGER, \n"
                + "NumberFour INTEGER, \n"
                + "NumberFive INTEGER, \n"
                + "Date VARCHAR(255), \n"
                + "ClientEmail VARCHAR(255)\n"
                + "); \n";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sqlClientTable);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void insertIntoClientTable(){
        String sqlInsertIntoDB = "INSERT INTO Client (NumberOne, NumberTwo, "
                + "NumberThree, NumberFour, NumberFive, Date, ClientEmail) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
    }

}
