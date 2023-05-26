/**
 * 
 */
package com.notesapi.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.notesapi.helper.NotesHelper;
import com.notesapi.payloads.NotesPayload;
import com.notesapi.pojos.Notes;
import com.notesapi.utils.TestUtils;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */

public class NotesTests {

	String xAuthToken;
	String id;

	@BeforeClass
	void beforeClass(ITestContext context) {
		xAuthToken = (String) context.getAttribute("token");
	}

	@Test(priority = 0)
	void createNewNote() {
		Notes requestPayload = NotesPayload.createNotePayload();
		Response response = NotesHelper.createNote(requestPayload, xAuthToken);

		// store id
		id = TestUtils.getStringValuefromJsonObject(response, "data", "id");
		System.out.println("GENERATED ID - " + id);

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Note successfully created");
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "title"), requestPayload.getTitle());
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "description"),requestPayload.getDescription());
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "category"),requestPayload.getCategory());
	}
	
	@Test(priority = 1)
	void retrieveNote() { 
		Response response = NotesHelper.getNote(xAuthToken);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Notes successfully retrieved");
	}
	
	@Test(priority = 2)
	void retrieveNoteById() {
		Response response = NotesHelper.getNoteById(xAuthToken, id);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Note successfully retrieved");
	}
	
	@Test(priority = 3)
	void updateExistingNote() {
		Notes requestPayload = NotesPayload.updateNotePayload();
		Response response = NotesHelper.updateNote(requestPayload, xAuthToken, id);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Note successfully Updated");	
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "title"), requestPayload.getTitle());
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "description"), requestPayload.getDescription());
		Assert.assertEquals(TestUtils.getStringValuefromJsonObject(response, "data", "category"), requestPayload.getCategory());
		Assert.assertEquals(TestUtils.getBooleanValuefromJsonObject(response, "data", "completed"), requestPayload.isCompleted());
	}
	
	@Test(priority = 4)
	void updateCompleteStatusOfNote() {
		Notes requestPayload = NotesPayload.partialUpdateNotePayload();
		Response response = NotesHelper.partialUpdateNote(requestPayload, xAuthToken, id);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Note successfully Updated");	
		Assert.assertEquals(TestUtils.getBooleanValuefromJsonObject(response, "data", "completed"), requestPayload.isCompleted());
	}
	
	@Test(priority = 5)
	void deleteNoteById() {
		Response response = NotesHelper.deleteNote(xAuthToken, id);  
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Note successfully deleted");	
	}
}
