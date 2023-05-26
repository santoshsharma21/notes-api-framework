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
@Builder
public class Users {
	
	private String name;
	private String email;
	private String password;
	private String phone;
	private String company;
	private String currentPassword;
	private String newPassword; 

}
