package hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anton
 */
public class Hotel {
    private static ControllerSql kontr=null;
    public static void main(String[] args) {

        System.out.println("Оберіть операцію");
        System.out.println("1 - переглянути інформацію про номери;");
        System.out.println("2 - заселити чи виселити мешканця;");
        System.out.println("3 - видалити номер");
        System.out.println("4 - створити новий номер");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n==1){
            try {
                System.out.println("Переглянути інформацію:");
                System.out.println("1 - про всі номери");
                System.out.println("2 - про типи номерів");
                System.out.println("3 - про конкретного клієнта");
                kontr = new ControllerSql(new Connect("org.sqlite.JDBC", "jdbc:sqlite:hoteldb1.sqlite").getCon());
                Scanner scan1 = new Scanner(System.in);
                int n1 = scan1.nextInt();
                if(n1 == 1){
                    System.out.println("Вся інформація про всі номери");
                  ResultSet  rs=kontr.searchHotelNumberSql("select * from tableHOTELNUMBER");
                    while(rs.next()){
                        int id = rs.getInt(1);
                        String number = rs.getString("number");
                        String type = rs.getString("type");
                        int floor = rs.getInt("floor");
                        String name = rs.getString("name");
                        if(name.length()==0){
                            name = "--------";
                        }
                        boolean employment = rs.getBoolean("employment");

                        System.out.println("id "+id+ " Номер " + number+ " Тип " + type+ " Поверх " + floor+" Ім'я мешканця " + name+" Зайнятість " + employment);
                    }
                }else if(n1==2){
                    System.out.println("Введіть тип номеру");
                    Scanner scan2 = new Scanner(System.in);
                    String type = scan2.nextLine();
                    System.out.println("Номера типу "+ type);
                    ResultSet  rs=kontr.searchHotelNumberSql("select * from tableHOTELNUMBER where type =\""+type+"\" ");
                    while(rs.next()){
                      int id = rs.getInt(1);
                      String number = rs.getString("number");
                      int floor = rs.getInt("floor");
                      String name = rs.getString("name");
                      if(name.length()==0){
                          name = "--------";
                      }
                      boolean employment = rs.getBoolean("employment");

                      System.out.println("id "+id+ " Номер " + number+ " Поверх " + floor+" Ім'я мешканця " + name+" Зайнятість " + employment);
                        }
                }else if(n1==3){
                    System.out.println("Введіть прізвище клієнта");
                    Scanner scan3 = new Scanner(System.in);
                    String name = scan3.nextLine();
                    System.out.println("Інформація про клієнта "+ name);
                    ResultSet  rs=kontr.searchHotelNumberSql("select * from tableHOTELNUMBER where name =\""+name+"\" ");
                    while(rs.next()){
                        int id = rs.getInt(1);
                        String number = rs.getString("number");
                        String type = rs.getString("type");
                        int floor = rs.getInt("floor");
                        if(name.length()==0){
                            name = "--------";
                        }
                        boolean employment = rs.getBoolean("employment");

                        System.out.println("id "+id+ " Номер " + number+ " Тип " + type+ " Поверх " + floor+"  Зайнятість " + employment);
                    }
                }
                   } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(n==2){
            try {
                System.out.println("Введіть номер, прізвище мешканця, статус номеру");
                Scanner scan1 = new Scanner(System.in);
                String number = scan1.nextLine();
                String name = scan1.nextLine();
                int employment = scan1.nextInt();
              kontr = new ControllerSql(new Connect("org.sqlite.JDBC", "jdbc:sqlite:hoteldb1.sqlite").getCon());
              int  rs=kontr.updateHotelNumberSql(number, name, employment);
              } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(n==3){
            try {
                System.out.println("Введіть номер id номера, який бажаєте видалити");
                Scanner scan2 = new Scanner(System.in);
                int id = scan2.nextInt();
                
              kontr = new ControllerSql(new Connect("org.sqlite.JDBC", "jdbc:sqlite:hoteldb1.sqlite").getCon());
              int  rs=kontr.deleteHotelNumberSql(id);

                   } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(n==4){
            try {
              System.out.println("Введіть номер, тип, поверх, прізвище мешканця, статус нового номеру");
                Scanner scan3 = new Scanner(System.in);
                String number = scan3.nextLine();
                String type = scan3.nextLine();
                int floor = scan3.nextInt();
                String name = scan3.next();
                int employment = scan3.nextInt();
                kontr = new ControllerSql(new Connect("org.sqlite.JDBC", "jdbc:sqlite:hoteldb1.sqlite").getCon());
                int  rs=kontr.addHotelNumberSql(number, type, floor, name, employment);
                } catch (SQLException ex) {
                Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

    }
    
}
