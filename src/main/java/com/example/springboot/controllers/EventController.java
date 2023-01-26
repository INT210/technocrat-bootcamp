package com.example.springboot.controllers;

import com.example.springboot.Services.EventService;
import com.example.springboot.models.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
public class EventController {

    @Autowired
    EventService eventServiceObj;


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

    @GetMapping(path="/event_by_interest/{userid}")
    public List<Events> eventFilterInterest(@PathVariable Long userid)
    {
        System.out.println("Workin !!!");
        return eventServiceObj.eventFilterByInterest(userid);
    }

    @GetMapping(path="/event_by_city/{cityName}")
    public List<Events> eventFilterCity(@PathVariable String cityName)
    {
        return eventServiceObj.eventFilterByCity(cityName);
    }

    @GetMapping(path="/event_by_interest_and_city/{cityName}/{userid}")
    public List<Events> eventFilterCity(@PathVariable String cityName, @PathVariable Long userid)
    {
        return eventServiceObj.eventFilterByInterestAndCity(cityName,userid);

    }
}
