package com.javarush.entity;

import jakarta.persistence.AttributeConverter;

public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getRating();
    }

    @Override
    public Rating convertToEntityAttribute(String s) {
        Rating[] values = Rating.values();
        for (Rating rating: values) {
            if (rating.getRating().equals(s)) {
                return rating;
            }
        }
        return null;
    }
}
