package com.example.springboot.Services;

import com.example.springboot.DAO.EventRepo;
import com.example.springboot.DAO.InterestRepo;
import com.example.springboot.DAO.UserRepo;
import com.example.springboot.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    UserRepo userRepoObj;

    @Autowired
    EventRepo eventrepoobj;
    //@Autowired
    Users u;

    @Autowired
    InterestRepo interestRepoObj;
    public void addUser(Users user) {
        userRepoObj.save(user);
    }


    public Optional<Users> getUserByID(Long userid) {
        Optional<Users> user=userRepoObj.findById(userid);
        return user;
    }


    public List<Users> getAllUser() {
        return userRepoObj.findAll();
    }


    public void deleteUserByID(Long userid) {
        userRepoObj.deleteById(userid);
    }


    public String addInterest(Long userid,String interestId) {
        Optional<Users> user=userRepoObj.findById(userid);
        if(user.isPresent()){
            Users users=user.get();
            List<String> list=users.getInterest();
                list.add(interestId);
                users.setInterest(list);
                userRepoObj.save(users);
            return "interest added successfully";
        }
        else
        {
            return "User not Found XD";
        }

    }
























//
//    @Autowired
//    UserRepo userRepoObj;
//
//
//   @Autowired EventRepo eventRepoObj;
//    @Autowired  EventService evs;
//    @Autowired
//    InterestRepo interestRepoObj;
//    //Users u;
//    //Events ev;
//
//    public Users createUser(Users user) {return userRepoObj.save(user);}
//
////    public Optional<Users> getUserByID(Long userid) {
////        Optional<Users> user = userRepoObj.findById(userid);
////        return user;
////    }
////    public Users getUserByID(Long userid) {
////     List<Users> all_usr=getAllUser();
////     Users u=null;
////     for(Users v: all_usr)
////     {
////         if(v.getUser_id() == userid)
////         {
////             u=v;
////             break;
////         }
////     }
////     return u;
////}
//    public Optional<Users> getUserByID(Long userid) {
//        Optional<Users> user=userRepoObj.findById(userid);
//        return user;
//    }
//
//
//
////   public List<Events> filter_events(List<String>users_interest, String city)
////   {
////       List<Events> events_filtered=new ArrayList<>();
////       List<Events> all_events = evs.getAllEvents();
////       for(Events e: all_events)
////       {
////           System.out.println(e.getEvent_city());
////           String curr_city=e.getEvent_city();
////           if(users_interest.contains(e.getEvent_interest_id())) {
////               //find karo agar user_interest me current event ka intrest  id present id h to usko push karo
////               events_filtered.add(e);
////               System.out.println(e);
////           }
////       }
////       for(Events e: events_filtered)
////       {
////           System.out.println("What's in our array?");
////           System.out.println(e);
////       }
////       return events_filtered;
////       //return all_events;
////   }
//   public void updateLocationById(Long userid, String updatedLocation) {
//
//       Optional<Users> existingUser = userRepoObj.findById(userid);
//
//       if (existingUser.isPresent())
//       {
//           System.out.println("working patch");
//           Users u = existingUser.get();
//           u.setUser_city(updatedLocation);
//           userRepoObj.save(u);
//       }
//    }
////    updatedLocation.forEach((key, value) -> {
////               Field loc = ReflectionUtils.findField(Users.class, key);
////               loc.setAccessible(true);
////               ReflectionUtils.setField(loc, existingUser.get(), value);
//
//        //return userRepoObj.save(existingUser.get());
//        public String Addinterest(Long userid,String interestId) {
//
//            Optional<Users> user=userRepoObj.findById(userid);
//            if(user.isPresent()){
//                System.out.println("hi");
//                Users users=user.get();
//                List<String> list=users.getInterest();
//                list.add(interestId);
//                users.setInterest(list);
//                userRepoObj.save(users);
//            }
//            return "interest added successfully";
//        }
//
//
//
//    public List<Users> getAllUser() {
//        return userRepoObj.findAll();
//        //return userRepoObj.findAll();
//    }
//
//    public void deleteUserByID(Long userid) {
//        userRepoObj.deleteById(userid);
//    }
//    @Query(value="{'id' : $0}", delete = true)
//    public Person deleteById (String id);


//    public Optional<Events>getEventswrtId(long interest_id)
//    {
//        return eventRepoObj.findById(interest_id);
//    }

}


