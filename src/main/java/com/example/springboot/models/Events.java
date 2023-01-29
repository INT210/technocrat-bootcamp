package com.example.springboot.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Getter
//@Setter
@Data
@Document(collection = "events")
public class Events {
    //@Id
    private Long id;
    private String name;
    private String desc;
    private Set<Long> reg_usr_id;
    private String city;

    private String event_interest;

    private Set<String> reg_usr_name=new HashSet<>();

    private String new_usr;




    public Events(Long id, String name, String desc, Set<Long> reg_usr_id, String city, String event_interest, Set<String> reg_usr_name, String new_usr) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.reg_usr_id = reg_usr_id;
        this.city = city;
        this.event_interest = event_interest;
        this.reg_usr_name = reg_usr_name;
        this.new_usr = new_usr;
    }

    public Set<String> getReg_usr_name() {
        return reg_usr_name;
    }

    public void setReg_usr_name(Set<String> reg_usr_name) {
        this.reg_usr_name = reg_usr_name;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Long> getReg_usr_id() {
        return reg_usr_id;
    }

    public void setReg_usr_id(Set<Long> reg_usr_id) {
        this.reg_usr_id = reg_usr_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEvent_interest() {
        return event_interest;
    }

    public void setEvent_interest(String event_interest) {
        this.event_interest = event_interest;
    }
    public String getNew_usr() {
        return new_usr;
    }

    public void setNew_usr(String new_usr) {
        this.new_usr = new_usr;
        this.reg_usr_name.add(new_usr);
    }
}
