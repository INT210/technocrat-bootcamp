package com.example.springboot.controllers;

//import com.example.springboot.DAO.AuthRequest;
import com.example.springboot.Services.EventService;
//import com.example.springboot.Services.Jwtservice;
import com.example.springboot.Services.UserService;
import com.example.springboot.models.SignIn;
import com.example.springboot.models.Signup;
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
    //@Autowired
    //private Jwtservice jwtservice;

    @CrossOrigin
    @PostMapping(path="/registerUser") /////////Add users to the database
    public Users addUserEnc(@RequestBody Users user){
        userServiceObj.addUserEnc(user);
        return user;
    }

    @CrossOrigin
    @GetMapping(path="/user/{email}") /////Finding users by userid
    public Optional<Users> getUserById(@PathVariable String email){
        Optional<Users> user=userServiceObj.findUser(email);
        return user;
    }
    @CrossOrigin
    @PutMapping(path = "/add/interest/{userid}/{text}")  //// Add interest to the particular id
    public String addInterest(@PathVariable Long userid,@PathVariable String text){
        return userServiceObj.addInterest(userid,text);
    }

    @GetMapping(path="/getAllUsers") ////get All users
    public List<Users> getUsers(){
        List<Users> userlist =userServiceObj.getAllUser();
        return userlist;
    }

    @CrossOrigin
    @DeleteMapping(path = "/deluser/{email}") ////Delete a particular user by it's userid
    public String deleteUserById(@PathVariable String email ){
        userServiceObj.deleteUserByEmail(email);
        return "user deleted succesfully";
    }

    @CrossOrigin
    @PostMapping("/signIn")
    public SignIn Authenticate(@RequestBody SignIn signInDetails)
    {
        System.out.println("Working login");
        if(userServiceObj.Authenticate(signInDetails))
        {
            System.out.println("Workng User");
            return signInDetails;
        }
        else
        {
            signInDetails.setEmail("null");
            return signInDetails;
        }
    }

//    @PostMapping("/signup")
//    public String Signup(@RequestBody  signUpDetails)
//    {
//        return userServiceObj.registerUser(signUpDetails);
//    }
//    @PostMapping("/authenticate")
//    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
//
//    }


}





