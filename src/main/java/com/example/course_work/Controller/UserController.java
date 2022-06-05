package com.example.course_work.Controller;

import com.example.course_work.Model.User;
import com.example.course_work.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<User> users = usersRepo.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }
}
