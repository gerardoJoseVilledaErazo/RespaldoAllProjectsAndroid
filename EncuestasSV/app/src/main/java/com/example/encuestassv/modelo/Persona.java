package com.example.encuestassv.modelo;

public class Persona {
    String name;
    String gender;
    int age;
    String favFood;

    public Persona(){}
/*
    public Persona(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }*/

    public Persona(String name, String gender, int age, String favFood) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.favFood = favFood;
    }
/*
    @Override
    public String toString() {
        return
                //"Persona{" +
                //"name='" + name + '\'' +
                //'}';

                this.name;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }
}
