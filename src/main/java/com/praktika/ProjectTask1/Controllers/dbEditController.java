package com.praktika.ProjectTask1.Controllers;

import com.praktika.ProjectTask1.Servise.UserService;
import com.praktika.ProjectTask1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class dbEditController {

    private final UserService userService;
    @Autowired
    public dbEditController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dbEdit")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "dbEdit";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public  String createUser(User user){
        userService.SaveUser(user);
        return "redirect:/dbEdit";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteByID(id);
        return "redirect:/dbEdit";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserFrom(@PathVariable("id") Integer id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.SaveUser(user);
        return "redirect:/dbEdit";
    }
}
