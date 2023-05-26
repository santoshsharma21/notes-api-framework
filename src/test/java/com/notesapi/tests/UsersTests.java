/**
 * 
 */
package com.notesapi.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.notesapi.helper.UsersHelper;
import com.notesapi.payloads.UsersPayload;
import com.notesapi.pojos.Users;
import com.notesapi.utils.TestUtils;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class UsersTests {
	
	String xAuthToken;
	
	@Test(priority = 0)
	void createNewUser() {
		Users requestPayload = UsersPayload.userRegisterPayload();
		Response response = UsersHelper.registerUser(requestPayload);
		
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "name"), requestPayload.getName());
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "email"), requestPayload.getEmail());
	}
	
	@Test(priority = 1)
	void performLogin(ITestContext context) {
		Users requestPayload = UsersPayload.userLoginPayload();
		Response response = UsersHelper.userLogin(requestPayload);
		
		// store token
		xAuthToken = TestUtils.getStringValuefromJsonObject(response, "data", "token");
		context.setAttribute("token", xAuthToken);
		
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.jsonPath().getString("message"), "Login successful");
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "email"), requestPayload.getEmail());
	}
	
	@Test(priority = 2)
	void retrieveUserInfo() {
		Response response = UsersHelper.getUserInfo(xAuthToken);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Profile successful");
	}

	@Test(priority = 3)
	void editUserInfo() {
		Users requestPayload = UsersPayload.userUpdatePayload();
		Response response = UsersHelper.updateUserInfo(requestPayload, xAuthToken);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Profile updated successful");
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "name"), requestPayload.getName());
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "phone"), requestPayload.getPhone());
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "company"), requestPayload.getCompany());
	}

	@Test(priority = 4)
	void editUserPassword() {
		Users requestPayload = UsersPayload.userPasswordChangePayload();
		Response response = UsersHelper.changeUserPassword(requestPayload, xAuthToken);

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "The password was successfully updated");
	}
	
//	@Test(priority = 5)
//	void performLogout() {
//		Response response = UsersHelper.userLogout(xAuthToken);
//		
//		Assert.assertEquals(response.getStatusCode(), 200);
//		Assert.assertEquals(response.jsonPath().getString("message"), "User has been successfully logged out");
//	}

}
