package com.example.course_work.Controller;

import com.example.course_work.Model.User;
import com.example.course_work.WorkWithFile.AddToFile;
import com.example.course_work.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddUsersController {
    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/addUsers")
    public String getAddUsersPage(){
        return "addUsers_page";
    }

    @PostMapping("/addUsers")
    public String addUser_(User user){
        usersRepo.save(user);
        AddToFile.WriteToFile(user.getId()+
                user.getFirstName()+
                user.getLastName()+
                user.getProfession());
        return "redirect:/addUsers"; //перенаправляется снова к странице add_users
    }
}
