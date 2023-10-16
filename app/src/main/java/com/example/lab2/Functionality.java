package com.example.lab2;

public class Functionality {
    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // Splitting the text using spaces, commas, and dots as separators
        String[] words = text.split("[\\s,\\.]");
        return words.length;
    }

    public static int countCharacters(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // Counting characters excluding whitespaces
        return text.replaceAll("\\s", "").length();
    }
}
