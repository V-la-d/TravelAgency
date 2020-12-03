package ua.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.model.User;
import ua.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all-user-and-orders")
    public String allUserAndOrders(Model model) {
        List<User> users = userService.allUserAndOrders();
        model.addAttribute("users",users);
        return "allUsersAndOrders";
    }
}
