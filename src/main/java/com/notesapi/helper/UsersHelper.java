/**
 * 
 */
package com.notesapi.helper;

import com.notesapi.constants.EndPoints;
import com.notesapi.utils.RestUtils;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class UsersHelper {
	
	public static Response registerUser(Object payload) {
		return RestUtils.post(EndPoints.REGISTER_USER, payload);
	}

	public static Response userLogin(Object payload) {
		return RestUtils.post(EndPoints.USER_LOGIN, payload);
	}
	
	public static Response getUserInfo(String token) {
		return RestUtils.get(EndPoints.USER_PROFILE_INFO, token);
	}
	
	public static Response updateUserInfo(Object payload, String token) {
		return RestUtils.patch(EndPoints.PARTIAL_UPDATE_USER, payload, token);
	}
	
	public static Response changeUserPassword(Object payload, String token) {
		return RestUtils.post(EndPoints.CHANGE_PASSWORD, payload, token);
	}
	
	public static Response userLogout(String token) {
		return RestUtils.delete(EndPoints.USER_LOGOUT, token);
	}
	
}
