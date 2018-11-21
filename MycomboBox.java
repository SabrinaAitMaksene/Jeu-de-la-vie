/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudelavie;

import javax.swing.*;

/**
 *
 * @author LENOVO
 */
public class MycomboBox extends JPanel{
    
    private JLabel label; 
    private JComboBox<Integer> parametre;
    public MycomboBox(String textLabel) {
        
        parametre = new JComboBox<Integer>();
        label = new JLabel(textLabel+"   ");
        for(int i=1;i<=8;i++) {
          parametre.addItem(i);  
        }
        
        Box hbox = Box.createHorizontalBox();
        hbox.add(label);
        hbox.add(parametre);
        
        this.add(hbox);
    }
    
}
