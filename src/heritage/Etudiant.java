/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heritage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Etudiant extends Personne {
    
    private int[] notes;

    private double moyenne;
    private String mention;
    private static List<Etudiant> etudiants = new ArrayList<>();// liste static pour tous les étudiants
    
    //variables de relations
    private ArrayList<Enseignant> enseignants = new ArrayList<>();
    private Ordinateur ordinateur;
    
    
    Etudiant(String nom, String prenom, int age, int[] notes){
        super(nom, prenom, age);
        this.notes = notes;
         etudiants.add(this); // Ajouter l'étudiant à la liste globale
    }
    //setters
    public void setNotes( int[] nouvelleNotes){
        for(int note : this.notes){
            if (note > 20 && note < 0){
                System.out.println("Les notes sont comprises entre 0 et 20");
                return;
            }
        }
        this.notes = nouvelleNotes;
    }
    //getters
    public int[] getNotes(){
        return notes;
    }
    
    //methodes
   
    //methode pour relation 1 à plusieurs entre Enseignnants et Etudiant
    public void addEnseignant(Enseignant enseignant){
        enseignants.add(enseignant);
    }
    public ArrayList<Enseignant> getEnseignants(){
        return enseignants;
    }
   
  
    //methode pour relation 1 à 1 entre Etudiant et Ordinateur
    public void setOrdinateur(Ordinateur ordinateur){
        // Vérifie si l'étudiant a déjà un ordinateur
        if (this.ordinateur != null && this.ordinateur != ordinateur) {
            throw new IllegalStateException("Cet étudiant a déjà un ordinateur assigné.");
        }

        // Vérifie si l'ordinateur est déjà attribué à un autre étudiant
        if (ordinateur != null && ordinateur.getEtudiant() != null && ordinateur.getEtudiant() != this) {
            throw new IllegalStateException("Cet ordinateur est déjà attribué à un autre étudiant.");
        }
        this.ordinateur = ordinateur;
        // Met à jour l'étudiant de l'ordinateur (relation bidirectionnelle)
        if (ordinateur != null && ordinateur.getEtudiant() != this) {
            ordinateur.setEtudiant(this);
        }  
    }
    public Ordinateur getOrdinateur(){
        return ordinateur;
    }
    
    
    //autres methodes
    public static List<Etudiant> getEtudiantsAvecOrdinateur() {
        List<Etudiant> result = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getOrdinateur() != null) {
                result.add(etudiant);
            }
        }
        return result;
    }
    public static List<Etudiant> getEtudiantsSansOrdinateur(){
        List<Etudiant> result = new ArrayList();
        for(Etudiant etudiant : etudiants ){
            if(etudiant.getOrdinateur() == null){
                result.add(etudiant);
            }
        }
        return result;
    }
    public void calculerMoyenne(Etudiant etudiant){
        int somme = 0;
        for(int note : etudiant.notes){
            somme += note;
        }
        moyenne = somme/notes.length;
    }
    
    public void SePresenter(){
        String ordinateurInfo = (this.ordinateur != null) ? ordinateur.afficherOrdinateur() : "Aucun ordinateur attribué";
        super.sePresenter();
        System.out.println("Je suis étudiant: ");
        System.out.println("Mes notes sont: ");
        for(int note : this.notes){
            System.out.println(note);
        }
        mention = switch (moyenne) {
            case 10.0 -> "Admissible";
            case 11.0, 12.0 -> "Passable";
            case 13.0 -> "Assez bien";
            case 14.0, 15.0 -> "Mention Bien";
            case 16.0, 17.0, 18.0, 19.0, 20.0 -> "Très bien";
            default -> "Ajournée";
        };

        System.out.println("J'ai la moyenne de: " + moyenne + " avec la mention: "+ mention );
        System.out.println("J'ai un ordinateur?: " + ordinateurInfo);
        
    }
    
    @Override
    public void preferences(){
        System.out.println("Je suis étudiant et j'aime apprendre mes leçons quand je rentre de l'école, j'aime bavarder avec mes camarades de classes.");
        System.out.println("Le weekend je vais jouer au ballon mais les dimanches soir je me concentre sur les matières de la semaine");
    }
    

    
}
