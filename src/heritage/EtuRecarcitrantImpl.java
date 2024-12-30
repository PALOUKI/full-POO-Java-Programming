/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heritage;

/**
 *
 * @author DELL
 */
public class EtuRecarcitrantImpl extends Etudiant implements EtudiantRecarcitrant {
    
    public EtuRecarcitrantImpl(String nom, String prenom, int age, int[] notes){
        super(nom, prenom, age, notes);   
    }
    
    public void refuserDeFaireDevoir(){
        System.out.println(this.nom + " "+MESSAGE_RECARCITRANT);
    }
    public void demanderPlusDeMotivation(){
        System.out.println(this.nom +"..."+MESSAGE_MOTIVATION);
    }
        
    
}
