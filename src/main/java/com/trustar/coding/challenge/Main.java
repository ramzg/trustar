package com.trustar.coding.challenge;

import com.trustar.coding.challenge.helper.NestedArrayBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        NestedArrayBuilder builder = new NestedArrayBuilder();
        try {
            builder.buildNestedArrayFromFile();
        } catch (IOException e) {
            System.out.printf("Error occurred: %s", e.getMessage());
        }

    }
}
