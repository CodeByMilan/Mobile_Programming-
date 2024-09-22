package com.example.lab2;

public class Note {

        private String uid;
        private String title;
        private String description;

    public Note(String uid, String title, String description) {
        this.uid = uid;
        this.title = title;
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
