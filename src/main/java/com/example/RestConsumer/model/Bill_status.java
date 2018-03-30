package com.example.RestConsumer.model;

import javax.persistence.*;



public class Bill_status {

    private int id;
    private int status;
    private String meaning;



    public Bill_status(int status, String meaning) {
        this.status = status;
        this.meaning = meaning;
    }

    public Bill_status() {
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getMeaning() {
        return meaning;
    }


    @Override
    public String toString() {
        return "Bill_status{" +
                "id=" + id +
                ", status=" + status +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
