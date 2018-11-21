/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudelavie;

/**
 *
 * @author kamouh
 */
public class noyauFonctionnel {
    private boolean tab[][];
    private int taille;
    
    public noyauFonctionnel(int taille) {
        this.taille = taille;
        tab = new boolean[taille][taille]; 
    }
    
    public void initialisation () {
         for(int i=0;i<taille;i++) {
            for(int j=0;j<taille;j++) {
                this.tab[i][j] = false ;
            }
        }
    }
    
    public void afficheTableau() {
         for(int i=0;i<taille;i++) {
            for(int j=0;j<taille;j++) {
                System.out.println(this.tab[i][j]) ;
            }
        }
    }
    
}
