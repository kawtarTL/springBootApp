package com.example.TP3_4_TLEMCANI_KAWTAR.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private Date creation;
    private String content;
    private String author;

    public Address() {}

    public Address(Long id, Date creation, String content, String author) {
        this.id = id;
        this.creation = creation;
        this.content = content;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Date getCreation() {
        return creation;
    }

    public String getContent() {
        return content;
    }
}