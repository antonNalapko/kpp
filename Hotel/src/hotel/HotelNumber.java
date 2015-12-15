/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel;

/**
 *
 * @author Anton
 */
public class HotelNumber {
    int id;
    String number;
    String type;
    int floor;
    String name;
    boolean employment;

    public HotelNumber(int id, String number, String type, int floor, String name, boolean employment) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.floor = floor;
        this.name = name;
        this.employment = employment;
    }

    @Override
    public String toString() {
        return "HotelNumber{" + "id=" + id + ", number=" + number + ", type=" + type + ", floor=" + floor + ", name=" + name + ", employment=" + employment + '}';
    }
    
    
}
