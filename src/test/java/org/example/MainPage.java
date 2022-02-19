package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver)   {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")
    private WebElement computersMenu;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a")
    private WebElement desktopsLink;

    public void processComputersMenu()  {
        Actions action = new Actions(driver);
        action.moveToElement(computersMenu).build().perform();
    }

    public void processDesktopsLink()   {
        desktopsLink.click();
    }
}
