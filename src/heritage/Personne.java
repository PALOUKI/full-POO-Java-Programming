/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heritage;

/**
 *
 * @author DELL
 */
public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected int age;
    
    public Personne( String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
    //getters
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public int getAge(){
        return age;
    }
    
    //setters
    public void setNom(String nouveauNom){
        this.nom = nouveauNom;
    }
    public void setPrenom(String nouveauPrenom){
        this.prenom = nouveauPrenom;
    }
    public void setAge(int nouveauAge){
        if(nouveauAge < 0){
            System.out.println("L'age ne peut pas être négatif");
        }else{
            this.age = nouveauAge;
        }
    }
    
    public void sePresenter(){
        System.out.println("Je m'appelle "+ this.nom+" "+ this.prenom+" et j'ai "+ this.age+" ans.");
    }
    public abstract void preferences();
    
}
