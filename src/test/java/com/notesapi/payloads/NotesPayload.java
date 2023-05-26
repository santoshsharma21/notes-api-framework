/**
 * 
 */
package com.notesapi.payloads;

import com.github.javafaker.Faker;
import com.notesapi.pojos.Notes;

/**
 * @author Santosh Sharma
 *
 */
public class NotesPayload {

	static Faker faker;
	static String title;
	static String description;
	static String category;
	static boolean completed;

	// payload to create new note
	public static Notes createNotePayload() {
		faker = new Faker();
		title = faker.book().title();
		description = faker.book().genre();
		category = "Home";
		return Notes.builder().title(title).description(description).category(category).build();
	}

	// payload for updating note
	public static Notes updateNotePayload() {
		completed = false;
		return Notes.builder().title(title).description(description).category(category).completed(completed).build();
	}

	// payload for partial update
	public static Notes partialUpdateNotePayload() {
		completed = true;
		return Notes.builder().completed(completed).build();
	}

}
