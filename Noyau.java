package noyauFonctionnel;

import jeudelavie.noyauFonctionnel.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author LENOVO
 */
public class Noyau {
    
    private int nbrCases;
    private boolean[][] plateau ;
    private int [][]nbv ;
    private int mortAsphyxie,mortSolitude,vieMax,vieMin;
   
    /**
     * Constructeur du noyau fonctionnel
     * @param nbrCases
     */
   public Noyau(int nbrCases) {
       this.mortSolitude = 1;
       this.mortAsphyxie = 4;
       this.vieMin = 3;
       this.vieMax = 3;
       this.plateau = new boolean[nbrCases][nbrCases];
       this.nbrCases = nbrCases;
       for(int i=0 ; i<nbrCases ; i++){
            for(int j=0 ; j<nbrCases ; j++) {
                this.plateau[i][j] = false;
            }  
        }
   }

    public boolean[][] getPlateau() {
        return plateau;
    }
    /**
     * Fontion pour récupérer une cellule de la grille. 
     * @param i
     * @param j
     * @return
     */
    public boolean getCellule(int i, int j){
       return plateau[i][j];
   }
    /**
     *
     * @param plateau
     */

   public void afficher(boolean [][]plateau)
    {	
	for (int i = 0; i< nbrCases; i++)
	{	
            for (int j=0; j< nbrCases; j++)
            {
		System.out.print(plateau[i][j]);
		System.out.print(",");	
            }
		System.out.println("\n");
	}
    }
   
      public void afficherVoisin(int [][]nbv)
    {	
	for (int i = 0; i< nbrCases; i++)
	{	
            for (int j=0; j< nbrCases; j++)
            {
		System.out.print(nbv[i][j]);
		System.out.print(",");	
            }
		System.out.println("\n");
	}
    }

    public void alea() {
        int nbrTrue = 0;
        for(int i=0;i<nbrCases;i++) {
            for(int j=0;j<nbrCases;j++) {
               
                boolean test = ( Math.random() >= 0.5 );
                
                if(test) {
                    nbrTrue ++;
                }
                plateau[i][j]= test;
                }
            }
        }
    }
	/*public void initilisation()
	{
            Scanner sc = new Scanner(System.in);
            System.out.println("Saisir la taille du plateau"); // choix de la taille du plateau 
            taille = sc.nextInt();
            plateau= new int[taille][taille];
            nbv = new int [taille][taille];
            int choix =1;
	
		 //choix de la façon d'initlaisation du plateau 
		do{ 
			System.out.println("initialiser avec: \n 1: plateau vide \n 2: avec un tableau de booleen \n 3: aleatoirement ");
			choix = sc.nextInt();
			if (choix==1)
			{	
				for (int i = 0; i<plateau.length; i++)
				{	
					plateau[i]= new int[taille];
				}
				for(int i =0; i< plateau.length;i++)
				{
					for(int j =0; j<plateau.length;j++){
						plateau[i][j]=0;
					}
				}
				afficher(plateau);
			}
			else if(choix==2)
			{
				btab= new boolean [taille][taille];
				for (int i = 0; i<btab.length; i++)
				{	
					btab[i]= new boolean[taille];
				}
				for(int i =0; i< btab.length;i++) // generer un tableau de booleens 
				{
					for(int j =0; j<btab.length;j++){
						boolean test = ( Math.random() >= 0.5 );
						btab[i][j]= test;
						if(btab[i][j]==true ) plateau[i][j]=1; else plateau[i][j]=0;
					}
				}
				afficher(plateau);	
				
			}
			else if(choix==3)
			{	
				for (int i = 0; i<plateau.length; i++)
				{	
					plateau[i]= new int[taille];
				}
				for(int i =0; i< plateau.length;i++)
				{
					for(int j =0; j<plateau.length;j++){
						plateau[i][j]=  (int)(Math.random() * (2));// generer aléatoirement un 0 ou un 1 
					}
				}
				afficher(plateau);	 
			}
		} while(choix != 1 && choix!=2 && choix !=3 );
		
	} */

    /**
     *
     * @param i
     * @param j
     */

    public void manipCell(int i, int j)
    {
      if(plateau[i][j] == false) {
          plateau[i][j] = true;
      } else 
          plateau[i][j]= false;
    }
											
    public void  nombreVoisins(){
        this.nbv = new int [nbrCases][nbrCases];
	for (int i = 0; i<nbrCases ;i++){
            for(int j = 0; j< nbrCases; j++){
		int nb=0;	
		if (i-1 >=0 & j>=0){
                    if  (plateau[i-1][j]){
                        nb++;
                    }
		} 	
		if(i+1<= nbrCases-1 & j<= nbrCases-1){
                    if (plateau[i+1][j]){
                        nb++;
                    }
		}	
		if (i>=0 & j-1 >=0) {
                    if (plateau[i][j-1]){
                        nb++;
                    }
		}		
		if(j+1<= nbrCases-1 & i <+ nbrCases-1){
                    if (plateau[i][j+1]){
                        nb++;
                    } 
		}
		if(i-1 >=0 & j-1 >=0){
                    if (plateau[i-1][j-1]){
                        nb++;
                    }
		}
		if(i+1 <= nbrCases-1 & j-1 >=0 ){
                    if (plateau[i+1][j-1]){
                        nb++;
                    }
		}
		if(i-1 >=0 & j+1 <=nbrCases-1){
                    if (plateau[i-1][j+1]){
                        nb++;
                    }
		}
		if(i+1 <= nbrCases -1 & j+1 <= nbrCases -1){
                    if ( plateau[i+1][j+1]){
                        nb++;
                    }
		}
                    nbv[i][j]= nb;
            }
        }
		//afficherVoisin(nbv);
    }	
    public void etatSuivant(boolean plateauT[][]) {
        this.nombreVoisins();
	for (int i = 0; i< plateauT.length; i++) {
            for (int j=0; j< plateauT.length; j++) {
		if (plateau[i][j] && nbv[i][j]>= mortAsphyxie) {
                    plateau[i][j]=false;
                } 
                    else if (plateau[i][j] & nbv[i][j]<=mortSolitude) {
                        plateau[i][j]=false;
                    }
                    else if (plateau[i][j]==false & nbv[i][j]==vieMax) {
                        plateau[i][j]=true;
                    }
            }
	}	
         //   afficher(plateau);
    }	
    
	/*public void imagePlateau(){
		
	} */
}

														
															
	



