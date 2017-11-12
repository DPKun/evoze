package com.example.proto.service;

import com.example.proto.model.Role;
import com.example.proto.model.Travel;
import com.example.proto.model.User;
import com.example.proto.repo.RoleRepo;
import com.example.proto.repo.TravelRepo;
import com.example.proto.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DataLoaderService {

    private RoleRepo roleRepo;
    private UserRepo userRepo;
    private TravelRepo travelRepo;

    @Autowired
    public DataLoaderService(UserRepo userRepo, TravelRepo travelRepo, RoleRepo roleRepo){
        this.travelRepo=travelRepo;
        this.userRepo=userRepo;
        this.roleRepo=roleRepo;
    }

    @PostConstruct
            public void addDummies() throws ParseException{
        Role adminRole = new Role("ADMIN");
        roleRepo.save(adminRole);

        User testUser = new User("a@b.com", "password");
        userRepo.save(testUser);
        User admin = new User("admin","admin");
        admin.addRole(adminRole);
        userRepo.save(admin);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Travel testTravel1=new Travel(testUser,"from","to",format.parse("2000-01-01"));
        Travel testTravel2=new Travel(testUser,"ide","oda",format.parse("3000-12-12"));

        travelRepo.save(testTravel1);
        travelRepo.save(testTravel2);

    }



}
