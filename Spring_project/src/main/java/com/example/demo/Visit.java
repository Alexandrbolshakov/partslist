package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Visit {

    @Id
    @GeneratedValue
    public long id;

    public String description;
}
