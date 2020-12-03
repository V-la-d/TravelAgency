package ua.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.model.*;
import ua.service.HotelService;
import ua.service.RoomService;
import ua.service.UserService;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;
    private final UserService userService;

    @Autowired
    public RoomController(RoomService roomService, HotelService hotelService, UserService userService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
        this.userService = userService;
    }

    @GetMapping("/delete-room{id}")
    public String deleteRoom(Model model, @PathVariable("id") Integer integer) {
        List<Room> roomList = roomService.deleteRoom(integer);
        model.addAttribute("roomList", roomList);
        return "allHotelRooms";
    }

    @GetMapping("/update-room{id}")
    public String updateRoomForm(@PathVariable("id") Integer integer, Model model) {
        Room room = roomService.findById(integer);
        model.addAttribute("room", room);
        return "updateRoom";
    }

    @PostMapping("/update-room")
    public String updateRoom(Room room, Model model) {
        List<Room> roomList = roomService.updateRoom(room);
        model.addAttribute("roomList", roomList);
        return "allHotelRooms";
    }

    @GetMapping("/add-room{id}")
    public String addRoomForm(@PathVariable("id") Integer integer, Model model) {
        Hotel hotel = hotelService.findById(integer);
        Room room = new Room();
        room.setHotel(hotel);
        model.addAttribute("room", room);
        return "addRoom";
    }

    @PostMapping("/add-room")
    public String addRoom(Room room, Model model) {
        List<Room> roomList = roomService.saveRoom(room);
        model.addAttribute("roomList", roomList);
        return "allHotelRooms";
    }

    @PostMapping("/all-hotel-rooms{id}")
    public String allHotelRooms(@PathVariable("id") Integer integer, Model model) {
        List<Room> rooms = roomService.allHotelRooms(integer);
        model.addAttribute("rooms", rooms);
        return "userAllHotelRooms";
    }

    @PostMapping("/available-hotel-r{id}")
    public String availableRoomInHotel(Model model,
                                       @PathVariable("id") Integer integer,
                                       @RequestParam(value = "checkIn")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
                                       @RequestParam(value = "checkOut")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
                                       @RequestParam(value = "hotelId")Integer hotelId) {
        BookingRoom.setRoomId(integer);
        BookingRoom.setCheckIn(checkin);
        BookingRoom.setCheckOut(checkout);
        boolean isAvailable = roomService.availableRoomsInHotel();
        if (isAvailable) {
            return "bookRoom";
        } else {
            model.addAttribute("hotelId",hotelId);
            return "roomNotAvailable";
        }
    }

    @PostMapping("/booking-room")
    public String bookingRoom(Model model, Principal principal) {
        User user = userService.findByName(principal.getName());
        Room room = roomService.findById(BookingRoom.getRoomId());
        Booking booking = new Booking(BookingRoom.getCheckIn(), BookingRoom.getCheckOut(), room, user);
        roomService.bookingRoom(booking);
        return "successfullyBooked";
    }

}
