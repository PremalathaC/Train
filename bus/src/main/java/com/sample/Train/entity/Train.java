package com.sample.Train.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TRAIN")
public class Train {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String destination;
    private String departure;

    public Train(String name,String destination,String departure)
    {
         this.name=name;
         this.destination=destination;
         this.departure=departure;
    }

}
