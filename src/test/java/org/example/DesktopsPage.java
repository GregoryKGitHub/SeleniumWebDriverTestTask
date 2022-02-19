package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DesktopsPage {
    public WebDriver driver;
    public DesktopsPage(WebDriver driver)   {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"products-pagesize\"]")
    private WebElement productPageSize;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]")
    private WebElement productGrid;

    @FindBy(xpath = "//*[@id=\"products-orderby\"]")
    private WebElement productSorting;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")
    private WebElement addToCartBtn;

    public void selectPageSize4()   {
        Select select = new Select(productPageSize);
        select.selectByVisibleText("4");
    }

    public String getGridSize() {
        String gridSize = productGrid.getAttribute("childElementCount");
        return gridSize;
    }

    public void sortHighToLow() {
        Select select = new Select(productSorting);
        select.selectByVisibleText("Price: High to Low");
    }

    public void addToCart() {
        addToCartBtn.click();
    }
}
