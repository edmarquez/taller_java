package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allex
 */
public class MyConnection {
    public Connection  con = null;
    private static MyConnection instance;
    
    private MyConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Connection.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Connection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        try {
            this.con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "Testing021$$"
            );
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        try{
            Logger.getLogger(this.con.getClass().getName()).log(Level.SEVERE, this.con.getMetaData().getUserName().toString());
        }catch(SQLException e){
            Logger.getLogger(MyConnection.class.getName()).
                log(Level.SEVERE, null, e);
        }
    }
    
    public static Connection getConnection(){
        if(MyConnection.instance==null){
            MyConnection.instance = new MyConnection();
        }
        return instance.con;
    }
}
