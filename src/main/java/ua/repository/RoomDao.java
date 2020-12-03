package ua.repository;

import ua.model.Booking;

import ua.model.Room;

import java.util.List;

public interface RoomDao {

    List<Room> saveRoom(Room room);

    Room findById(Integer integer);

    List<Room> updateRoom(Room room);

    List<Room> deleteRoom(Integer integer);

    List<Room> allHotelRooms(Integer integer);

    List<Booking> availableRoomsInHotel();

    void bookingRoom(Booking booking);


}
