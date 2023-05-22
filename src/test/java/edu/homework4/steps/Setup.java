package edu.homework4.steps;

import edu.homework4.pages.homepage.Home;
import edu.homework4.pages.differnetelementspage.DifferentElementsPage;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Setup {
    protected static WebDriver driver;
    protected static Properties properties;

    public static Home homePage; // is public due to usage in BadTest class :(
    protected static DifferentElementsPage differentElements;

    public Setup(WebDriver driver, Properties properties) {
        Setup.driver = driver;
        Setup.properties = properties;
    }
}