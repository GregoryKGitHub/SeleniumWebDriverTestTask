package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
    public WebDriver driver;
    public ShoppingCart(WebDriver driver)   {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[6]/span[2]")
    private WebElement totalPrice;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[3]/a")
    private WebElement itemNameInCart;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[1]/input")
    private WebElement removeFlag;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[1]/div/input[1]")
    private WebElement updateBtn;

    public double getTotalPrice()   {
        return Double.parseDouble(totalPrice.getAttribute("innerText"));
    }

    public String getItemName() {
        return itemNameInCart.getAttribute("innerText");
    }

    public void tagRemoveFlag() {
        removeFlag.click();
    }

    public void updateCart()    {
        updateBtn.click();
    }
}
