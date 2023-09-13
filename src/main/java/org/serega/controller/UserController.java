package org.serega.controller;

import org.serega.model.User;
import org.serega.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.serega.model.Sex;
import org.webjars.NotFoundException;

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

    @GetMapping("{id}")
    public String showUser(Model model, @PathVariable Long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "showUser";
    }

    @GetMapping("add-user")
    public String addUser(Model model) {
        List<Sex> sexList = List.of(Sex.values());//todo: используем List.. видимо предполагаем наличие 3-его sex-a :)
        model.addAttribute("sexList", sexList);
        return "addUser";
    }

    @PostMapping("add-user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping("update-user/{id}")
    public String updateUser(Model model, @PathVariable long id) {
        List<Sex> sexList = List.of(Sex.values());
        User user = userService.findById(id);
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

    @ExceptionHandler(NotFoundException.class)
    public String handleException(Model model, NotFoundException e) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}

