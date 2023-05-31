/**
 * 
 */
package com.notesapi.utils;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

/**
 * @author Santosh Sharma
 *
 */
public class FakerUtils {
	
	static Faker faker = new Faker();
	static String password;
	
	public static String getRandomData(RandomDataConstants dataConstants) {
		
		password = faker.internet().password(10, 15);
		
		switch(dataConstants) {
		case NAME:
			return faker.name().name();
		case EMAIL:
			return faker.internet().emailAddress();
		case PASSWORD:
			return password;
		case COMPANY:
			return faker.company().name();
		case NEW_PASSWORD:
			return faker.internet().password(15,20);
		case TITLE:
			return faker.book().title();
		case DESCRIPTION:
			return faker.book().genre();
		default:
			return "data not available";
		}
	}
	
	public static String getCategory() {
		return "Personal";
	}
	
	public static boolean getComplete() {
		return false;
	}
	
	public static String getPhoneNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	
}
