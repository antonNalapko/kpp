/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anton
 */
public class ControllerSql implements HotelNumberDAO{
    private Connection con=null;
    private Statement stmt=null;

public  ControllerSql(Connection con) throws SQLException {
        this.con = con;
        this.stmt=this.con.createStatement();
    }

public ResultSet  searchHotelNumberSql(String query) throws SQLException{
    return stmt.executeQuery(query);
}

public int deleteHotelNumberSql(int id) throws SQLException{
    String query = "delete from tableHOTELNUMBER where id = "+String.valueOf(id);
    int result = this.stmt.executeUpdate(query);
    return result;
}

public int  addHotelNumberSql(String number, String type, int floor, String name, int employment) throws SQLException{
        String query="INSERT INTO tableHOTELNUMBER  (\"number\",\"type\",\"floor\",\"name\",\"employment\") VALUES (\""+number+"\",\""
                +type+"\",\""+floor+"\",\""+name+"\",\""+employment+"\")";
        System.out.println(query);
        int result=this.stmt.executeUpdate(query);
        System.out.println(result);
        return result;
    }

public int  updateHotelNumberSql(String number, String name, int employment) throws SQLException{
        String query="UPDATE tableHOTELNUMBER SET name=\""+name+"\",employment=\""+employment+"\" WHERE number=\""+number+"\"";
        System.out.println(query);
        int result=this.stmt.executeUpdate(query);
        System.out.println(result);
        return result;
    }
    
    
    @Override
    public void createHotelNumber(HotelNumber hotelNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readHotelNumber(HotelNumber hotelNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateHotelNumber(HotelNumber hotelNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteHotelNumber(HotelNumber hotelNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
