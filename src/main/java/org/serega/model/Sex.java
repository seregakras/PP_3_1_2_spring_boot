package org.serega.model;

public enum Sex {
    MALE("мужской"),
    FEMALE("женский");

    private final String description;

    Sex(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
