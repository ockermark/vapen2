package se.lexicon.vapen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String passWord;
    private String type;

    public User() {
    }

    public User(int id, String name, String passWord, String type) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
