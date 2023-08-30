package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Sex;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String viewIndex(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("add-user")
    public String addUser(Model model) {
        List<Sex> sexList = List.of(web.model.Sex.values());//todo: используем List.. видимо предполагаем наличие 3-его sex-a :)
        model.addAttribute("sexList", sexList);
        return "addUser";
    }

    @PostMapping("add-user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("update-user/{id}")
    public String updateUser(Model model, @PathVariable long id) {
        List<Sex> sexList = List.of(web.model.Sex.values());
        User user = userService.findUser(id);
        model.addAttribute("sexList", sexList);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("update-user")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("delete-user/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/";
    }
}

