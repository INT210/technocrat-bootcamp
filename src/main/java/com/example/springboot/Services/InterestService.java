package com.example.springboot.Services;


import com.example.springboot.DAO.InterestRepo;
import com.example.springboot.DAO.UserRepo;
import com.example.springboot.models.Interest;

import com.example.springboot.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestService {

    @Autowired

    InterestRepo interestRepoObj;

    public void addInterest(Interest interest) {interestRepoObj.save(interest);}

    public List<Interest> getAllInterest() {return interestRepoObj.findAll();}

//
//    public Optional<Users> getUserByID(long user_id) {
//        Optional<Users> user = userRepoObj.findById(user_id);
//        return user;
//    }
//    public List<Users> getAllUser() {return userRepoObj.findAll();}
//
//    public void deleteUserById(long user_id){userRepoObj.deleteById(user_id);}

}


