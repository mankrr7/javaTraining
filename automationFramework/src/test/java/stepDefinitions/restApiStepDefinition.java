package stepDefinitions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.cucumber.java8.En;
import io.restassured.response.Response;
import utils.PropertyUtil;
import utils.RestUtil;

public class restApiStepDefinition implements En
{
	RestUtil restUtil = new RestUtil();
	PropertyUtil prop = new PropertyUtil();
	Properties property = new Properties();
	Response response;
	String responseBody;
	
	public restApiStepDefinition() {

		Given("user has the api {string}", (String basePath) -> {
			String propertyPath = System.getProperty("user.dir") + File.separator + "src\\test\\resource\\config.properties";
			property = prop.getPropertyFileLoad(propertyPath);
			restUtil.setBaseURI(property.getProperty("baseURI"));
			restUtil.setBasePath(basePath);
			
//			System.out.println(propp.getProperty("baseURI"));
		});

		When("user hit the api", () -> {
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

	}

}
