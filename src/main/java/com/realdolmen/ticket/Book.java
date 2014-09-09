package com.realdolmen.ticket;

import javax.persistence.*;

@Entity
public class Book
{
    public static enum Genre{
        FANTASY,THRILLER,DRAMA
    }


    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String author;
    /*opgelet als je dit gebruikt en je past uw enum aan dan klopt het niet meer want hier worden nummer gebruiken
    * oplossing -->EnumType.String-->meer opslag
    */
    @Enumerated(EnumType.ORDINAL)
    private Genre genre;


    //is verplicht en default constructor voor jpa
    protected Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}
