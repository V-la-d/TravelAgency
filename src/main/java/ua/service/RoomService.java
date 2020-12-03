package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.model.Booking;
import ua.model.BookingRoom;
import ua.model.Room;
import ua.repository.RoomDao;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoomService {
    private final RoomDao roomDao;

    @Autowired
    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }


    public List<Room> saveRoom(Room room) {
        return roomDao.saveRoom(room);
    }

    public Room findById(Integer integer) {
        return roomDao.findById(integer);
    }


    public List<Room> updateRoom(Room room) {
        return roomDao.updateRoom(room);
    }

    public List<Room> deleteRoom(Integer integer) {
        return roomDao.deleteRoom(integer);
    }


    public List<Room> allHotelRooms(Integer integer) {
        return roomDao.allHotelRooms(integer);

    }


    public boolean availableRoomsInHotel() {
        List<Booking> bookings = roomDao.availableRoomsInHotel();
        List<Booking> filterOne = bookings
                .stream()
                .filter(booking -> BookingRoom.getCheckIn().isAfter(booking.getCheckIn()))
                .filter(booking -> BookingRoom.getCheckIn().isBefore(booking.getCheckOut()))
                .collect(Collectors.toList());
        List<Booking> filterTwo = bookings
                .stream()
                .filter(booking -> BookingRoom.getCheckOut().isAfter(booking.getCheckIn()))
                .filter(booking -> BookingRoom.getCheckOut().isBefore(booking.getCheckOut()))
                .collect(Collectors.toList());
        if (filterOne.isEmpty() && filterTwo.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }


    public void bookingRoom(Booking booking) {
        roomDao.bookingRoom(booking);
    }

}
