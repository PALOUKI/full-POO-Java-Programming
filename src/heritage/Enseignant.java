/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heritage;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Enseignant extends Personne {
    
    private String[] matieres;
    
    //Variables de ralation
    private ArrayList<Etudiant> etudiants;
    
    public Enseignant(String nom, String prenom, int age, String[] matieres){
        super(nom, prenom, age);
        this.matieres = matieres;
        this.etudiants = new ArrayList<Etudiant>();
    }
    
    //setters
    public void setMatieres(String[] matieres){
        this.matieres = matieres;
    }
    //getters
    public String[] getMatieres(){
        return matieres;
    }
    
    //methodes
    //methode pour ajouter un étudiant
    public void addEtudiant(Etudiant etudiant){
        etudiants.add(etudiant);
    }
    //methode pour retourner les étudiants
    public ArrayList<Etudiant> getEtudiant(){
        return etudiants;
    }
    
    public void SePresenter(){
        super.sePresenter();
        System.out.println("Je suis enseignant:");
        System.out.println("J'enseigne les matières: ");
        for(String matiere : this.matieres){
            System.out.println(matiere);
        }
    }
   
    @Override
    public void preferences(){
        System.out.println("Je suis enseignant et j'aime lire beaucoup de romans, j'aime bavarder avec mes collèges");
        System.out.println("Le weekend j'emmene mes élèves au park pour oublier les maux de tête que mes élèves me donne");
    }

    
}
