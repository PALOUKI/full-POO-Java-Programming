/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package heritage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author DELL
 */
public class Heritage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Création des étudiants
        System.out.println("*******************************************************************************************************************************************");
        System.out.println("*JAVA CREER ET PRESENTER LES ETUDIANTS: IMMEDIATEMENTS RELIER A LA SUITE GRACE AUX RELATIONS/ LES METHODES SONT MISES A JOUR A CHAQUE RELATION*");
        Etudiant etudiant1 = new Etudiant("PALOUKI", "Godbless", 20, new int[] {17, 19, 20}); 
        etudiant1.calculerMoyenne(etudiant1);
        etudiant1.SePresenter();
        etudiant1.preferences();
        
        Etudiant etudiant2 = new Etudiant("VALVERDE", "Jean Pierre", 20, new int[] {8, 3, 12}); 
        etudiant2.calculerMoyenne(etudiant2);
        etudiant2.SePresenter();
        etudiant2.preferences();
        
        System.out.println("**********************************************************************************************************************************");
        System.out.println("*****************************************JAVA CREER ET PRESENTER UN ENSEIGNANT****************************************************");
        Enseignant enseignant1 = new Enseignant("TCHINDOU", "Alaise", 20, new String[] {"Anglais", "Français", "Allemand"}); 
        enseignant1.SePresenter();
        enseignant1.preferences();
        
        System.out.println("**********************************************************************************************************************************");
        System.out.println("***************************JAVA INTERFACE EtudiantRecarcitrant********************************************************************");
        EtuRecarcitrantImpl etuRecarcitrant1 = new EtuRecarcitrantImpl("ABALO", "valverde", 17, new int[] {8, 11, 6});
        etuRecarcitrant1.calculerMoyenne(etuRecarcitrant1);
        etuRecarcitrant1.SePresenter();
        etuRecarcitrant1.refuserDeFaireDevoir();
        etuRecarcitrant1.demanderPlusDeMotivation();

        System.out.println("**********************************************************************************************************************************");
        System.out.println("***************************JAVA INTERFACE EtudiantStudieux***********************************");
        EtuStudieuxImpl EtuStudieuxImpl1 = new EtuStudieuxImpl("ABALO", "valverde", 17, new int[] {17, 19, 20});
        EtuStudieuxImpl1.calculerMoyenne(EtuStudieuxImpl1);
        EtuStudieuxImpl1.SePresenter();
        EtuStudieuxImpl1.FaireLesDevoirs();
        EtuStudieuxImpl1.recompense();

        System.out.println("**********************************************************************************************************************************");
        System.out.println("***************************JAVA relation plusieurs à plusieurs entre enseignants et etudiants*************************************");
        enseignant1.addEtudiant(etudiant1);
        enseignant1.addEtudiant(etudiant2);
        enseignant1.getEtudiant();
        System.out.println("Liste des étudiants de l'enseignant "+ enseignant1.getNom() +" "+ enseignant1.getPrenom()+": ");
        for (Etudiant etudiant : enseignant1.getEtudiant()) {
            System.out.println(etudiant.getNom() +" "+ etudiant.getPrenom());
        }
        
        etudiant1.addEnseignant(enseignant1);
        etudiant1.getEnseignants();
        System.out.println("Liste des enseignants de l'étudiant "+ etudiant1.getNom() +" "+ etudiant1.getPrenom()+": ");
        for (Enseignant enseignant : etudiant1.getEnseignants()) {
            System.out.println(enseignant.getNom() +" "+ enseignant.getPrenom());
        }
        System.out.println("**********************************************************************************************************************************");
        System.out.println("***************************JAVA relation 1 à 1 entre Etudiant et Ordinateur*******************************************************");        Ordinateur ordinateur1 = new Ordinateur("DELL", "LATITUDE 80179", 512, 2.5);
        Ordinateur ordinateur2 = new Ordinateur("THINKPAD", "LATITUDE 67712", 256, 2.7);
        etudiant1.setOrdinateur(ordinateur1);
        //Au début l'étudiant 1 n'avait pas d'ordinateur mais maintenant oui
        etudiant1.SePresenter();
        System.out.println(ordinateur1.getEtudiant().getNom());
        
        //Associer l'ordinateur2 à l'étudiant1 (devrait lever une exception)
        try{
            etudiant1.setOrdinateur(ordinateur2); 
        }catch(IllegalStateException e){
            System.out.println("Erreur : " + e.getMessage());
        }
        // Associer l'ordinateur1 à l'étudiant2 (devrait lever une exception)
        try {
            etudiant2.setOrdinateur(ordinateur1);
        } catch (IllegalStateException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        
        //afficher la liste des étudiants qui ont déjà un ordinateur 
        List<Etudiant> etudiantsAvecOrdinateur = Etudiant.getEtudiantsAvecOrdinateur();
        System.out.println("Étudiants avec un ordinateur :");
        for (Etudiant etudiant : etudiantsAvecOrdinateur) {
            System.out.println(etudiant.getNom() + " - Ordinateur : " + etudiant.getOrdinateur().afficherOrdinateur());
        }
        
        /*  Toujours afficher la liste des étudiants qui ont déjà un ordinateur 
            une autre manière de filter les éléments avec Java: ici on a plus besoins de déclarer
            une liste static dans la classe etudiants/ on déclare la liste ici
        */
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(etudiant1);
        etudiants.add(etudiant2);
        
        etudiantsAvecOrdinateur = etudiants.stream()
        .filter(e -> e.getOrdinateur() != null)
        .collect(Collectors.toList());
        for (Etudiant etudiant : etudiantsAvecOrdinateur) {
            System.out.println(etudiant.getNom() + " - Ordinateur : " + etudiant.getOrdinateur().afficherOrdinateur());
        }
        
        // Obtenir la liste des étudiants n'ayant pas un ordinateur
        System.out.println("Étudiants n'ayant pas un ordinateur :");
        List<Etudiant> etudiantsSansOrdinateur = etudiants.stream()
                .filter(e -> e.getOrdinateur() == null)
                .collect(Collectors.toList());
        for (Etudiant etudiant : etudiantsSansOrdinateur) {
            System.out.println(etudiant.getNom() + " n'a aucun ordinateur");
        }
        System.out.println("**********************************************************************************************************************************");
        System.out.println("*********JAVA relation plusieurs à plusieurs entre établissements et parcours sachant qu'on ne peut avoir des redondance**********");
        
        //creation des établissements
        Etablissement etablissement1 = new Etablissement("FDS");
        Etablissement etablissement2 = new Etablissement("EPL");
        
        //creation des parcours
        Parcours parcours1 = new Parcours("SCIENCES MATHEMATIQUES");
        Parcours parcours2 = new Parcours("SCIENCES MATHEMATIQUES");
        Parcours parcours3 = new Parcours("GENIE MECANIQUE");
        
        etablissement1.addParcours(parcours1);
        etablissement1.addParcours(parcours2); 
        
        //ignorance de parcours2 car le HashSet détectera un doublon
        System.out.println("Les parcours de l'établissement " + etablissement1.getNom() + " sont:" );
        for(Parcours parcours : etablissement1.getParcours()){
            parcours.afficherParcours();
        }
        //vérification de la relation bidirectionnelle
        System.out.println("Vérification de la relation bidirectionnelle");
        System.out.println("Les établissement du parcours " + parcours1.getNom() + " sont:" );
        for(Etablissement etablissement : parcours1.getEtablissements()){
            etablissement.afficherEtablissement();
        }
        
        
        

        

        
        
        
        
    }
    
}
