/**
 * 
 */
package com.notesapi.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

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
		return response;
	}

	public static Response post(String endpoint, Object payload, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().post(endpoint).then().spec(resSpec).log().all().extract().response();
		return response;
	}

	// GET REQUEST
	public static Response get(String endpoint, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification();
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().get(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		return response;
	}

	public static Response get(String endpoint, String token, String id) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification();
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token).pathParam("id", id)

				.when().get(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		return response;
	}

	// PUT REQUEST
	public static Response put(String endPoint, Object payload, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().put(endPoint)

				.then().spec(resSpec).log().body().extract().response();
		return response;
	}

	public static Response put(String endpoint, Object payload, String token, String id) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token).pathParam("id", id)

				.when().put(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		return response;
	}

	// PATCH request
	public static Response patch(String endpoint, Object payload, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().patch(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		return response;
	}

	public static Response patch(String endpoint, Object payload, String token, String id) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification(payload);
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token).pathParam("id", id)

				.when().patch(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		return response;
	}

	// DELETE request
	public static Response delete(String endpoint, String token) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification();
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token)

				.when().delete(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		return response;
	}

	public static Response delete(String endpoint, String token, String id) {
		RequestSpecification reqSpec = SpecificationBuilder.getRequestSpecification();
		ResponseSpecification resSpec = SpecificationBuilder.getResponseSpecification();
		Response response = RestAssured.given().spec(reqSpec).header("x-auth-token", token).pathParam("id", id)

				.when().delete(endpoint)

				.then().spec(resSpec).log().body().extract().response();
		return response;
	}

}
