/**
 * 
 */
package com.notesapi.constants;

/**
 * @author Santosh Sharma
 *
 */
public class EndPoints {
	
	// base url
	public static final String BASE_URL = "https://practice.expandtesting.com/notes/api";

	// users endpoints
	public static final String REGISTER_USER = "/users/register";
	public static final String USER_LOGIN = "/users/login";
	public static final String USER_PROFILE_INFO = "/users/profile";
	public static final String PARTIAL_UPDATE_USER = "/users/profile";
	public static final String CHANGE_PASSWORD = "/users/change-password";
	public static final String USER_LOGOUT = "/users/logout";

	// notes endpoints
	public static final String CREATE_NOTE = "/notes";
	public static final String GET_ALL_NOTES = "/notes";
	public static final String GET_SINGLE_NOTE = "/notes/{id}";
	public static final String UPDATE_NOTE = "/notes/{id}";
	public static final String UPDATE_COMPLETE_STATUS = "/notes/{id}";
	public static final String DELETE_NOTE = "/notes/{id}";

}
