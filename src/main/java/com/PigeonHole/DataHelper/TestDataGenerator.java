package com.PigeonHole.DataHelper;

import com.github.javafaker.Faker;

public class TestDataGenerator {
	static Faker faker = new Faker();

	// Random Data Generation

	// public static String randomFullName =
	// faker.name().fullName().replaceAll("\\w\\s", "a");
	// public static String randomMail = faker.internet().emailAddress();
	// public static String randomFirstName =
	// faker.name().firstName().replaceAll("\\w\\s", "a");
	// public static String randomLastName =
	// faker.name().lastName().replaceAll("\\w\\s", "a");
	// public static String randomCity = faker.address().city().replaceAll("\\w\\s",
	// "a");
	// public static String randomAddress =
	// faker.address().fullAddress().replaceAll("Apt.", "a");
	// public static String randomZipCode =
	// faker.address().zipCode().replaceAll("-", "1");
	// public static String randomPhoneNumber = faker.phoneNumber().phoneNumber();
	// public static String randomRegion =faker.country().capital().replaceAll("-",
	// "a");
	// public static String randomPin = faker.number().digits(4);
	// public static String randomDescription =
	// faker.lorem().sentence(35).replace('.', 'a');
	// public static String randomCompany = faker.company().name();
	public static String randomTestName = faker.name().name();
	public static  String randomEventName = faker.book().title().replaceAll("'", "1");
	public static String randomSessionName = faker.book().title().replaceAll("'", "1");
}
