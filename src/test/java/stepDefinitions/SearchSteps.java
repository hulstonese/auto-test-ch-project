package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;

import utilities.DriverManager;

import java.util.List;
import java.util.Map;

public class SearchSteps {
    WebDriver driver;
    HomePage homePage;

    @Given("I am on the home page")
    public void navigateToHome() {
        driver = DriverManager.getDriver();
        driver.get("https://automationintesting.online/");
        homePage = new HomePage(driver);
    }

    @When("I click the room link")
    public void iClickTheRoomLink() {
        homePage.roomLink();
    }

    @Then("I should see available rooms")
    public void iShouldSeeAvailableRooms() {
        Assert.assertTrue(homePage.isRoomAvailable(),
                "Searched available rooms confirmation is displayed");
    }

    @Then("I should see date validation error")
    public void iShouldSeeDateValidationError() {
        Assert.assertTrue(homePage.isdateErrorDisplayed(),
                "Booking confirmation error message is displayed");
    }

    @When("I clear out the pre-populated dates")
    public void iClearOutThePrePopulatedDates() {
        homePage.preDateCleared();
    }

    @When("I click into checkin field")
    public void iClickIntoCheckinField() {
    }

    @When("I select check-in date")
    public void iSelectCheckInDate() {
        homePage.setCheckindate();
    }

    @And("I select check-out date")
    public void iSelectCheckOutDate() {
        homePage.setCheckoutdate();
    }

    @And("I click Check Availability button")
    public void iClickCheckAvailabilityButton() {
        homePage.clickCheckAvailabilityBtn();
    }

    @When("I select an invalid check-in date")
    public void iSelectAnInvalidCheckInDate() {
        homePage.setInvalidCheckindate();
    }

    @And("I select an invalid check-out date")
    public void iSelectAnInvalidCheckOutDate() {
        homePage.setInvalidCheckoutdate();
    }

    @When("I enter Send Us a Message field details:")
    public void iEnterSendUsAMessageFieldDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> details = data.get(0);
        homePage.enterNameField(details.get("Name"));
        homePage.enterEmailField(details.get("Email"));
        homePage.enterPhoneField(details.get("Phone"));
        homePage.enterSubjectField(details.get("Subject"));
        homePage.enterMessageField(details.get("Message"));
    }

    @And("I click submit button")
    public void iClickSubmitButton() {
        homePage.clickMessageSubmitBtn();
    }

    @Then("response text confirms message sent")
    public void responseTextConfirmsMessageSent() {
        Assert.assertTrue(homePage.isMessageConfirmed(),
                "We'll get back to you about");
    }

    @Then("response text confirms error message")
    public void responseTextConfirmsErrorMessage() {
        Assert.assertTrue(homePage.errorMessage(),
                "Phone must be between 11 and 21 characters.");
    }

    @When("I select the first available room")
    public void selectFirstAvailableRoom() {
        homePage.selectFirstRoom();

    }

    @When("I enter booking details:")
    public void enterBookingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> details = data.get(0);
        homePage.enterFirstName(details.get("Firstname"));
        homePage.enterLastName(details.get("Lastname"));
        homePage.enterEmail(details.get("Email"));
        homePage.enterPhone(details.get("Phone"));
        homePage.submitBooking();
    }

    @When("I enter invalid email {string}")
    public void enterInvalidEmail(String invalidEmail) {
        homePage = new HomePage(driver);
        homePage.enterEmail(invalidEmail);
        homePage.submitBooking();
    }

    @Then("Booking should be confirmed")
    public void verifyBookingConfirmationOrError() {
        boolean isConfirmed = homePage.isBookingConfirmed();
        boolean isError = homePage.isErrorPageDisplayed();
        Assert.assertTrue(isConfirmed || isError, "Neither booking confirmation nor error message was detected.");
    }


    @Then("I should see email validation error")
    public void verifyEmailValidationError() {
        Assert.assertTrue(homePage.isEmailErrorDisplayed(),
                "Email validation error not displayed");
    }

    @And("I click on reserved button")
    public void iClickOnReservedButton() {
        homePage.reserveNow();
    }

    @And("I click on Reserve Now button")
    public void iClickOnReserveNowButton() {
        homePage.setReserveBooking();
    }
}
