package com.Josh;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Destro on 4/24/2016.
 */
public class ToDoListGUI extends JFrame {
    private JList<String> toDoList;
    private JTextField newToDoTextField;
    private JPanel rootPanel;
    private JButton addToDoButton;
    private DefaultListModel<String> listModel;

    protected ToDoListGUI() {
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));

        listModel = new DefaultListModel<String>();

        toDoList.setModel(listModel);
        addListeners();

        pack();
        setVisible(true);


    }

// when button is clicked this will read the text in the box and add it to the list

    private void addListeners() {
        addToDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newToDo = newToDoTextField.getText();
                newToDo = newToDo.trim();   //removes whitespace

                if (newToDo.length() == 0) {
                    return;
                }
                listModel.addElement(newToDo);   //add new item to JList's MODEL
                newToDoTextField.setText("");    //clear the JTextField
            }
        });


        //this will listen for the list being clicked on which wshould remove the selected item


        toDoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = toDoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });
    }
}