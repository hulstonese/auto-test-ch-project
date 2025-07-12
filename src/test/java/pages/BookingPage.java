package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "(//a[@class='btn btn-primary'][normalize-space()='Book now'])[1]")
    WebElement firstRoom;
    @FindBy(xpath = "//*[@id=\"doReservation\"]")
    WebElement reserveNow;
    @FindBy(xpath = "//input[@placeholder='Firstname']")
    WebElement firstNameInput;
    @FindBy(xpath = "//input[@placeholder='Lastname']")
    WebElement lastNameInput;
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailInput;
    @FindBy(xpath = "//input[@placeholder='Phone']")
    WebElement phoneInput;
    @FindBy(xpath = "//button[normalize-space()='Reserve Now']")
    WebElement submitButton;
    @FindBy(css = ".alert-success")
    WebElement confirmationAlert;
    @FindBy(css = ".email-error")
    WebElement emailError;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        PageFactory.initElements(driver, this);
    }

    public void selectFirstRoom() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", firstRoom);
    }

    public void reserveNow() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", reserveNow);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void submitBooking() {
        submitButton.click();
    }

    public boolean isBookingConfirmed() {
        return wait.until(ExpectedConditions.visibilityOf(confirmationAlert)).isDisplayed();
    }

    public boolean isEmailErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(emailError)).isDisplayed();
    }
}
