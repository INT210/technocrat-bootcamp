package com.example.springboot.controllers;

import com.example.springboot.Services.EventService;
import com.example.springboot.Services.UserService;
import com.example.springboot.models.Events;
import com.example.springboot.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RestController
public class EventController {

    @Autowired
    EventService eventServiceObj;

    @Autowired
    UserService userServiceObj;


    @CrossOrigin
    @GetMapping(path="/eventList")
    public List<Events> getAllEvents(){
        //System.out.println("Working before : says controller");
        return eventServiceObj.getAllEvents();
    }
    @PostMapping(path="/add/event")
    public String addEvent(@RequestBody Events event)
    {
        eventServiceObj.addEvent(event);
        return "Event Entered Successfully";
    }

    @CrossOrigin
    @PutMapping(path="/registerEvent/{email}/{eventId}")
    public Events registerEvent(@PathVariable String email, @PathVariable Long eventId)
    {
       System.out.println("email from frontend:"+email);

        Events ev = eventServiceObj.registerEvent(email,eventId);

        System.out.println(ev);
        return ev;
        //return "Event Registered Successfully";
    }

    @GetMapping(path="/event_by_interest/{userid}")
    public List<Events> eventFilterInterest(@PathVariable Long userid)
    {
        System.out.println("Workin !!!");
        return eventServiceObj.eventFilterByInterest(userid);
    }

    @CrossOrigin
    @GetMapping(path="/event_by_city/{user_email}")
    public List<Events> eventFilterCity(@PathVariable String user_email)
    {

        Optional<Users> user= userServiceObj.findUser(user_email);
        String city = user.get().getCity();
        System.out.println(city);
        city =city.substring(0, 1).toUpperCase() + city.substring(1);

        return eventServiceObj.eventFilterByCity(city);
    }

    @GetMapping(path="/event_by_interest_and_city/{cityName}/{userid}")
    public List<Events> eventFilterCity(@PathVariable String cityName, @PathVariable Long userid)
    {
        return eventServiceObj.eventFilterByInterestAndCity(cityName,userid);

    }
}
