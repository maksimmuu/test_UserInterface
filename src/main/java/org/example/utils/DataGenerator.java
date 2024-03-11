package org.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private static String password;
    private static final List<String> DOMAIN_LIST = new ArrayList<>(Arrays.asList("yandex", "mail", "gmail", "rambler"));

    public static String generatePassword(int lengthPasswordNotLess) {
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()_+=";
        Random randomIndex = new Random();
        StringBuilder passBuilder = new StringBuilder();

        for(int i = 0; i <= lengthPasswordNotLess/4; i++) {
            passBuilder.append(lowerChars.charAt(randomIndex.nextInt(lowerChars.length())));
            passBuilder.append(upperChars.charAt(randomIndex.nextInt(upperChars.length())));
            passBuilder.append(digits.charAt(randomIndex.nextInt(digits.length())));
            passBuilder.append(symbols.charAt(randomIndex.nextInt(symbols.length())));
        }

        password = passBuilder.toString();
        return password;
    }

    public static String generateEmail(int lengthEmail) {
        String acceptableChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random randomIndex = new Random();
        StringBuilder emailBuilder = new StringBuilder();
        emailBuilder.append(password.charAt(0));

        for(int i = 0; i < lengthEmail-1; i++) {
            int index = randomIndex.nextInt(acceptableChars.length());
            emailBuilder.append(acceptableChars.charAt(index));
        }

        return emailBuilder.toString();
    }

    public static String generateDomain() {
        Random randomIndex = new Random();
        return DOMAIN_LIST.get(randomIndex.nextInt(DOMAIN_LIST.size()));
    }
}
