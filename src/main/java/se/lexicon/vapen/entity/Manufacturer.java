package se.lexicon.vapen.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contactInformation;



    public Manufacturer(int id, String name, String contactInformation) {
        this.id = id;
        this.name = name;
        this.contactInformation = contactInformation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
