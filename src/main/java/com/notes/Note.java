package com.notes;

import java.awt.*;

public class Note {

    private String nid = "Note";
    private String description;
    private Color color;
    private int number = 1;

    public Note(String description, Color color) {
        this.nid = nid + number;
        this.description = description;
        this.color = color;
        number++;

        System.out.println(this.nid + this.description );
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
