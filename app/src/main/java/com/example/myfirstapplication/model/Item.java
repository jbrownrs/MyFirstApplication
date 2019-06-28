package com.example.myfirstapplication.model;

import java.util.Date;

public class Item {
    private int id;
    private Date date;
    private String text;

    public Item(int id, Date date, String text) {
        this.id = id;
        this.date = date;
        this.text = text;
    }

    public Item(Date date, String text) {
        this.date = date;
        this.text = text;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
