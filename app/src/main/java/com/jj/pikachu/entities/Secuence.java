package com.jj.pikachu.entities;

/**
 * Created by imac2 on 6/09/18.
 */

public class Secuence {
    String name;
    String lastname;

    public Secuence() {
    }

    public Secuence(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
