package no.ntnu.fellesprosjekt34.server;

import java.sql.*;

public class Database {

    Connection conn = null;

    public Database(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e){
            System.out.println("Kunne ikke loade DB-driver");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://bull.ludvigjordet.com/kalender", "kalender", "unagi");
            /*Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM User");
            while(rs.next()){
                System.out.println("Navn: " + rs.getString("firstName") + " " + rs.getString("lastName"));
            }*/
        } catch (SQLException e){
            System.out.println("SQL-feil");
            System.out.println(e.getMessage());
        }
    }
    
    private Connection getConnection(){
        try {
            if (conn != null && !conn.isClosed()){
                return conn;
            } else {
                conn = DriverManager.getConnection("jdbc:mysql://bull.ludvigjordet.com/kalender", "kalender", "unagi");
            }
        } catch (SQLException e) {
            conn = null;
        }
        return conn;
    }

    public ResultSet Q(String query){
        try{
            Statement s = getConnection().createStatement();
            return s.executeQuery(query);
        } catch (SQLException e) {
            return null;
        }
    }
}
