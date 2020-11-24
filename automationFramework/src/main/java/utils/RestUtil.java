package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestUtil {
	
	public void setBaseURI(String uri) {
		RestAssured.baseURI = uri;
	}
	
	public void setBasePath(String basePath) {
		RestAssured.basePath = basePath;
	}
	
	public Response getApiResponse() {
		Response response = RestAssured.given().get().then().extract().response();
		return response;
	}
	
	public Response postApiResponse(Map<String, String> payload ) {
		Response response = RestAssured.given().body(payload)
	            .post().then().extract().response();
		return response;
	}
	
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	
	public String getResponseBodyAsString(Response response) {
		String responseBody = response.getBody().asString();
		return responseBody;
	}

	public String getStringReponseFromReponse(String responseBody, String jsonStrPath) {
		JsonPath jsonPath = new JsonPath(responseBody);
		String id = jsonPath.getString(jsonStrPath);
		return id;
	}
	
	public List<String> getStringListReponseFromReponse(String responseBody, String jsonStrPath) {
		List<String> jsonResponse = new ArrayList<String>();
		JsonPath jsonPath = new JsonPath(responseBody);
		jsonResponse = jsonPath.getList(jsonStrPath);
		return jsonResponse;
	}
	
	public Map<String, String> postPayload(String name, String salary, String age)
	{
		Map<String, String> payload = new HashMap<>();
		payload.put("name", name); 
		payload.put("salary", salary);
		payload.put("age", age);
		return payload;
	}
}
