/**
 * 
 */
package com.notesapi.restutils;

import com.notesapi.constants.EndPoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * @author Santosh Sharma
 *
 */
public class SpecificationBuilder {
	
	public static RequestSpecification getRequestSpecification(Object payload) {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec
			.setBaseUri(EndPoints.BASE_URL)
		    .setContentType(ContentType.JSON)
			.setAccept(ContentType.JSON)
			.setBody(payload)
			.log(LogDetail.ALL);
		
		RequestSpecification requestSpec = spec.build();
		return requestSpec;	
	}
	
	public static RequestSpecification getRequestSpecification() {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec
		 	.setBaseUri(EndPoints.BASE_URL)
		 	.setContentType(ContentType.JSON)
			.setBaseUri(EndPoints.BASE_URL)
			.log(LogDetail.ALL);
		
		RequestSpecification requestSpec = spec.build();
		return requestSpec;	
	}
	
	public static ResponseSpecification getResponseSpecification() {
		ResponseSpecBuilder spec = new ResponseSpecBuilder();
		spec
			.expectContentType(ContentType.JSON);
		
		ResponseSpecification responseSpec = spec.build();
		return responseSpec;	
	}

}
