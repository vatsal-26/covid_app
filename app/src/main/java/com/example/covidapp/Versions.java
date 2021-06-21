package com.example.covidapp;

public class Versions {

    private String question, description;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public Versions(String question, String description) {
        this.question = question;
        this.description = description;
        this.expandable = false;


    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Versions{" +
                "question='" + question + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
