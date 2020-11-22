package stepDefinitions;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import io.cucumber.java8.En;
import io.restassured.response.Response;
import utils.PropertyUtil;
import utils.RestUtil;
import utils.Util;

public class restApiStepDefinition implements En
{
	RestUtil restUtil = new RestUtil();
	PropertyUtil prop = new PropertyUtil();
	Properties property = new Properties();
	Response response;
	String responseBody;
	String propertyPath = System.getProperty("user.dir") + File.separator + "src\\test\\resource\\config.properties";
	
	public restApiStepDefinition() {

		Given("user has the api {string}", (String basePath) -> {
//			String propertyPath = System.getProperty("user.dir") + File.separator + "src\\test\\resource\\config.properties";
			property = prop.getPropertyFileLoad(propertyPath);
			restUtil.setBaseURI(property.getProperty("baseURI"));
			restUtil.setBasePath(basePath);
		});

		When("user hit the post api", () -> {
			Map<String, String> payload  = new HashMap<String, String>();
			payload = restUtil.postPayload("RestAssuredAssignment", "1111", "24");
			response = restUtil.postApiResponse(payload);
		});

		Then("user get the statusCode as {int}", (Integer int1) -> {
			int statusCode = restUtil.getStatusCode(response);
			System.out.println("StatusCode: "+ statusCode);
		});

		Then("user get the api response", () -> {
			responseBody = restUtil.getResponseBodyAsString(response);
			System.out.println("Response: "+responseBody);
			String dataId = restUtil.getStringReponseFromReponse(responseBody, "data.id");
			System.out.println("Message value: " + dataId);
		});

		When("user hit the get api", () -> {
			response = restUtil.getApiResponse();
		});
		
		Then("verify no duplicate id is available", () -> {
			responseBody = restUtil.getResponseBodyAsString(response);
			System.out.println("Response: "+responseBody);
			List<String> jsonResponse = new ArrayList<String>();
			jsonResponse = restUtil.getStringListReponseFromReponse(responseBody, "data.id");
			Util.verifyDuplicateList(jsonResponse);
		});
		
		Then("print id and name on console", () -> {
			responseBody = restUtil.getResponseBodyAsString(response);
			List<String> employeeId = new ArrayList<String>();
			List<String> employeeName = new ArrayList<String>();
			employeeId = restUtil.getStringListReponseFromReponse(responseBody, "data.id");
			employeeName = restUtil.getStringListReponseFromReponse(responseBody, "data.employee_name");
			System.out.println("\n*********** Employee Details ***********");
			for (int i=0; i<employeeId.size();i++)
				System.out.println(employeeId.get(i) + " : " + employeeName.get(i));
		});
		
	}

}
