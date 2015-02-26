package no.ntnu.fellesprosjekt34.server;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.sql.*;

public class Database {

    Connection conn = null;
    private String url, username, password;

    public Database(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e){
            System.out.println("Kunne ikke loade DB-driver");
        }
    }
    
    private Connection getConnection() throws SQLException{
        if (conn != null && !conn.isClosed()){
            return conn;
        } else {
            conn = DriverManager.getConnection(url, username, password);
        }
        return conn;
    }

    public ResultSet Q(String query) throws SQLException {
        Statement s = getConnection().createStatement();
        return s.executeQuery(query);
    }
}
