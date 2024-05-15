package com.spring.boot.springboot.controller;

import com.spring.boot.springboot.entity.User;
import com.spring.boot.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class MyUserController {

    private UserService userService;

    @Autowired
    public MyUserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public String all(Model model){
        model.addAttribute("user", userService.all());
        return "/all";
    }
    @GetMapping("/{id}")
    public String get(@PathVariable("id") int id, Model model){
        model.addAttribute("user",userService.get(id));
        return "/get";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "/add";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String update(Model model,@PathVariable("id") int id){
        model.addAttribute("user", userService.get(id));
        return "/edit";
    }
    @PostMapping("/{id}")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }
}
