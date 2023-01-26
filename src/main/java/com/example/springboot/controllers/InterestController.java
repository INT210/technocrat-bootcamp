package com.example.springboot.controllers;
import java.util.*;

import com.example.springboot.Services.InterestService;
import com.example.springboot.Services.UserService;
import com.example.springboot.models.Interest;
import com.example.springboot.models.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class InterestController {

    @Autowired
    InterestService interestServiceObj;
    @PostMapping(path="/add/interest")
    public String addInterest(@RequestBody Interest interest)
    {
        interestServiceObj.addInterest(interest);
        return "Interest Edit successfully";
    }

    @GetMapping(path="/getInterest")
    public List<Interest> getAllInterest() {
        return interestServiceObj.getAllInterest();
    }

}
