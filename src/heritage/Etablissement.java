/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heritage;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author DELL
 */
public class Etablissement {
    private String nom;
    private Set<Parcours> parcours;
    
    //constructeur
    public Etablissement(String nom){
        this.nom = nom;
        this.parcours = new HashSet<>();
    }
    //getters
    public String getNom(){
        return nom;
    }
    //setters
    public void setNom(String nouveauNom){
        this.nom = nouveauNom;
    }
    /*
        METHODE POUR LA RELATION PLUSIEURS A PLUSIEURS ENTRE ETABLISSEMENT ET PARCOURS SACHANT
        QU'UN PARCOURS ET UN ETABLISSEMENT NE PEUT SE REPETER. D'OU L'UTILISATION DES HashSet.
    */
    public Set<Parcours> getParcours(){
        return parcours;
    }
    public void addParcours(Parcours nouveauParcours){
        parcours.add(nouveauParcours);
        nouveauParcours.addEtablissement(this);
       
    }
    //ces deux methodes suivantes sont cruciales pour les HashSet, ils permettent d'empêcher des boublons créées par deux objets différents. 
        @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Vérifie si les deux objets sont la même référence
        if (o == null || getClass() != o.getClass()) return false; // Vérifie si les classes sont différentes
        Etablissement etablissement = (Etablissement) o;
        return nom.equals(etablissement.nom); // Vérifie l'égalité des attributs
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    
    //autres methodes
    public void afficherEtablissement(){
        System.out.println("Etablissement { nom: " + this.nom +" }");
    }
    
    
}
