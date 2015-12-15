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
public interface HotelNumberDAO {
    void createHotelNumber(HotelNumber hotelNumber);
    void readHotelNumber(HotelNumber hotelNumber);
    void updateHotelNumber(HotelNumber hotelNumber);
    void deleteHotelNumber(HotelNumber hotelNumber);
}
