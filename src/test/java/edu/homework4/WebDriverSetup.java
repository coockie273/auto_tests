package edu.homework4;

import edu.homework4.steps.Action;
import edu.homework4.steps.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class WebDriverSetup {
    protected static WebDriver driver;

    protected static Action action;
    protected static Assert assertion;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Path.of("src/test/resources/data.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        action = new Action(driver, properties);
        assertion = new Assert(driver, properties);

        // 1. Open test site by URL
        action.navigateToHomePage();

        // 3. Perform login
        action.performLogin();
    }

    @AfterTest
    public static void exit() {
        //10. Close Browser
        driver.close();
    }
}
