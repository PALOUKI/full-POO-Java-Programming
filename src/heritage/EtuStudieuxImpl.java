/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heritage;

/**
 *
 * @author DELL
 */
public class EtuStudieuxImpl extends Etudiant implements EtudiantStudieux {
    
    public EtuStudieuxImpl(String nom, String prenom, int age, int[] notes){
        super(nom, prenom, age, notes);
    }
    
    
    public void FaireLesDevoirs(){
        System.out.println(this.nom + " "+MESSAGE_STUDIEUX);
    }
    public void recompense(){
        System.out.println(this.nom + " "+MESSAGE_MOTIVATION);   
    }
    
}
