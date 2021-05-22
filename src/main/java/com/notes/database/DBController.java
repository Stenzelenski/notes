package com.notes.database;

import com.notes.Note;
import com.notes.gui.NoteGui;

import java.awt.*;
import java.sql.*;

public class DBController {

    private Statement statement = null;
    private ResultSet resultSet = null;

    public DBController() {

    }

    private Connection openDb() {
        Connection connection = null;
        try {
            String path = "jdbc:sqlite:C:/Users/Lukas/IdeaProjects/notes/db/noteDB.db";
            connection = DriverManager.getConnection(path);
            System.out.println("Connection successful");
        } catch(Exception e) {
            System.out.println("Connection to DB failed");
        }

        return connection;

    }

    public void loadDb() throws SQLException {
        Connection con = openDb();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from Note;");
            while(resultSet.next()) {
                Note n = new Note(addLinebreaks(resultSet.getString("Description")), new Color(resultSet.getInt("Color")));
                NoteGui nn = new NoteGui(addLinebreaks(resultSet.getString("Description")),resultSet.getInt("Color"));
            }
            System.out.println("loading from db successful");
        } catch(Exception e) {
            System.out.println("loading from db failed");
        }
        con.close();
    }

    public void writeIntoDb(String description, Color color) throws SQLException {
        Connection con = openDb();
        try {
            statement = con.createStatement();
            statement.executeQuery("INSERT INTO Note(Description, Color) " + "VALUES ('"+removeLinebreaks(description)+"', '"+color.getRGB()+"')");
            System.out.println("insert into DB successful");
        } catch (Exception e) {
            System.out.println("insert into DB failed");
            e.printStackTrace();
        }
        con.close();
    }

    private String removeLinebreaks(String s) {
        String newString = s.replace("\n", "$");

        return newString;
    }

    public String addLinebreaks(String s) {
        String newString = s.replace("$", "\n");

        return newString;
    }
}
