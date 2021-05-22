package com.notes;

import com.notes.database.DBController;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Note {

    DBController dbc = new DBController();
    private String description;
    private Color color;
    private static ArrayList<Note> noteArrayList = new ArrayList<Note>();
    private static int number = 1;

    public Note(String description, Color color) {
        this.description = description;
        this.color = color;
        number++;

        noteArrayList.add(this);
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

    public ArrayList<Note> getNoteArrayList() {
        return this.noteArrayList;
    }

    /**
     * the database can't save Strings with multiple lines
     * @param s
     * @return String with removed Linebreaks for the database
     */

    private String removeLinebreaks(String s) {
        String newString = s.replace("\n", "$");

        return newString;
    }

    public String addLinebreaks(String s) {
        String newString = s.replace("$", "\n");

        return newString;
    }

    public static void saveNoteArrayList() throws SQLException {
        for(Note n : noteArrayList) {
            DBController dbc = new DBController();
            dbc.writeIntoDb(n.getDescription(), n.getColor());
        }
    }
}
