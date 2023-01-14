package com.driver.models;


@Entity
public class Image {
    
    @Id 
    @GenratedValue( strategy = GenerationType.AUTO  )
    private int id;
    private String description;
    private String dimension;
    

    @ManyToOne
    @JoinColumn
    private Blog blog;



}