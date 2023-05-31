/**
 * 
 */
package com.notesapi.payloads;

import com.notesapi.pojos.Users;
import com.notesapi.utils.FakerUtils;
import com.notesapi.utils.RandomDataConstants;

/**
 * @author Santosh Sharma
 *
 */
public class UsersPayload {

	static String name =  FakerUtils.getRandomData(RandomDataConstants.NAME);
	static String email =  FakerUtils.getRandomData(RandomDataConstants.EMAIL);
	static String password = FakerUtils.getRandomData(RandomDataConstants.PASSWORD);
	//static String phone = FakerUtils.getRandomData(RandomDataConstants.PHONE);
	static String phone = FakerUtils.getPhoneNumber();
	static String company = FakerUtils.getRandomData(RandomDataConstants.COMPANY);
	static String newPassword = FakerUtils.getRandomData(RandomDataConstants.NEW_PASSWORD);

	public static Users userRegisterPayload() {
		return Users.builder()
				.name(name)
				.email(email)
				.password(password)
				.build();
	}

	public static Users userLoginPayload() {
		return Users.builder()
				.email(email)
				.password(password)
				.build();
	}

	public static Users userUpdatePayload() {
		return Users.builder()
				.name(name)
				.phone(phone)
				.company(company)
				.build();
	}

	public static Users userPasswordChangePayload() {
		return Users.builder()
				.currentPassword(password)
				.newPassword(newPassword)
				.build();
	}
	

}
