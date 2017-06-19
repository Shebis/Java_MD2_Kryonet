/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rober
 */
public class ActionWithDB {

    public ActionWithDB() {

    }

    /**
     *
     * @return connection
     * @throws SQLException
     */
    private Connection connect() throws SQLException {
        Connection connection = null;
        String url = "jdbc:sqlite:bingo.db";
        connection = DriverManager.getConnection(url);
        return connection;
    }

    /**
     *
     */
    public void createClientTable() {
//        String sqlDropTable = "DROP TABLE IF EXISTS Client";
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
//            stmt.execute(sqlDropTable);
            stmt.execute(sqlClientTable);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param variation
     * @throws SQLException
     */
    public void insertIntoClientTable(Variation variation) throws SQLException {
        String sqlInsertIntoDB = "INSERT INTO Client (NumberOne, NumberTwo, "
                + "NumberThree, NumberFour, NumberFive, Date, ClientEmail) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sqlInsertIntoDB)) {
            //for (Packet02Variation packet02Variation : variation ) {
            pstmt.setInt(1, variation.getList().get(0));
            pstmt.setInt(2, variation.getList().get(1));
            pstmt.setInt(3, variation.getList().get(2));
            pstmt.setInt(4, variation.getList().get(3));
            pstmt.setInt(5, variation.getList().get(4));
            pstmt.setString(6, variation.getDate().toString());
            pstmt.setString(7, variation.getClientEmail());

            pstmt.executeUpdate();
        }
    }

    /**
     *
     */
    public void selectFromClientTable() throws SQLException {
        ArrayList<Integer> numbers = new ArrayList<>();
        String sqlSelectFromClient = "SELECT * FROM Client";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sqlSelectFromClient)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("VariationID");
                int numbOne = rs.getInt("NumberOne");
                int numbTwo = rs.getInt("NumberTwo");
                int numbThree = rs.getInt("NumberThree");
                int numbFour = rs.getInt("NumberFour");
                int numbFive = rs.getInt("NumberFive");
                String date = rs.getString("Date");
                String email = rs.getString("ClientEmail");
                
//                numbers
            }
        }
    }

}
