Feature: Validate Rest Api 

Scenario: Verify the create new employee record functionality of Rest API 
	Given user has the website access "http://automationpractice.com/index.php"
	When user navigate to website
	And search any product
	And select the second entry
	And click to Add cart
	And click on proceed button
	And compare summary amount with initial amount
	And register the account
	And purchase the product 
	Then user validates the product is purchased successfully 
	And user validates the proudct amount