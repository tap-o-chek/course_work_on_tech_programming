package com.example.course_work.security.details;

import com.example.course_work.Model.User;
import com.example.course_work.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String lastName){
        lastName = "%" + lastName + "%";
        User user =usersRepo.findByLastNameIgnoreCase(lastName);
        if (user != null){
            return  new UserDetailsImpl(user);
        }
        else{
            throw new UsernameNotFoundException("User not found");
        }
    }
}
