package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class References {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ref_firstName;
    private String ref_lastName;

    public References(String ref_firstName, String ref_lastName, int ref_phoneNumber, String ref_email) {
        this.ref_firstName = ref_firstName;
        this.ref_lastName = ref_lastName;
        this.ref_phoneNumber = ref_phoneNumber;
        this.ref_email = ref_email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef_firstName() {
        return ref_firstName;
    }

    public void setRef_firstName(String ref_firstName) {
        this.ref_firstName = ref_firstName;
    }

    public String getRef_lastName() {
        return ref_lastName;
    }

    public void setRef_lastName(String ref_lastName) {
        this.ref_lastName = ref_lastName;
    }

    public int getRef_phoneNumber() {
        return ref_phoneNumber;
    }

    public void setRef_phoneNumber(int ref_phoneNumber) {
        this.ref_phoneNumber = ref_phoneNumber;
    }

    public String getRef_email() {
        return ref_email;
    }

    public void setRef_email(String ref_email) {
        this.ref_email = ref_email;
    }

    public References() {

    }

    private int ref_phoneNumber;
    private String ref_email;
}
