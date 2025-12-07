@all
Feature: Validate product search functionality

@scenario2
Scenario: Verify search results for multiple products
Given Browser is open
When url is launched
And the user searches for "<items>"
Then first product's title should contain "<items>"
And browser is closed

Examples:
|items|
|watch|
|shoe|
|laptop|