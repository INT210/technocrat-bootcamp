package com.example.springboot.Services;

import com.example.springboot.DAO.EventRepo;
import com.example.springboot.DAO.UserRepo;
import com.example.springboot.models.Events;
import com.example.springboot.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class EventService
{
    @Autowired
    EventRepo eventRepoObj;

    @Autowired
    UserRepo userRepoObj;

    public List<Events> eventFilterByCity(String cityName)
    {
        return eventRepoObj.findByCityName(cityName);
    }

    public List<Events> eventFilterByInterest(Long userid)///["Sport","cpp"]
    {
        //System.out.println("Working till here - 4");
        Optional<Users> user = userRepoObj.findById(userid);///  get user by it's user id
        List<String> user_interests=user.get().getInterest();/// get the interests of a particular uer
        List<Events> filteredInterest = new ArrayList<>();///declare new array
        for(Events e:eventRepoObj.findAll())
        {
            if(user_interests.contains(e.getEvent_interest())) /// if that event contains the interests then add it
                filteredInterest.add(e);
        }
        return filteredInterest;
    }

    public List<Events> eventFilterByInterestAndCity(String city, Long userid)
    {
        List<Events> ListForCity = eventFilterByCity(city);
        List<Events> ListForInterest = eventFilterByInterest(userid);
        ListForCity.retainAll(ListForInterest);
        return ListForCity;
    }
    public List<Events> getAllEvents() {
        //System.out.println("Working before");
        return eventRepoObj.findAll();
    }

    public Events addEvent(Events event) {
        return eventRepoObj.save(event);
    }

}
