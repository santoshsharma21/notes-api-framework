/**
 * 
 */
package com.notesapi.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

/**
 * @author Santosh Sharma
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder(toBuilder = true)
public class Notes {

	private String title;
	private String description;
	private String category;
	private boolean completed;

}
