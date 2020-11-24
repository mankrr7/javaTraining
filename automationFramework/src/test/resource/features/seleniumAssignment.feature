Feature: Validate the purchase functionality on online shopping website

Scenario Outline: Verify that user is able to purchase product successfully 
	Given user has the website access "http://automationpractice.com/index.php" on '<browsername>'
	When user navigate to website
	And search any product
	And select the second entry
	And click to Add cart
	And click on proceed button
	And compare summary amount with initial amount
	And register the account
	And purchase the product 
	Then user validates the product is purchased successfully 
	And user validates the product amount
	And user closes the website
	Examples:
	|browsername|
	|ie|
	|chrome|