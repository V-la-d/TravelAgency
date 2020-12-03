package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.model.Hotel;
import ua.model.Room;
import ua.repository.HotelDao;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class HotelService {

    private final HotelDao hotelDao;

    @Autowired
    public HotelService(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }


    public void saveHotel(Hotel hotel) {
        hotelDao.saveHotel(hotel);
    }


    public List<Hotel> listOfHotels() {
        return hotelDao.listOfHotels();
    }


    public Hotel findById(Integer integer) {
        return hotelDao.findById(integer);
    }


    public void updateHotel(Hotel hotel) {
        hotelDao.updateHotel(hotel);
    }


    public void deleteHotel(Integer integer) {
        hotelDao.deleteHotel(integer);
    }


    public List<Room> findByCountryAndName(String countryName, String hotelName) {
        Hotel hotel = hotelDao.findByCountryAndName(countryName, hotelName);
        return hotel.getRooms();
    }

    public List<Hotel> findByCountry(String string) {
        return hotelDao.findByCountry(string);
    }


}
