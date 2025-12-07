@all
Feature: Validate Today's Deals page and product details

@scenario1
Scenario: Verify Today's Deals page attributes and product details
Given Browser is open
When url is launched
Then title and url of the page should be verfied
When the user clicks on Today's Deals
Then the page contains the title Today's Deals
When first item of Today's Deals is clicked
Then same product name should be displayed and verified
When second item of Today's Deals is clicked
Then same product name should be displayed and verified
And browser is closed