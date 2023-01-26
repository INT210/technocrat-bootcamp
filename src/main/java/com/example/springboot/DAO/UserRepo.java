package com.example.springboot.DAO;
//package com.example.springboot.models.users_schema;

import com.example.springboot.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

//import net.springboot.javaguides.model.Product;
@Repository
public interface UserRepo extends MongoRepository <Users, Long > {
//    Optional<Users> findByUsername(String username);
//
//    Boolean existsByUsername(String username);
//
//    Boolean existsByEmail(String email);
@Query(value="{'user_id' : $0}", delete = true)
public Users deleteUserById(Long id);
}