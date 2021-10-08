package se.lexicon.vapen.entity;

import javax.persistence.Entity;

@Entity
public class Manufacturer {

    public Manufacturer(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
    }
    private int id;
    private String name;
    private String contactInformation;

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
