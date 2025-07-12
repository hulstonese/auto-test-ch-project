package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utilities.DriverManager;

public class Hooks {
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot logic
        }
        DriverManager.quitDriver();
    }
}
