package ua.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.model.Role;
import ua.model.User;

import ua.service.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class NavigationController {


    private final UserService userService;

    @Autowired
    public NavigationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mainmenu")
    public String mainMenu(Principal principal) {
        User user = userService.findByName(principal.getName());
        if (user.getRole().equals(Role.MANAGER))
            return "managerMainMenu";
        else return "userMainMenu";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @PreAuthorize("hasAuthority('all_permissions')")
    @GetMapping("/management")
    public String managementPage() {
        return "management";

    }
}
