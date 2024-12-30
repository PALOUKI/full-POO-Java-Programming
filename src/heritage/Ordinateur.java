/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heritage;

/**
 *
 * @author DELL
 */
public class Ordinateur {
    
    private String marque;
    private String modele;
    private int capaciter;
    private double processeur;
    
    //Variables de relation
    private Etudiant etudiant;
    
    public Ordinateur(String marque, String modele, int capaciter, double processeur){
        this.marque = marque;
        this.modele = modele;
        this.capaciter = capaciter;
        this.processeur = processeur;
    }
    
    //setters
    public void setMarque( String nouvelMarque){
        this.marque = nouvelMarque;
    }
    public void setModele(String nouveauModele){
        this.modele = nouveauModele;
    }
    public void setCapaciter(int nouvelCapaciter){
        if( nouvelCapaciter < 0){
            System.out.println("La capacité de l'ordinateur ne peut pas être inférieur à 0");
        }
        this.capaciter = nouvelCapaciter;
    }
    public void setProcesseur( double nouveauProcesseur){
        if( nouveauProcesseur < 0){
            System.out.println("La capacité de l'ordinateur ne peut pas être inférieur à 0");
        }
        this.processeur = nouveauProcesseur;
    }
    
    //getters
    public String getMarque(){
        return marque;
    }
    public String getModele(){
        return modele;
    }
    public int getCapaciter(){
        return capaciter;
    }
    public double getProcesseur(){
        return processeur;
    }
    
    //methodes pour la relation 1 à 1 entre ordinateur et étudiant
    public Etudiant getEtudiant(){
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
       
    }
    
    
    public String afficherOrdinateur(){
        return "Ordinateur"+"{"+ "marque: "+ this.marque +", modele: "+this.modele+", capacité: "+ this.capaciter+" GB" +", processeur: "+ this.processeur+" GHZ"+"}";
    }


    
}