package ua.model;

import java.time.LocalDate;

public class BookingRoom {
    static Integer roomId;
    static LocalDate checkIn;
    static LocalDate checkOut;

    public static Integer getRoomId() {
        return roomId;
    }

    public static void setRoomId(Integer roomId) {
        BookingRoom.roomId = roomId;
    }

    public static LocalDate getCheckIn() {
        return checkIn;
    }

    public static void setCheckIn(LocalDate checkIn) {
        BookingRoom.checkIn = checkIn;
    }

    public static LocalDate getCheckOut() {
        return checkOut;
    }

    public static void setCheckOut(LocalDate checkOut) {
        BookingRoom.checkOut = checkOut;
    }
}
