package com.praktika.ProjectTask1.Controllers;

import com.praktika.ProjectTask1.Servise.FileServise;
import com.praktika.ProjectTask1.Servise.UserService;
import com.praktika.ProjectTask1.model.File;
import com.praktika.ProjectTask1.model.User;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;
import java.util.List;

@Controller
public class dbEditController {

    private final FileServise fileServise;
    private final UserService userService;
    @Autowired
    public dbEditController(FileServise fileServise, UserService userService) {
        this.fileServise = fileServise;
        this.userService = userService;
    }

    @GetMapping("/dbEdit")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        List<File> files = fileServise.findAll() ;
        model.addAttribute("users", users);
        model.addAttribute("files",files);
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

    @GetMapping("/file-create")
    public String createFileForm(File file){
        return "file-create";
    }

    @PostMapping("/file-create")
    public String createFile(File file){
        fileServise.SaveFile(file);
        return "redirect:/dbEdit";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteByID(id);
        return "redirect:/dbEdit";
    }

    @GetMapping("file-delete/{id}")
    public String deleteFile(@PathVariable("id") Integer id){
        fileServise.deleteByID(id);
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

    @GetMapping("/file-update/{id}")
    public String updateFileForm(@PathVariable("id") Integer id, Model model){
        File file = fileServise.FindById(id);
        model.addAttribute("file",file);
        return "/file-update";
    }

    @PostMapping("/file-update")
    public String updateFile(File file){
        fileServise.SaveFile(file);
        return "redirect:/dbEdit";
    }
}
