/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practiceexam2022;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author thabo
 */
public class PracticeExam2022 {
    static ArrayList<String> hospitalNames = new ArrayList<>();
    static ArrayList<String> hospitalLocations = new ArrayList<>();
    static ArrayList<String> yearsSinceInspections = new ArrayList<>();
    
    public static void main(String[] args) {
        hospitalWindow();
    }
    
    public static void hospitalWindow() 
    {
        String[] Subscriptions = {"1 year", "2 years", "3 years", "4 years", "5 years"};
        JFrame win = new JFrame("Hospital Inspections");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(400, 300);
        win.setLayout(new GridLayout(5, 1));
        
        JPanel namePnl = new JPanel(new FlowLayout());
        JPanel locationPnl = new JPanel(new FlowLayout());
        JPanel yearsPnl = new JPanel(new FlowLayout());
        JPanel displayPnl = new JPanel(new BorderLayout());
        JPanel btnPnl = new JPanel(new FlowLayout());

        
        JLabel hospitalNameLbl = new JLabel("Hospital Name:");
        JLabel hospitalLocationLbl = new JLabel("Hospital Location:");
        JLabel subscriptionsLbl = new JLabel("Years since inspection:");
        
        JTextField hospitalNameTxt = new JTextField(20);
        JTextField hospitalLocationTxt = new JTextField(20);
        
        JTextArea displayArea = new JTextArea(5, 80);
        displayArea.setEditable(false);
        
        
        JComboBox<String> subscriptionCBox = new JComboBox<>(Subscriptions);
        
        JButton saveBtn = new JButton("SAVE");
        JButton printBtn = new JButton("PRINT");
        JButton clearBtn = new JButton("CLEAR");
        
        saveBtn.addActionListener(e -> 
        {
            String hosName = hospitalNameTxt.getText();
            String hosLoc = hospitalLocationTxt.getText();
            String yearsSub = (String) subscriptionCBox.getSelectedItem();
            
            hospitalNames.add(hosName);
            hospitalLocations.add(hosLoc);
            yearsSinceInspections.add(yearsSub);
        });
        clearBtn.addActionListener(e -> 
        {
            hospitalNameTxt.setText("");
            hospitalLocationTxt.setText("");
            subscriptionCBox.setSelectedIndex(0);
            displayArea.setText("");
        });
        printBtn.addActionListener(e -> 
        {
            String displayText = "";
                
            for(int i = 0; i < hospitalNames.size(); i++)
            {
                String hosName = hospitalNames.get(i);
                String hosLoc = hospitalLocations.get(i);
                String yearSub = yearsSinceInspections.get(i);
                
                displayText = "Hospital Name: "  + hosName + "\n"
                        + "Hospital Location: " + hosLoc + "\n"
                        + "Years Since Inspections: " + yearSub + "\n"
                        + "***************************************";
            }
            
            displayArea.setText(displayText);
        });
        
        namePnl.add(hospitalNameLbl);
        namePnl.add(hospitalNameTxt);
        locationPnl.add(hospitalLocationLbl);
        locationPnl.add(hospitalLocationTxt);
        yearsPnl.add(subscriptionsLbl);
        yearsPnl.add(subscriptionCBox);
        displayPnl.add(saveBtn, BorderLayout.NORTH);
        displayPnl.add(displayArea, BorderLayout.CENTER);
        btnPnl.add(printBtn);
        btnPnl.add(clearBtn);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> 
        {
            System.exit(0);
        });
        fileMenu.add(exitItem);
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem printItem = new JMenuItem("Print");
        JMenuItem clearItem = new JMenuItem("Clear");
        saveItem.addActionListener(e->
        {
            String hosName = hospitalNameTxt.getText();
            String hosLoc = hospitalLocationTxt.getText();
            String yearsSub = (String) subscriptionCBox.getSelectedItem();
            
            hospitalNames.add(hosName);
            hospitalLocations.add(hosLoc);
            yearsSinceInspections.add(yearsSub);
        });
        printItem.addActionListener(e->
        {
            hospitalNameTxt.setText("");
            hospitalLocationTxt.setText("");
            subscriptionCBox.setSelectedIndex(0);
            displayArea.setText("");
        });
        clearItem.addActionListener(e->
        {
            hospitalNameTxt.setText("");
            hospitalLocationTxt.setText("");
            subscriptionCBox.setSelectedIndex(0);
            displayArea.setText("");
        });
        toolsMenu.add(saveItem);
        toolsMenu.add(printItem);
        toolsMenu.add(clearItem);
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        
        win.setJMenuBar(menuBar);
        
        win.add(namePnl);
        win.add(locationPnl);
        win.add(yearsPnl);
        win.add(displayPnl);
        win.add(btnPnl);
        
        
        win.setVisible(true);
    }
    
}
