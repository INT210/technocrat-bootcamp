package com.example.springboot.DAO;
//package com.example.springboot.models.users_schema;

import com.example.springboot.models.Interest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//import net.springboot.javaguides.model.Product;
@Repository
public interface InterestRepo extends MongoRepository <Interest, Long > {

}