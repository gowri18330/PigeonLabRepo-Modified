package com.PigeonHole.DataHelper;

import com.github.javafaker.Faker;

public class TestDataGenerator {
	static Faker faker = new Faker();

	// Random Data Generation
	public static String randomTestName = faker.name().name();
	public static  String randomEventName = faker.book().title().replaceAll("'", "1");
	public static String randomSessionName = faker.book().title().replaceAll("'", "1");
}
