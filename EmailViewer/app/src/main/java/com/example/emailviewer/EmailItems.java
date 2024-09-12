package com.example.emailviewer;

public class EmailItems {
    private String Title;
    private String TitleInitial ;
    private String Description;

    public EmailItems(String titleInitial, String title, String description) {
        TitleInitial = titleInitial;
        Title = title;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public String getTitleInitial() {
        return TitleInitial;
    }

    public String getDescription() {
        return Description;
    }
}
