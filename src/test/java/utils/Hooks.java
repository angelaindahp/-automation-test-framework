package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("=== Test Dimulai ===");
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        System.out.println("=== Test Selesai ===");
        DriverFactory.quitDriver();
    }
}

