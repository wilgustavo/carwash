package cc.gmw.carwash.shared.model;

import com.github.javafaker.Faker;

import java.util.Locale;

public class StringMother {

    private static Faker faker = new Faker();

    public static String random(Integer length) {
        return faker.lorem().characters(length);
    }
}
