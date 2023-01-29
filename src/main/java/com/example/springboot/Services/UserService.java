package com.example.springboot.Services;

import com.example.springboot.DAO.EventRepo;
import com.example.springboot.DAO.InterestRepo;
import com.example.springboot.DAO.UserRepo;
import com.example.springboot.models.Events;
import com.example.springboot.models.SignIn;
import com.example.springboot.models.Signup;
import com.example.springboot.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
     static Long random_id = 0L;
    public void addUserEnc(Users user) {
        String password = user.getPwd();
        String encryptedpassword = PasswordEncryption(password);
        //user.setId();
        if(FindUserIdbyEmail(user.getEmail()) == -1)
        {
            random_id++;
            //System.out.println(random_id);
            user.setId(random_id);
            user.setPwd(encryptedpassword);
            userRepoObj.save(user);
        }
    }





    public Optional<Users> getUserByID(Long userid) {
        Optional<Users> user=userRepoObj.findById(userid);
        return user;
    }

    public String getUserNameByUserId(Long Id)
    {
        Optional<Users>user=getUserByID(Id);
        return user.get().getName();
    }


    public List<Users> getAllUser() {
        return userRepoObj.findAll();
    }


    public void deleteUserByID(Long userid) {

        userRepoObj.deleteById(userid);
    }

    public void deleteUserByEmail(String email)
    {
        Long user_id = FindUserIdbyEmail(email);
        System.out.println(user_id);
        deleteUserByID(user_id);
    }

    public Optional<Users> findUser(String email)
    {
        Long user_id = FindUserIdbyEmail(email);
        System.out.println(user_id);
        //deleteUserByID(user_id);
        return getUserByID(user_id);
    }

    public String addInterest(Long userid,String interest){
        List<Users> all_usrs=getAllUser();
        System.out.println(all_usrs);
        System.out.println(userid);
        Users user=null;
        for(Users u: all_usrs) {
            System.out.println(u.getId());
            if (u.getId() == userid) {
//                event=e;
                Set<String> finalSet_id = new HashSet<>();
                finalSet_id.add(interest);
                System.out.println(user);
                u.setNew_Interest(interest);
                user = u;
                userRepoObj.save(user);
                return "interest added successfully";
            }

        }
        return "User Not Found XD";
    }

    public Long FindUserIdbyEmail(String email) {
        List<Users> all_usr = getAllUser();

        System.out.println("Reached-1");
        for (Users u : all_usr) {
            String temp = (String) u.getEmail();
            String temp2 = (String) email;
            System.out.println(temp);
            if ((u.getEmail()).equalsIgnoreCase(email)) {
                System.out.println("leve3");
                return u.getId();
            }
        }
        return -1L;
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
                //System.out.println("Hii");
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
    public Boolean Authenticate(SignIn signInDetails)
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

                return true;
            }

        }
        return false;

    }



















}


