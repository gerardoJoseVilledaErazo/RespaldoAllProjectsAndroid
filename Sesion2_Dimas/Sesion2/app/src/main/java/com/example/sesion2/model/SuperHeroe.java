package com.example.sesion2.model;

public class SuperHeroe {

    String name;
    String skill;

    public SuperHeroe(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
