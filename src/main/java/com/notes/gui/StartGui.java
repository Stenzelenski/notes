package com.notes.gui;

import com.notes.Note;
import com.notes.gui.NoteGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StartGui extends JFrame {

    JFrame frameMain = new JFrame("Stenzels Notes");
    boolean disposed = false;

    public StartGui() {
        openGui();
    }

    private void openGui() {
        frameMain.setSize(new Dimension(400, 75));
        frameMain.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panelMain = new JPanel();
        panelMain.setBackground(Color.darkGray);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.LINE_AXIS));

        JPanel panelSettings = new JPanel();
        panelSettings.setBackground(Color.green);

        JPanel panelTest2 = new JPanel();
        panelTest2.setBackground(Color.red);


        panelMain.add(initPanelAddNode());
        panelMain.add(initPanelDisposeNote());
        panelMain.add(initPanelSave());
        panelMain.add(initPanelSettings());
        frameMain.add(panelMain);
        frameMain.setVisible(true);
    }

    public JPanel initPanelAddNode() {
        JPanel panelAddNode = new JPanel();
        panelAddNode.setBackground(Color.darkGray);
        JButton btnAddNode = new JButton("New Note");
        btnAddNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoteGui n = new NoteGui();
            }
        });

        panelAddNode.add(btnAddNode);

        return panelAddNode;
    }

    public JPanel initPanelDisposeNote() {
        JPanel panelDisposeNote = new JPanel();
        panelDisposeNote.setBackground(Color.darkGray);
        JButton btnDisposeNote = new JButton("dispose");

        btnDisposeNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!disposed) {
                    disposed = true;
                    ArrayList<NoteGui> noteList = NoteGui.getNoteList();
                    for (NoteGui ng : noteList) {
                        ng.disposeNote();
                    }
                    btnDisposeNote.setText("Show Notes");
                } else {
                    disposed = false;
                    ArrayList<NoteGui> noteList = NoteGui.getNoteList();
                    for (NoteGui ng : noteList) {
                        ng.showNote();
                    }
                    btnDisposeNote.setText("dispose");
                }

            }
        });

        panelDisposeNote.add(btnDisposeNote);
        return panelDisposeNote;
    }

    public JPanel initPanelSave() {
        JPanel panelSave = new JPanel();
        panelSave.setBackground(Color.darkGray);
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(NoteGui n : NoteGui.getNoteList()) {
                    Note note = new Note(n.getDescription(), n.getNoteColor());
                }
            }
        });

        panelSave.add(btnSave);
        return panelSave;
    }

    public JPanel initPanelSettings() {
        JPanel panelSettings = new JPanel();
        panelSettings.setBackground(Color.darkGray);
        JButton btnSettings = new JButton("Settings");

        panelSettings.add(btnSettings);
        return panelSettings;
    }
}
