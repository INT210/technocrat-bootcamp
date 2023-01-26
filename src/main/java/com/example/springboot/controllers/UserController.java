package com.example.springboot.controllers;

import com.example.springboot.Services.EventService;
import com.example.springboot.Services.UserService;
import com.example.springboot.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    UserService userServiceObj;

    EventService eventServiceObj;
    @PostMapping(path="/addUser") /////////Add users to the database
    public String addUser(@RequestBody Users user){
        userServiceObj.addUser(user);
        return "user added succesfuly";
    }

    @GetMapping(path="/user/{userid}") /////Finding users by userid
    public Optional<Users> getUserById(@PathVariable Long userid){
        Optional<Users> user=userServiceObj.getUserByID(userid);
        return user;
    }
    @PutMapping(path = "/add/interest/{userid}/{text}")  //// Add interest to the particular id
    public String addInterest(@PathVariable Long userid,@PathVariable String text){
        return userServiceObj.addInterest(userid,text);
    }

    @GetMapping(path="/getAllUsers") ////get All users
    public List<Users> getUsers(){
        List<Users> userlist =userServiceObj.getAllUser();
        return userlist;
    }

    @DeleteMapping(path = "/deluser/{userid}") ////Delete a particular user by it's userid
    public String deleteUserById(@PathVariable Long userid ){
        userServiceObj.deleteUserByID(userid);
        return "user deleted succesfully";
    }



}





