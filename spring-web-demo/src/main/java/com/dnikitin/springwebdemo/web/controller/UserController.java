package com.dnikitin.springwebdemo.web.controller;

import com.dnikitin.springwebdemo.model.User;
import com.dnikitin.springwebdemo.service.UserService;
import com.dnikitin.springwebdemo.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/ui/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model){
        List<UserDto> users = userService.findAll().stream().
                map(user -> new UserDto(user.getId(), user.getName(), user.getAge())).
                toList();

        model.addAttribute("users", users);

        return "user/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("user", new UserDto());

        return "user/add-form";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") UserDto user){
        userService.create(new User(user.getId(), user.getName(), user.getAge()));

        return "redirect:/ui/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteById(id);

        return "redirect:/ui/users";
    }

}
