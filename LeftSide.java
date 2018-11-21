/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudelavie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import jbutton.ButtonIcon;
import static jbutton.ButtonIcon.IconShape.Start;

/**
 *
 * @author LENOVO
 * Cette classe permet de construire le côté gauche du plateau.
 */
public class LeftSide extends JPanel implements ActionListener{
  
    ButtonIcon play;
    ButtonIcon pause;
    JButton btnPlay;
    private Font font;
    private Box vboxGauche;
    panelEdition panEdit;
    panelParametre panParam;
    
    /**
     * Constructeur du côté gauche. 
     */  
    public LeftSide() {
        panEdit = new panelEdition();
        panParam = new panelParametre();
        vboxGauche = Box.createVerticalBox();
        play = new jbutton.ButtonIcon(Start, 60, 40);
        pause = new jbutton.ButtonIcon(ButtonIcon.IconShape.Pause, 60, 40);
        btnPlay = new JButton();
        btnPlay.setIcon(play);
        btnPlay.addActionListener(this);
        vboxGauche.add(panEdit);
        vboxGauche.add(Box.createRigidArea(new Dimension(20, 60)));
        vboxGauche.add(panParam);
        vboxGauche.add(Box.createRigidArea(new Dimension(30, 60)));
        vboxGauche.add(btnPlay);
        this.add(vboxGauche);
  
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.btnPlay.getIcon()==play) {
            this.btnPlay.setIcon(pause);
            
        } else {
            this.btnPlay.setIcon(play);
        }
    }
   
}
