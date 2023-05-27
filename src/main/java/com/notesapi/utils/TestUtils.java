/**
 * 
 */
package com.notesapi.utils;

import org.json.JSONObject;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class TestUtils {

	public static String getStringValuefromJsonObject(Response response, String innerObjectName, String key) {
		JSONObject jo = new JSONObject(response.asString());
		String value = jo.getJSONObject(innerObjectName).getString(key);
		return value;
	}
	
	public static boolean getBooleanValuefromJsonObject(Response response, String innerObjectName, String key) {
		JSONObject jo = new JSONObject(response.asString());
		boolean value = jo.getJSONObject(innerObjectName).getBoolean(key);
		return value;
	}
	
}
