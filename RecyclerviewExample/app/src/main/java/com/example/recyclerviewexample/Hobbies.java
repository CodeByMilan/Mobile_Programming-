package com.example.recyclerviewexample;

public class Hobbies {
    private int id;
    private  String name ;
    private  String hobbies ;

    public Hobbies(){

    }
    public Hobbies(int id , String name,String hobbies){
        this.id=id;
        this.name=name;
        this.hobbies=hobbies;

    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }


}
