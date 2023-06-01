/**
 * 
 */
package com.notesapi.restutils;

import com.notesapi.extentreport.ReportLogger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;

/**
 * @author Santosh Sharma
 *
 */
public class RestUtils {

	// POST REQUEST
	public static Response post(String endpoint, Object payload) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).when().post(endpoint).then().spec(resSpec).log().all()
				.extract().response();

		printRequestDetails(reqSpec, endpoint, "POST");
		printResponseDetails(response);
		return response;
	}

	public static Response post(String endpoint, Object payload, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().post(endpoint).then().spec(resSpec).log().all().extract().response();

		printRequestDetails(reqSpec, endpoint, "POST");
		printResponseDetails(response);
		return response;
	}

	// GET REQUEST
	public static Response get(String endpoint, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification();
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().get(endpoint)

				.then().spec(resSpec).log().body().extract().response();

		printRequestDetails(endpoint, reqSpec, "GET");
		printResponseDetails(response);
		return response;
	}

	public static Response get(String endpoint, String token, String id) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification();
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token).pathParam("id", id)

				.when().get(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		
		printRequestDetails(endpoint, reqSpec, "GET");
		printResponseDetails(response);
		return response;
	}

	// PUT REQUEST
	public static Response put(String endpoint, Object payload, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().put(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		
		printRequestDetails(reqSpec, endpoint, "PUT");
		printResponseDetails(response);
		return response;
	}

	public static Response put(String endpoint, Object payload, String token, String id) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token).pathParam("id", id)

				.when().put(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		
		printRequestDetails(reqSpec, endpoint, "PUT");
		printResponseDetails(response);
		return response;
	}

	// PATCH request
	public static Response patch(String endpoint, Object payload, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().patch(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		
		printRequestDetails(reqSpec, endpoint, "PATCH");
		printResponseDetails(response);
		return response;
	}

	public static Response patch(String endpoint, Object payload, String token, String id) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token).pathParam("id", id)

				.when().patch(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		
		printRequestDetails(reqSpec, endpoint, "PATCH");
		printResponseDetails(response);
		return response;
	}

	// DELETE request
	public static Response delete(String endpoint, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification();
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().delete(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		
		printRequestDetails(endpoint, reqSpec, "GET");
		printResponseDetails(response);
		return response;
	}

	public static Response delete(String endpoint, String token, String id) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification();
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token).pathParam("id", id)

				.when().delete(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		
		printRequestDetails(endpoint, reqSpec, "GET");
		printResponseDetails(response);
		return response;
	}
    
	public static void printRequestDetails(RequestSpecification requestSpec, String endpoint, String method) {
		QueryableRequestSpecification reqQuery = SpecificationQuerier.query(requestSpec);
		ReportLogger.logInfoDetails("Endpoint - " + endpoint);
		ReportLogger.logInfoDetails("Request Method - " + method);
//		ReportLogger.logInfoDetails("Request Headers");
//		ReportLogger.logHeaderInTableFormat(reqQuery.getHeaders().asList());
		ReportLogger.logInfoDetails("Request Body");
		ReportLogger.logJsonDetails(reqQuery.getBody().toString());
	}
	
	public static void printRequestDetails(String endpoint, RequestSpecification requestSpec, String method) {
//		QueryableRequestSpecification reqQuery = SpecificationQuerier.query(requestSpec);
		ReportLogger.logInfoDetails("Endpoint - " + endpoint);
		ReportLogger.logInfoDetails("Request Method - " + method);
//		ReportLogger.logInfoDetails("Request Headers");
//		ReportLogger.logHeaderInTableFormat(reqQuery.getHeaders().asList());
	}

	public static void printResponseDetails(Response response) {
		ReportLogger.logInfoDetails("Status code - " + response.getStatusCode());
//		ReportLogger.logInfoDetails("Response Headers");
//		ReportLogger.logHeaderInTableFormat(response.getHeaders().asList());
		ReportLogger.logInfoDetails("Response Details");
		ReportLogger.logJsonDetails(response.getBody().prettyPrint());
	}

}
