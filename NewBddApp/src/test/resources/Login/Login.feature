@HotelBookingLogin

Feature: Login

Scenario: check the heading of the login page
Given User is on login page
Then check the heading of the page

Scenario: Successful login with valid data

Given User is on login page
When user enters valid username, valid password
Then navigate to hotelBooking 

Scenario: Prompt user to enter the data when he leaves the login fields empty
Given User is on login page
When user doesnot enter either username or password
And clicks the Login Button
Then display appropriate message
