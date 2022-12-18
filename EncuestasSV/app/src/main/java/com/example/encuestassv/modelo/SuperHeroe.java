package com.example.encuestassv.modelo;

public class SuperHeroe {
    Persona persona;
    String favFood;

    public SuperHeroe(Persona persona, String favFood) {
        this.persona = persona;
        this.favFood = favFood;
    }

    @Override
    public String toString() {
        return this.persona.name;
    }
    /*
    public SuperHeroe(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    @Override
    public String toString() {
        return this.name;
    }*/
}
