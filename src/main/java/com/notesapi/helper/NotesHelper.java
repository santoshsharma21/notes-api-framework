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
public class NotesHelper {
	
	public static Response createNote(Object payload, String token) {
		return RestUtils.post(EndPoints.CREATE_NOTE, payload, token);
	}
	
	public static Response getNote(String token) {
		return RestUtils.get(EndPoints.GET_ALL_NOTES, token);
	}
	
	public static Response getNoteById(String token, String id) {
		return RestUtils.get(EndPoints.GET_SINGLE_NOTE, token, id);
	}
	
	public static Response updateNote(Object payload, String token, String id) {
		return RestUtils.put(EndPoints.UPDATE_NOTE, payload, token, id);
	}
	
	public static Response partialUpdateNote(Object payload, String token, String id) {
		return RestUtils.patch(EndPoints.UPDATE_COMPLETE_STATUS, payload, token, id);
	}
	
	public static Response deleteNote(String token, String id) {
		return RestUtils.delete(EndPoints.DELETE_NOTE, token, id);			
	}

}
