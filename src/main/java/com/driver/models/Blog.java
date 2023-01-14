package com.driver.models;

import java.util.Date;

import org.hibernate.annotations.*;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;

@Entity
public class Blog{

    @Id 
    @GenratedValue( strategy = GenerationType.AUTO  )
    private int id;
    private String title;
    private String content;

    @CreationTimestamp
    private Date pubDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne( mappedby = "blog", cascade = CascadeType.ALL )
    private List<Image> images;

    public getId(){
        return this.id;
    }


}
