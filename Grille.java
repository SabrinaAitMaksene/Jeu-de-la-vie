/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudelavie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import noyauFonctionnel.Noyau;

/**
 * @author kamouh
 * cette classe permet de construire la grille du jeu de la vie
 */
public class Grille extends JPanel implements MouseListener {

    private int size;
    private int nbrCases;
    private int tailleGrille;
    public Noyau monNoyau;
    private static final int DEFAULT_SIZE = 200;
    
 /*
    Constructeur de la grille 
 */
    public Grille(int size, int nbrCases) {
     
        this.setMinimumSize(new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
        this.setPreferredSize(new Dimension(nbrCases*size, nbrCases*size));
        this.monNoyau = new Noyau(nbrCases);
        this.size = size;
        this.nbrCases = nbrCases;
        this.addMouseListener(this);
        this.addMouseWheelListener(mw);
    }
/*
 * Redéfinition de la méthode paintcomponent pour redessiner la grille
 */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < nbrCases; i++) {
            for (int j = 0; j < nbrCases; j++) {   
                if(monNoyau.getCellule(i, j)) {
                    g.setColor(Color.blue);
                    g.fillRect(i*size, j*size, size, size);
                }
                else{
                   g.setColor(Color.black);
                   g.drawRect(i*size, j*size, size, size); 
                }
            }
        }
    }
   
    public void setNbrCases(int nbrCases) {
        this.nbrCases = nbrCases;
    }

    public void setMonNoyau(Noyau monNoyau) {
        this.monNoyau = monNoyau;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()/size;
        int y  = e.getY()/size;
        this.monNoyau.manipCell(x, y);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    MouseWheelListener mw = new MouseWheelListener() {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
              if (e.getWheelRotation() < 0) {
            Grille.this.size = Grille.this.size + 1;
        } else {
            Grille.this.size = Grille.this.size - 1;
        }
        repaint();
        }
    };
    
}
