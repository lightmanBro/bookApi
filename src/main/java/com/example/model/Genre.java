package com.example.model;

public enum Genre {
    FICTION,
    NON_FICTION,
    SCIENCE_FICTION,
    MYSTERY;

    public static Genre getDefault() {
        return FICTION; // Set your desired default value here
    }
}
