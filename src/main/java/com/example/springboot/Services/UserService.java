package com.example.springboot.Services;

import com.example.springboot.DAO.EventRepo;
import com.example.springboot.DAO.InterestRepo;
import com.example.springboot.DAO.UserRepo;
import com.example.springboot.models.SignIn;
import com.example.springboot.models.Signup;
import com.example.springboot.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    UserRepo userRepoObj;

    //@Autowired
    Users u;

    @Autowired
    EventRepo eventrepoobj;
    //@Autowired
    //Users u;

    @Autowired
    InterestRepo interestRepoObj;
//    public void addUser(Users user) {
//        userRepoObj.save(user);
//    }
     Long random_id = 0L;
    public void addUserEnc(Users user) {
        String password = user.getPwd();
        String encryptedpassword = PasswordEncryption(password);
        //user.setId();

        random_id++;
        //System.out.println(random_id);
        user.setId(random_id);
        user.setPwd(encryptedpassword);
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
    public String FindUserByEmail(String email)
    {
        List<Users> all_usr = getAllUser();
        for(Users u : all_usr)
        {
            //System.out.println("User email from db is"+ u.getEmail());
            //System.out.println("User email is"+ email);
            if(u.getEmail().equals(email)) {
//               //if(u.)
                System.out.println("Hii");
                return u.getPwd();

            }

        }
        return "null";
    }

    public String PasswordEncryption(String password)
    {
        String encryptedpassword = null;
        try
        {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(password.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            encryptedpassword = s.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        /* Display the unencrypted and encrypted passwords. */
        //System.out.println("Plain-text password: " + password);
        //System.out.println("Encrypted password using MD5: " + encryptedpassword);
        return encryptedpassword;
    }
    public String Authenticate(SignIn signInDetails)
    {
        String password = signInDetails.getPassword(); // take from signin
        String email = signInDetails.getEmail(); // take from signin
        String user_password = FindUserByEmail(email);// check email and take password from database
        //System.out.println("Encrypted from db:"+ user_password);

        if(user_password.equals("null") == false)/// check if the password came from login api is same with our database
        {
            // If the password is same then encrypt it a
            //String user_password = u.getPwd()
            String encryptedpassword = PasswordEncryption(password);// encrypt the password from  signin
            //System.out.println("Hii 2 Encrypted from db:"+ encryptedpassword);
            if(encryptedpassword.equals(user_password))
            {

                return "Login Successful";
            }

        }
        return "Login Failed";

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


