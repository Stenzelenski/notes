package com.notes.gui;

import com.notes.Note;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NoteGui {

    private Color noteColor = new Color(254, 255, 156);
    private static ArrayList<NoteGui> noteList = new ArrayList<NoteGui>();
    private JPanel notePanel = new JPanel();
    private JFrame noteFrame = new JFrame();
    private JTextArea taNote;

    public NoteGui() {
        openNoteGui();
        noteList.add(this);
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
        panelMenuBar.setBackground(new Color(255,247,64));
        panelMenuBar.setLayout(new BoxLayout(panelMenuBar, BoxLayout.LINE_AXIS));

        //Buttons
        JButton btnFat = new JButton("F");
        JButton btnUnderline = new JButton("U");
        JComboBox<String> cbSize = new JComboBox<String>();
        cbSize.addItem("12");
        cbSize.addItem("13");

        JButton btnSave = new JButton("S");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiateNote(noteList);
            }
        });

        JButton btnDelete = new JButton("D");

        panelMenuBar.add(btnFat);
        panelMenuBar.add(btnUnderline);
        panelMenuBar.add(cbSize);
        panelMenuBar.add(btnSave);
        panelMenuBar.add(btnDelete);

        notePanel.add(panelMenuBar, BorderLayout.NORTH);
    }

    private void initiateNote(ArrayList<NoteGui> nlist) {
        for(NoteGui n : nlist) {
            Note note = new Note(taNote.getText(), noteColor);
        }
    }

    public Color randomizeColor() {

        return null;
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
