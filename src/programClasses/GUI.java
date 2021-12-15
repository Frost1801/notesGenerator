package programClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI implements ActionListener {

    JFrame frame;
    JButton generate;
    JCheckBox wantAccidentals;
    JLabel notes;

    JPanel panel;
    JPanel buttonsPanel;
    public GUI() {
        frame = new JFrame();





        notes = new JLabel("<html>Notes generated here<html>");
        notes.setHorizontalAlignment(JLabel.CENTER);
        notes.setFont(new Font("Garuda",Font.PLAIN,15));
        notes.setForeground(new Color(183, 183, 183, 255));



        frame.setSize(300,175);
        frame.setLayout(new BorderLayout());
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(30, 36, 91)));
        frame.setResizable(false);


        generate = new JButton("<html>Generate a random note succession<html>");
        generate.setFont(new Font("Garuda",Font.BOLD,16));
        generate.setForeground(Color.black);
        generate.addActionListener(this);
        generate.setFocusable(false);
        generate.setBackground(new Color(12, 134, 243));

        wantAccidentals = new JCheckBox("<html>Include accidentals<html>");
        wantAccidentals.setFont(new Font("Garuda",Font.BOLD,16));
        wantAccidentals.setForeground(Color.black);
        wantAccidentals.addActionListener(this);
        wantAccidentals.setFocusable(false);
        wantAccidentals.setHorizontalAlignment(JButton.CENTER);



        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));
        buttonsPanel.add(wantAccidentals);
        buttonsPanel.add(generate);




        panel.add(buttonsPanel, BorderLayout.SOUTH);
        panel.add(notes, BorderLayout.CENTER);




        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Notes Generator");
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == generate){
            NotesGenerator gn = new NotesGenerator();
            if (wantAccidentals.isSelected()){
                gn.setHasAccidentals(true);
            }
            String notesArray = gn.getRandomNotes();
            notes.setForeground(new Color(0, 0, 0, 255));

            notes.setFont(new Font("Garuda",Font.BOLD,15));
            notes.setText("<html>" + notesArray+ "<html>");
        }
    }
}
