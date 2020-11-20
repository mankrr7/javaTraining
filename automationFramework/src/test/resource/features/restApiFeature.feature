Feature: Validate Rest Api 

Scenario: Verify the create new employee record functionality of Rest API 
	Given user has the api "api/v1/create"
	When user hit the post api 
	Then user get the statusCode as 200 
	And user get the api response
	
Scenario: Verify the get employees functionality of Rest API
	Given user has the api "api/v1/employees"
	When user hit the get api 
	Then user get the statusCode as 200 
	And verify no duplicate id is available