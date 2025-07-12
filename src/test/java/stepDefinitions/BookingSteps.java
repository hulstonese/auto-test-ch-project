//package stepDefinitions;

/*import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.homePage;
import pages.HomePage;
import utilities.DriverManager;

import java.util.Map;

public class BookingSteps {

    WebDriver driver;
    HomePage homePage;
    BookingPage bookingPage;

    @Given("I have searched for available rooms")
    public void searchAvailableRooms() {
        driver = DriverManager.getDriver();
        bookingPage = new BookingPage(driver);
        // Using valid default dates for pre-requisite search
        //homePage.searchRooms("01/09/2025", "05/09/2025");
    }

    @When("I select the first available room")
    public void selectFirstAvailableRoom() {
        bookingPage.selectFirstRoom();
        bookingPage.reserveNow();
    }

    @When("I enter booking details:")
    public void enterBookingDetails(Map<String, String> dataTable) {
        bookingPage.enterFirstName(dataTable.get("Firstname"));
        bookingPage.enterLastName(dataTable.get("Lastname"));
        bookingPage.enterEmail(dataTable.get("Email"));
        bookingPage.enterPhone(dataTable.get("Phone"));
        bookingPage.submitBooking();
    }

    @When("I enter invalid email {string}")
    public void enterInvalidEmail(String invalidEmail) {
        bookingPage = new BookingPage(driver);
        bookingPage.enterEmail(invalidEmail);
        bookingPage.submitBooking();
    }

    @Then("Booking should be confirmed")
    public void verifyBookingConfirmation() {
        Assert.assertTrue(bookingPage.isBookingConfirmed(),
                "Booking confirmation message not displayed");
    }

    @Then("I should see email validation error")
    public void verifyEmailValidationError() {
        Assert.assertTrue(bookingPage.isEmailErrorDisplayed(),
                "Email validation error not displayed");
    }*/

//}
