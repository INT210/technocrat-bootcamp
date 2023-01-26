package com.example.springboot.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "interest")
//@Getter
//@Setter
public class Interest {
    private long id;
    private String name;

    public Interest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
