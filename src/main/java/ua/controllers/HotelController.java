package ua.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.model.Hotel;
import ua.model.Room;
import ua.service.HotelService;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping("/add-hotel")
    public String addHotelForm(@ModelAttribute(name = "hotel") Hotel hotel) {
        return "addHotel";
    }

    @PostMapping("/add-hotel")
    public String addHotel(Hotel hotel) {
        hotelService.saveHotel(hotel);
        return "redirect:/hotel-list";
    }

    @GetMapping("delete-hotel{id}")
    public String deleteHotel(@PathVariable("id") Integer integer) {
        hotelService.deleteHotel(integer);
        return "redirect:/hotel-list";
    }

    @GetMapping("/hotel-list")
    public String allHotels(Model model) {
        List<Hotel> hotelList = hotelService.listOfHotels();
        model.addAttribute("hotels", hotelList);
        return "hotelList";
    }

    @GetMapping("/update-hotel{id}")
    public String updateHotelForm(@PathVariable("id") Integer integer, Model model) {
        Hotel hotel = hotelService.findById(integer);
        model.addAttribute("hotel", hotel);
        return "updateHotel";
    }

    @PostMapping("/update-hotel")
    public String updateHotel(Hotel hotel) {
        System.out.println(hotel);
        hotelService.updateHotel(hotel);
        return "redirect:/hotel-list";
    }

    @GetMapping("/find-h-by-c")
    public String findByCountryForm(String string) {
        return "findByCountry";
    }

    @PostMapping("/find-h-by-c")
    public String findByCountry(Model model, @RequestParam(value = "countryName") String string) {
        List<Hotel> hotels = hotelService.findByCountry(string);
        if (hotels.isEmpty()) {
            model.addAttribute("falsee", false);
            return "findByCountry";
        } else {
            model.addAttribute("hotels", hotels);
            return "allHotelsInCountry";
        }

    }

    @GetMapping("/find-h-by-n")
    public String findByCountryAndNameForm(String string) {
        return "findByCountryAndName";
    }

    @PostMapping("/find-h-by-n")
    public String findByCountryAndName(Model model,
                                       @RequestParam("countryName") String countryName,
                                       @RequestParam("hotelName") String hotelName) {
        List<Room> roomList = hotelService.findByCountryAndName(countryName, hotelName);
        if (roomList.isEmpty()) {
            model.addAttribute("truee", true);
            return "findByCountryAndName";
        } else {
            model.addAttribute("roomList", roomList);
            return "allHotelRooms";
        }


    }


    @GetMapping("/login")
    public String loginForm(Model model, @RequestParam(value = "error", required = false) String error) {
        Boolean errorMessage = false;
        if (error != null) {
            errorMessage = true;
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }


}
