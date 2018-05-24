/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public final class Database {

    private final String url = "jdbc:postgresql://ebjerg.duckdns.org:5432/SensumUdred";
    private final String user = "DBSDU-manager";
    private final String password = "JegElskerP1zza*100";
    private Connection conn = null;

    public Database() {
        connect();
    }

    public void close() throws SQLException {
        conn.close();
    }

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver Registered!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ResultSet query(String SQL) {
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            System.out.println("Query successful.");
            close();
            return rs;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
