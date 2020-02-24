package com.example.updadtednotebook;

import java.io.Serializable;

public class Note implements Serializable {
    private String headline;
    private String note;
    private int position;

    public Note(String headline, String note) {
        this.headline = headline;
        this.note = note;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
