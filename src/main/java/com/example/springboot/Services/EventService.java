package com.example.springboot.Services;

import com.example.springboot.DAO.EventRepo;
import com.example.springboot.DAO.UserRepo;
import com.example.springboot.models.Events;
import com.example.springboot.models.Users;
import jdk.jfr.Event;
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

    @Autowired
    UserService userServiceObj;

    Events ev;

    public List<Events> eventFilterByCity(String cityName)
    {
        return eventRepoObj.findByCityName(cityName);
    }

    public List<Events> eventFilterByInterest(Long userid)///["Sport","cpp"]
    {
        //System.out.println("Working till here - 4");
        Optional<Users> user = userRepoObj.findById(userid);///  get user by it's user id
        /////convert set into list
        Set<String>user_interest=user.get().getInterest();
        List<String> arr = new ArrayList<>(user_interest);

        List<String> user_interests=arr;/// get the interests of a particular uer
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

    public Optional<Events> findEventById(Long evid)
    {
        return eventRepoObj.findById(evid);
    }


    public Events registerEvent(String email, Long event_id)
    {
        List<Events>all_events=getAllEvents();
        System.out.println("Working Hii 2");
        Long user_id = userServiceObj.FindUserIdbyEmail(email);
        Events event=null;
        //Optional<Events> event = findEventById(event_id);
        System.out.println(user_id);
        System.out.println(event_id);
        String name= userServiceObj.getUserNameByUserId(user_id);
        for(Events e: all_events)
        {
            if(e.getId() == event_id)
            {
//                event=e;
                Set<Long>finalSet_id=new HashSet<>();
                finalSet_id.add(user_id);
                e.setReg_usr_id(finalSet_id);
                System.out.println(e.getReg_usr_id());
                e.setNew_usr(name);
                event=e;
                break;
            }
        }
        System.out.println(event);
        eventRepoObj.save(event);

        return event;
    }

}
