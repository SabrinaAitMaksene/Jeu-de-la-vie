/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudelavie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author LENOVO
 */
public class panelParametre extends JPanel {
    Box vboxParametre;
    Box hboxmortSolitude;
    JComboBox<Integer> mortSolitude;
    Box hboxmortAsphyxie;
    Box hboxVieMin;
    Box hboxvieMax;
    JComboBox<Integer> mortAsphyxie;
    JComboBox<Integer>  vieMin;
    JComboBox<Integer> vieMax;
    
    public panelParametre() {
        vboxParametre = Box.createVerticalBox();
        hboxmortSolitude = Box.createHorizontalBox();
        mortSolitude = new JComboBox<>();
        Font font = new Font("Helvetica", Font.BOLD+Font.ITALIC, 25);
        this.setBorder(BorderFactory.createLineBorder(Color.blue,4));
        this.setBackground(Color.cyan);
        JLabel labParam = new JLabel("Paramètres du jeu");
        labParam.setFont(font);
        JLabel morSolitude = new JLabel("Mort solitude    ");
        hboxmortSolitude.add(morSolitude);
        hboxmortSolitude.add(mortSolitude);
        vboxParametre.add(hboxmortSolitude);
        this.add(vboxParametre);
        hboxmortAsphyxie = Box.createHorizontalBox();
        mortAsphyxie = new JComboBox<>();
        hboxVieMin = Box.createHorizontalBox();
        vieMin = new JComboBox<>();
        hboxVieMin = Box.createHorizontalBox();
        vieMax = new JComboBox<>();
        hboxvieMax = Box.createHorizontalBox();
        
        JLabel morAsphyxie = new JLabel("Mort asphyxie    ");
        JLabel vieMini = new JLabel("Vie minimum    ");
        JLabel vieMaxi = new JLabel("Vie maximum    ");
        
        hboxmortAsphyxie.add(morAsphyxie);
        hboxmortAsphyxie.add(mortAsphyxie);
        hboxVieMin.add(vieMini);
        hboxVieMin.add(vieMin);
        hboxvieMax.add(vieMaxi);
        hboxvieMax.add(vieMax);
        vboxParametre.add(labParam);
        vboxParametre.add(Box.createRigidArea(new Dimension(20, 20)));
        vboxParametre.add(hboxmortSolitude);
        vboxParametre.add(Box.createRigidArea(new Dimension(20, 20)));
        vboxParametre.add(hboxmortAsphyxie);
        vboxParametre.add(Box.createRigidArea(new Dimension(20, 20)));
        vboxParametre.add(hboxVieMin);
        vboxParametre.add(Box.createRigidArea(new Dimension(20, 20)));
        vboxParametre.add(hboxvieMax); 
        
        for (int x=1;x<=8;x++) {
            mortAsphyxie.addItem(x);
            mortSolitude.addItem(x);
            vieMin.addItem(x);
            vieMax.addItem(x);
        }
    }
    
}
