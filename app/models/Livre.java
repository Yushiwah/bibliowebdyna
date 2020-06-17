package models ;

import java.util.*;
import io.ebean.*;
import javax.persistence.*;


@Entity
public class Livre extends Model {
  
private static final long serialVersionUID = 1L;

@Id
private long id;    
private String titre ;
private String auteur ;
private String description ;
private String categorie ; 
    
    public Livre(String titre, String auteur, String description, String categorie ){
        this.titre=titre;
        this.auteur=auteur;
        this.description=description;
        this.categorie=categorie;
    }
    
    public Livre(){   
    }
    
    public String getTitre(){
        return this.titre;
    }
    
    public String getAuteur(){
        return this.auteur;
    }
    
    public String getDescription(){
        return this.description;
    }
    public String getCategorie(){
        return this.categorie;
    }
    
    public long getId(){
        return this.id;
    }
    
    public void setTitre(String titre){
        this.titre = titre;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    
    public void setCategorie(String categorie){
        this.categorie =categorie;
    }
    
    public static Finder<Long, Livre> find = new Finder<Long,Livre>(Livre.class);
}