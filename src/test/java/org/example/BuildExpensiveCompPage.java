package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuildExpensiveCompPage {
    public WebDriver driver;
    public BuildExpensiveCompPage(WebDriver driver)   {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"add-to-cart-button-74\"]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"flyout-cart\"]/div/div[2]/div/div[2]/div[1]/a")
    private WebElement itemInCart;

    @FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[1]/h1")
    private WebElement itemInWindow;

    @FindBy(xpath = "//*[@id=\"product_attribute_74_5_26_82\"]")
    private WebElement fastProcessor;

    @FindBy(xpath = "//*[@id=\"product_attribute_74_6_27_85\"]")
    private WebElement ram8Gb;

    @FindBy(xpath = "//*[@id=\"product_attribute_74_8_29_88\"]")
    private WebElement softwareImageViewer;

    @FindBy(xpath = "//*[@id=\"product_attribute_74_8_29_89\"]")
    private WebElement softwareOfficeSuit;

    @FindBy(xpath = "//*[@id=\"product_attribute_74_8_29_90\"]")
    private WebElement softwareOtherOfficeSuit;

    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[2]")
    private WebElement cartQuantity;

    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a")
    private WebElement shoppingCartLink;

    public void addToCartButton()    {
        addToCartButton.click();
    }

    public String getItemInCart()   {
         return itemInCart.getAttribute("innerText");
    }

    public String getItemInWindow() {
        return itemInWindow.getText();
    }

    public void chooseFastProcessor()   {
        fastProcessor.click();
    }

    public void chooseRam8Gb()  {
        ram8Gb.click();
    }

    public void chooseSoftwareImageViewer() {
        softwareImageViewer.click();
    }

    public void chooseSoftwareOfficeSuit()  {
        softwareOfficeSuit.click();
    }

    public void chooseSoftwareOtherOfficeSuit() {
        softwareOtherOfficeSuit.click();
    }

    public int getCartQuantity()    {
        String innerText = cartQuantity.getAttribute("innerText");
        String[] innerTextArr = innerText.split("\\D");
        return Integer.parseInt(String.join("", innerTextArr));
    }

    public void processShoppingCartLink()   {
        shoppingCartLink.click();
    }
}
