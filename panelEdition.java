/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudelavie;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author LENOVO
 * Panneau d'édition
 */
public class panelEdition extends JPanel {
    JTextField textTaille;
    JButton btnChanger;
    Box hboxTaille;
    Box vboxEdition;    
    Box hboxInit;
    JLabel labEdition;
    JTextField textInit;
    JButton btnInitAl;
    JButton btnInit;
    
    public panelEdition() {
        textTaille = new JTextField(10);
        btnChanger = new JButton("Changer");
        hboxTaille = Box.createHorizontalBox();
        Font font = new Font("Helvetica", Font.BOLD+Font.ITALIC, 25);
        this.setBackground(Color.cyan); 
        btnInitAl = new JButton("Initialiser aléatoirement");
        textInit = new JTextField(10);
        btnInit = new JButton("Initialiser");
        vboxEdition = Box.createVerticalBox();
        hboxInit = Box.createHorizontalBox();
        this.setBorder(BorderFactory.createLineBorder(Color.blue,4));
        labEdition = new JLabel("Edition du plateau");
        labEdition.setFont(font);
        hboxTaille.add(textTaille);
        hboxTaille.add(btnChanger);
        vboxEdition.add(labEdition);
        vboxEdition.add(hboxTaille);
        vboxEdition.add(Box.createRigidArea(new Dimension(20, 20)));
        hboxInit.add(textInit);
        hboxInit.add(btnInitAl);
        vboxEdition.add(hboxInit);
        vboxEdition.add(Box.createRigidArea(new Dimension(20, 20)));
        vboxEdition.add(btnInit);
        this.add(vboxEdition);
    }
    
    public int getTaille() {
        return Integer.parseInt(this.textTaille.getText());
    }
    
}
