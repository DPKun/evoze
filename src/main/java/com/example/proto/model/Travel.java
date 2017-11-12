package com.example.proto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Travel {

    @Id
    @GeneratedValue
    @Column(name = "TRAVEL_ID")
    private Long id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(targetEntity = User.class, optional = false)
    @JsonBackReference
    private User user;

    private String Start;

    private String Destination;

    private Date date;

    public Travel(User user, String from, String to, Date date) {
        this.user=user;
        this.Start= from;
        this.Destination = to;
        this.date = date;
    }

    public Travel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "id=" + id +
                ", User='" + user.getEmail() + '\'' +
                ", Start='" + Start + '\'' +
                ", Destination='" + Destination + '\'' +
                ", date=" + date +
                '}';
    }
}
