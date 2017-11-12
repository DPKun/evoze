package com.example.proto.service;

import com.example.proto.model.Travel;
import com.example.proto.model.User;
import com.example.proto.repo.TravelRepo;
import com.example.proto.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService{

    private UserRepo userRepo;
    private TravelRepo travelRepo;

    @Autowired
    public UserService(UserRepo userRepo, TravelRepo travelRepo){this.userRepo=userRepo;this.travelRepo=travelRepo;}

    public List<Travel> listTravels(String email){

        User user = userRepo.findByEmail(email);
        return travelRepo.findAllByUser_Email(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(s);
        if(user == null){
            throw new UsernameNotFoundException("no user with this name");
        }
        return user;
    }
}
