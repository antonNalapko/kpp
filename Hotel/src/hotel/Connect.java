/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Anton
 */
public class Connect {
    private String url;
    private String driver;
    Connection conn = null;

    public Connect(String driver, String url) {
        this.driver=driver;
        this.url=url;
    try {
        Class.forName(this.driver);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
    }

    try {

        this.conn = DriverManager.getConnection(this.url);
       
        
    } catch (SQLException ex) {
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public Connection getCon() {
        return conn;
    }

    public void setCon(Connection con) {
        this.conn = con;
    }
}
