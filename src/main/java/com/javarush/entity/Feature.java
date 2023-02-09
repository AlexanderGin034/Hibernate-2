package com.javarush.entity;

import lombok.Getter;

import static java.util.Objects.isNull;

@Getter

public enum Feature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    private Feature(String value) {
        this.value = value;
    }

    public static Feature getFeature(String value) {
        if (isNull(value) || value.isEmpty()) return null;

        Feature feature = switch (value) {
            case "Trailers" -> TRAILERS;
            case "Commentaries" -> COMMENTARIES;
            case "Deleted Scenes" -> DELETED_SCENES;
            case "Behind the Scenes" -> BEHIND_THE_SCENES;
            default -> null;
        };

        return feature;
    }
}
