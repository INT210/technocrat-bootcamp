package com.example.springboot.models;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@Document(collection = "users")
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
    private List<String> interest;

    @NonNull
    private String city;

    private List<Long> event_regd_id;

    public Users(Long id, String name, String pwd, String email, List<String> interest, String city, List<Long> event_regd_id) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.interest = interest;
        this.city = city;
        this.event_regd_id = event_regd_id;
    }

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

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Long> getEvent_regd_id() {
        return event_regd_id;
    }

    public void setEvent_regd_id(List<Long> event_regd_id) {
        this.event_regd_id = event_regd_id;
    }
}
