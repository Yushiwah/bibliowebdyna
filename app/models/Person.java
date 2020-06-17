package models ;

import java.util.*;
import io.ebean.*;
import javax.persistence.*;


@Entity
public class Person extends Model {
  
private static final long serialVersionUID = 1L;

@Id
private long id;    
private String firstname ;
private String name ;
private int age ; 
    
    public Person(String firstname, int age){
        this.firstname=firstname;
        this.age=age;
    }
    
    public Person(){   
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public long getId(){
        return this.id;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public static Finder<Long, Person> find = new Finder<Long,Person>(Person.class);
}