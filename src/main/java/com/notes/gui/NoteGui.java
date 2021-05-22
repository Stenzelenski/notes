package com.notes.gui;

import com.notes.Note;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NoteGui {

    private Color noteColor = new Color(254, 255, 156);
    private Color menubarColor = new Color(255,247,64);
    private static ArrayList<NoteGui> noteList = new ArrayList<NoteGui>();
    private JPanel notePanel = new JPanel();
    private JFrame noteFrame = new JFrame();
    private JTextArea taNote;

    public NoteGui() {
        openNoteGui();
        noteList.add(this);
    }

    public NoteGui(String description, int colorRGB) {
        openNoteGui();
        taNote.setText(description);
        noteFrame.setBackground(new Color(colorRGB));
    }

    public void openNoteGui() {
        noteFrame.setSize(new Dimension(300, 300));
        noteFrame.setResizable(false);
        noteFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        notePanel.setLayout(new BorderLayout());
        notePanel.setBackground(noteColor);

        taNote = new JTextArea(15, 25);
        taNote.setLineWrap(true);
        taNote.setBackground(noteColor);
        taNote.append("hello");
        taNote.setForeground(Color.red);

        initMenuBar();
        notePanel.add(taNote, BorderLayout.CENTER);
        noteFrame.add(notePanel);
        noteFrame.setVisible(true);
    }

    public void initMenuBar() {
        JPanel panelMenuBar = new JPanel();
        panelMenuBar.setBackground(menubarColor);
        panelMenuBar.setLayout(new BoxLayout(panelMenuBar, BoxLayout.LINE_AXIS));
        panelMenuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        //Buttons
        JButton btnFat = newButton("F");
        JButton btnUnderline = new JButton("U");
        JComboBox<String> cbSize = new JComboBox<String>();
        cbSize.addItem("12");
        cbSize.addItem("13");

        JButton btnDelete = new JButton("D");
        JButton btnMore = newButton("...");

        btnFat.setBackground(noteColor);
        btnUnderline.setBackground(noteColor);
        cbSize.setBackground(noteColor);
        btnDelete.setBackground(noteColor);
        panelMenuBar.add(btnFat);
        panelMenuBar.add(btnUnderline);
        panelMenuBar.add(cbSize);
        panelMenuBar.add(btnDelete);
        panelMenuBar.add(btnMore);
        notePanel.add(panelMenuBar, BorderLayout.NORTH);
    }



    public Color getNoteColor() {

        return this.noteColor;
    }

    public String getDescription() {
        return taNote.getText();
    }

    public JButton newButton(String name) {
        JButton b = new JButton(name);
        b.setBackground(noteColor);
        return b;
    }

    public void disposeNote() {
        noteFrame.setVisible(false);
    }

    public void showNote() {
        noteFrame.setVisible(true);
    }

    public static ArrayList<NoteGui> getNoteList() {
        return NoteGui.noteList;
    }
}
