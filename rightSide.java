/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudelavie;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 * Classe permettant de construire le côté droit du plateau. 
 * @author LENOVO
 */
public class rightSide extends JPanel {
    Box vboxDroit;
    Grille zoneTempon;
    JComboBox<String> modele;
    JButton btnCharger;
    
    /**
     *Constructeur de la classe, création d'une boite verticale dans 
     * laquelle sont ajouté la zone tampon, la liste déroulante des modèles
     * et le bouton de chargement. 
     */
    public rightSide() {
        vboxDroit = Box.createVerticalBox();
        zoneTempon = new Grille(7, 10);
        modele = new JComboBox<>();
        btnCharger = new JButton("Charger le modèle");
        vboxDroit.setAlignmentX(LEFT_ALIGNMENT);
        vboxDroit.add(zoneTempon);
        vboxDroit.add(Box.createRigidArea(new Dimension(0, 60)));
        vboxDroit.add(modele);
        vboxDroit.add(Box.createRigidArea(new Dimension(20, 10)));
        vboxDroit.add(btnCharger);
        this.add(vboxDroit);
    }
    
}
