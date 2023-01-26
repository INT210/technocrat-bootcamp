package com.example.springboot.DAO;

import com.example.springboot.models.Events;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
//import net.springboot.javaguides.model.Product;
@Repository

public interface EventRepo extends MongoRepository <Events, Long > {

    //Wuerying database for the city variable with a given cityname;
    @Query("{city : ?0}")
    List<Events> findByCityName(String city);

    @Query("{event_interest : ?0}")
    List<Events> findByInterest(String interest);

//    @Query("{event_interest : ?0}")
//    Events findEventByInterest(String interest);



}