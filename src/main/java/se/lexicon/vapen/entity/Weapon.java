package se.lexicon.vapen.entity;

@Entity
public class Weapon {

    public Weapon(String name, String model, String version) {
        this.name = name;
        this.model = model;
        this.version = version;
    }

    private String name;
    private String model;
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
