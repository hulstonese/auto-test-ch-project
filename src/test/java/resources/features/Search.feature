@UI
Feature: Room Search Functionality

  Background:
    Given I am on the home page
 @UI1 @SMOKE
  Scenario: Successful room search with valid dates
    When I select check-in date
    And I select check-out date
    And  I click Check Availability button
    Then I should see available rooms
  @UI2 @SMOKE
  Scenario: Failed search with invalid dates
    When I select an invalid check-in date
    And I select an invalid check-out date
  #  Then I should see date validation error // No error message implementation
  @UI3 @SMOKE
  Scenario: Complete Send Us a Message fields
    When I enter Send Us a Message field details:
      | Name     | Email         | Phone       | Subject | Message                                                                                                                  |
      | John Doe | john@test.com | 12345678901 | subject | obviously we are great and happy and we know and we clap our hand look at me I am happy now and I will be happy for life |
    And I click submit button
    Then response text confirms message sent
   @UI4 @REGRESSION
  Scenario: Complete Send Us a Message with invalid phone number
    When I enter Send Us a Message field details:
      | Name     | Email         | Phone      | Subject | Message                                                                                                                  |
      | John Doe | john@test.com | 1234567890 | subject | obviously we are great and happy and we know and we clap our hand look at me I am happy now and I will be happy for life |
    And I click submit button
    Then response text confirms error message
  @UI5 @REGRESSION
  Scenario: Successful booking with valid details
    #When I click the room link
    When I select check-in date
    And I select check-out date
    And  I click Check Availability button
    When I select the first available room
    And I click on reserved button
    And I enter booking details:
      | Firstname | Lastname | Email         | Phone      |
      | John      | Doe      | john@test.com | 1234567890 |
    And I click on Reserve Now button
    Then Booking should be confirmed
