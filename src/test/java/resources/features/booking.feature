#Feature: Room Booking Functionality

 # Scenario: Successful booking with valid details
  #  Given I am on the home page
   # When I click the room link
    #When I select check-in date
    #And I select check-out date
    #And  I click Check Availability button
   # When I select the first available room
   # And I enter booking details:
    #  | Firstname | Lastname | Email         | Phone      |
   #   | John      | Doe      | john@test.com | 1234567890 |
   # Then Booking should be confirmed

 # Scenario: Failed booking with invalid email
  #  Given I have searched for available rooms
  #  When I select the first available room
   # And I enter invalid email "john@invalid"
  #  Then I should see email validation errorMessage
#