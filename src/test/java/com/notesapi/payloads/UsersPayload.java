/**
 * 
 */
package com.notesapi.payloads;

import com.github.javafaker.Faker;
import com.notesapi.pojos.Users;

/**
 * @author Santosh Sharma
 *
 */
public class UsersPayload {

	static Faker faker;
	static String name;
	static String email;
	static String password;
	static String phone;
	static String company;
	static String newPassword;

	public static Users userRegisterPayload() {
		faker = new Faker();
		name = faker.name().name();
		email = faker.internet().emailAddress();
		password = faker.internet().password(5, 10);
		return Users.builder().name(name).email(email).password(password).build();
	}

	public static Users userLoginPayload() {

		return Users.builder().email(email).password(password).build();
	}

	public static Users userUpdatePayload() {
		phone = "0123456789";
		company = "home pvt";

		return Users.builder().name(name).phone(phone).company(company).build();
	}

	public static Users userPasswordChangePayload() {
		newPassword = faker.internet().password(6, 10);

		return Users.builder().currentPassword(password).newPassword(newPassword).build();
	}

}
