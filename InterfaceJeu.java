/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudelavie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.*;
import noyauFonctionnel.Noyau;


/**
 *
 * @author LENOVO
 * Cette classe permet de construire l'interface du jeu. 
 */ 

public class InterfaceJeu extends JFrame implements ActionListener{

   JPanel panQuit;
   JButton btnQuit;
   LeftSide ls;
   Grille grille;
   Grille zoneTampon;
   JComboBox<String> ModelePlateau;
   JButton btnCharger;
   JOptionPane opt1;
   rightSide rs;
 
    /**
     *Constructeur de l'interface
     */
    public InterfaceJeu() {
        panQuit = new JPanel();
        btnQuit = new JButton("QUIT"); 
        ls = new LeftSide();
        rs = new rightSide();
        grille = new Grille(5, 100);
        grille.setAlignmentX(JFrame.CENTER_ALIGNMENT);
        zoneTampon = new Grille(5, 10);
        ModelePlateau = new JComboBox<String>();
        btnCharger = new JButton("Charger");
        opt1 = new JOptionPane();
        this.ls.panEdit.btnChanger.addActionListener(this);
        this.ls.panEdit.btnInit.addActionListener(this);
        this.ls.panEdit.btnInitAl.addActionListener(this);
    }
    
    /**
     * Méthode pour construire le plateau de jeu 
     */
    public void ConstructionPlateau() {
        
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.TRAILING);
        panQuit.setLayout(fl);
        panQuit.add(btnQuit);
        btnQuit.addActionListener(this);
        this.ls.btnPlay.addActionListener(this);
        
       /* Box vboxDroite = Box.createVerticalBox(); 
        vboxDroite.add(zoneTampon);
        vboxDroite.add(Box.createVerticalGlue());
        vboxDroite.add(ModelePlateau);
        vboxDroite.add(btnCharger);*/
        
        this.setTitle("Jeu de la vie");
        this.add(ls,BorderLayout.WEST);
        this.add(grille,BorderLayout.CENTER);
        //this.add(vboxDroite,BorderLayout.EAST);
        this.add(rs,BorderLayout.EAST);
        this.add(panQuit,BorderLayout.SOUTH);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(900, 700));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
     /**
     * Fonction permettant de changer la taille du plateau  
     */
    public void changeTaille() {
      int taille = this.ls.panEdit.getTaille();
      this.grille.setNbrCases(taille);
        
    }
    
      java.util.Timer timer = new java.util.Timer(); 
    TimerTask evol = new TimerTask()
    {
        public void run(){
           // this.Grille.monNoyau.etatSuivant(this.grille.monNoyau.getPlateau());
            InterfaceJeu.this.grille.monNoyau.etatSuivant(InterfaceJeu.this.grille.monNoyau.getPlateau());
            repaint();
        }
    };
    
      public void evolutionPlateau(){
	timer.scheduleAtFixedRate(evol, 1000, 1*1000);   
      }
    
     /**
     * Les méthodes d'écouteur de boutons
     */
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource()==btnQuit) {
            InterfaceJeu.this.dispose();
        } else 
            if(e.getSource()==ls.panEdit.btnChanger) {
                  opt1 = new JOptionPane();
                  int option = opt1.showConfirmDialog(null, "Voulez-vous changer la taille du plateau?","changer la taille", JOptionPane.YES_NO_OPTION);  
                  if(option== JOptionPane.OK_OPTION) {
                  this.changeTaille();
                   repaint();
                  this.ls.panEdit.textTaille.setText("");
            }

        } else if(e.getSource()==ls.btnPlay) {
            //this.grille.monNoyau.etatSuivant(this.grille.monNoyau.getPlateau());
            this.grille.monNoyau.nombreVoisins();
            this.evolutionPlateau();
            repaint();
            
        } else if (e.getSource()== ls.panEdit.btnInit) {
            this.grille.monNoyau = new Noyau(100);
            repaint();   
        } else if (e.getSource()==ls.panEdit.btnInitAl) {
            this.grille.monNoyau.alea();
            repaint();
        }
    
    }  
}
