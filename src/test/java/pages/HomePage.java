package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//*[@id=\"booking\"]/div/div/div/form/div/div[1]/div[1]/div/input")
    WebElement defaultCheckinInput;
    @FindBy(xpath = "//*[@id=\"booking\"]/div/div/div/form/div/div[2]/div/div/input")
    WebElement defaultCheckOutInput;

    @FindBy(xpath = "//div[@aria-label='Choose Friday, 25 July 2025']")
    WebElement checkindate;

    @FindBy(xpath = "//div[@aria-label='Choose Wednesday, 30 July 2025']")
    WebElement checkoutdate;

    @FindBy(xpath = "//div[@aria-label='Choose Tuesday, 8 July 2025']")
    WebElement invalidCheckindate;

    @FindBy(xpath = "//div[@aria-label='Choose Tuesday, 1 July 2025']")
    WebElement invalidCheckoutdate;

    @FindBy(xpath = "//button[normalize-space()='Check Availability']")
    WebElement searchBtn;
    @FindBy(xpath = "//a[@class='nav-link'][normalize-space()='Rooms']")
    WebElement roomLink;
    @FindBy(xpath = "//*[@id=\"booking\"]/div/div/div/form/div/div[4]/button")
    WebElement roomAvailableAlert;
    @FindBy(css = ".date-error") // This can not be implemented because no error message
    WebElement dateError;

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement phoneField;

    @FindBy(xpath = "//input[@id='subject']")
    WebElement subjectField;

    @FindBy(xpath = "//textarea[@id='description']")
    WebElement messageField;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//section[@id='contact']//p[1]")
    WebElement msgConfirmation;

    @FindBy(xpath = "//p[normalize-space()='Phone must be between 11 and 21 characters.']")
    WebElement errorMessage;

    @FindBy(xpath = "(//a[@class='btn btn-primary'][normalize-space()='Book now'])[1]")
    WebElement firstRoom;

    @FindBy(xpath = "//button[normalize-space()='Today']") WebElement bookToday;

    @FindBy(id = "doReservation")
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
    @FindBy(xpath = "//h2[@class='card-title fs-4 fw-bold mb-3']")
    WebElement confirmationAlert;
    @FindBy(xpath = "//body//div//h2[1]") WebElement errorMessageElement;
    @FindBy(css = ".email-error")
    WebElement emailError;
    @FindBy(xpath = "//button[normalize-space()='Reserve Now']")
    WebElement reserveBooking;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void roomLink() {
        wait.until(ExpectedConditions.elementToBeClickable(roomLink)).click();
    }

    public void preDateCleared() {
        defaultCheckinInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        defaultCheckOutInput.sendKeys(Keys.DELETE);
        defaultCheckOutInput.clear();
    }

    public void setCheckindate() {
        wait.until(ExpectedConditions.elementToBeClickable(defaultCheckinInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkindate)).click();
    }

    public void setCheckoutdate() {
        wait.until(ExpectedConditions.elementToBeClickable(defaultCheckOutInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutdate)).click();
    }

    public void setInvalidCheckindate() {
        wait.until(ExpectedConditions.elementToBeClickable(defaultCheckinInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(invalidCheckindate)).click();
    }

    public void setInvalidCheckoutdate() {
        wait.until(ExpectedConditions.elementToBeClickable(defaultCheckOutInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(invalidCheckoutdate)).click();
    }


    public boolean isRoomAvailable() {
        return wait.until(ExpectedConditions.visibilityOf(roomAvailableAlert)).isDisplayed();
    }

    public boolean isdateErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(dateError)).isDisplayed();
    }

    public void clickCheckAvailabilityBtn() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", searchBtn);

    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,950)", "");
    }

    public void enterNameField(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameField)).sendKeys(name);
    }

    public void enterPhoneField(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneField)).sendKeys(phone);
    }

    public void enterEmailField(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
    }

    public void enterSubjectField(String subject) {
        wait.until(ExpectedConditions.visibilityOf(subjectField)).sendKeys(subject);
    }

    public void enterMessageField(String message) {
        wait.until(ExpectedConditions.visibilityOf(messageField)).sendKeys(message);
    }

    public void clickMessageSubmitBtn() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", submitBtn);
    }

    public boolean isMessageConfirmed() {
        return wait.until(ExpectedConditions.visibilityOf(msgConfirmation)).isDisplayed();
    }

    public boolean errorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
    }

    public void selectFirstRoom() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", firstRoom);
    }

    public void reserveNow() {
        wait.until(ExpectedConditions.elementToBeClickable(bookToday)).click();
        new Actions(driver)
                .scrollToElement(reserveNow)
                .moveToElement(reserveNow)
                .pause(300)
                .click(reserveNow)
                .perform();

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

    /**
     * Checks if the booking confirmation page is displayed.
     * @return true if confirmation page is visible, false otherwise.
     */

    public boolean isBookingConfirmed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(confirmationAlert)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            // Element not found or not visible within the wait time
            return false;
        } catch (Exception e) {
            // Handle any other unexpected exceptions if needed
            return false;
        }
    }

    /**
     * Checks if the error message page is displayed.
     * @return true if error message element is visible, false otherwise.
     */

    public boolean isErrorPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessageElement)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            // Element not found or not visible within the wait time
            return false;
        } catch (Exception e) {
            // Handle any other unexpected exceptions if needed
            return false;
        }
     }


    public boolean isEmailErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(emailError)).isDisplayed();
    }

    public void setReserveBooking() {
        reserveBooking.click();
    }
}
