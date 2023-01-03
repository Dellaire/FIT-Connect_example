package de.fitconnect.example.data;

public class ServiceType {

    private String name;
    private String identifier;

    public String getName() {
        return name;
    }

    public ServiceType setName(String name) {
        this.name = name;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public ServiceType setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }
}
