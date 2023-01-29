package com.example.springboot.models;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@Document(collection = "user")
//@AllArgsConstructor
//@NoArgsConstructor
//@RestController
public class Users {
    //@Id
   //@Id
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String pwd;

    @NonNull
    private String email;
    private Set<String> interest=new HashSet<>();

    @NonNull
    private String city;

    private Set<Long> event_regd_id=new HashSet<>();

    private String new_int;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getInterest() {
        return interest;
    }

    public void setInterest(Set<String> interest) {
        this.interest = interest;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Long> getEvent_regd_id() {
        return event_regd_id;
    }

    public void setEvent_regd_id(Set<Long> event_regd_id) {
        this.event_regd_id = event_regd_id;
    }

    public String getNew_int() {
        return new_int;
    }

    public void setNew_int(String new_int) {
        this.new_int = new_int;
    }

    public void setNew_Interest(String new_int) {
        this.new_int = new_int;
        this.interest.add(new_int);

    }
}
