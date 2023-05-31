/**
 * 
 */
package com.notesapi.payloads;

import com.notesapi.pojos.Notes;
import com.notesapi.utils.FakerUtils;
import com.notesapi.utils.RandomDataConstants;

/**
 * @author Santosh Sharma
 *
 */
public class NotesPayload {

	static String title = FakerUtils.getRandomData(RandomDataConstants.TITLE);
	static String description = FakerUtils.getRandomData(RandomDataConstants.TITLE);
	static String category = FakerUtils.getCategory();
	static boolean completed = FakerUtils.getComplete();

	public static Notes createNotePayload() {
		return Notes.builder()
				.title(title)
				.description(description)
				.category(category)
				.build();
	}

	public static Notes updateNotePayload() {
		return Notes.builder()
				.title(title)
				.description(description)
				.category(category)
				.completed(completed)
				.build();
	}

	public static Notes partialUpdateNotePayload() {
		completed = true;
		return Notes.builder()
				.completed(completed)
				.build();
	}

}
