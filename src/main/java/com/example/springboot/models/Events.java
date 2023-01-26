package com.example.springboot.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@Getter
//@Setter
@Data
@Document(collection = "events")
public class Events {
    //@Id
    private Long id;
    private String name;
    private String desc;
    private List<Integer> reg_usr_id;
    private String city;

    private String event_interest;


    public Events(Long id, String name, String desc, List<Integer> reg_usr_id, String city, String event_interest) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.reg_usr_id = reg_usr_id;
        this.city = city;
        this.event_interest = event_interest;
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

    public List<Integer> getReg_usr_id() {
        return reg_usr_id;
    }

    public void setReg_usr_id(List<Integer> reg_usr_id) {
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
}
