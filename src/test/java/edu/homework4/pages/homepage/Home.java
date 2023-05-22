package edu.homework4.pages.homepage;

import edu.homework4.pages.homepage.elements.Header;
import edu.homework4.pages.homepage.elements.IFrame;
import edu.homework4.pages.homepage.elements.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class Home {
    private static WebDriver driver;
    private static Properties properties;

    private final Header headerSection;
    private final Menu leftSection;

    @FindBy(id = "name")
    private WebElement loginName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "html > body > header > div > nav > ul.uui-navigation.navbar-nav.navbar-right > li > a > span")
    private WebElement loginDropDownButton;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitIconsTexts;

    @FindBy(tagName = "iframe")
    private WebElement frame;

    public Home(WebDriver driver, Properties properties) {
        Home.driver = driver;
        Home.properties = properties;

        driver.navigate().to(properties.getProperty("site.url"));

        PageFactory.initElements(driver, this);

        headerSection = new Header(driver);
        leftSection = new Menu(driver);
    }

    public void performLogin() {
        loginDropDownButton.click();
        this.loginName.sendKeys(properties.getProperty("user.name"));
        this.password.sendKeys(properties.getProperty("user.password"));
        loginButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getLoggedName() {
        return userName.getText();
    }

    public Header getHeaderSection() {
        return headerSection;
    }

    public int getBenefitIconsSize() {
        return benefitIcons.size();
    }

    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    public int getBenefitIconsTextsSize() {
        return benefitIconsTexts.size();
    }

    public List<String> getBenefitIconsTextsStrings() {
        return benefitIconsTexts.stream().map(WebElement::getText).toList();
    }

    public Menu getLeftSection() {
        return leftSection;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return new IFrame(driver).getFrameButton();
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }
}