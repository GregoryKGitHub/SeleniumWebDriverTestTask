package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriverTest {
    public static DesktopsPage desktopsPage;
    public static MainPage mainPage;
    public static ShoppingCart shoppingCart;
    public static BuildExpensiveCompPage buildExpensiveCompPage;
    public static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        desktopsPage = new DesktopsPage(driver);
        shoppingCart = new ShoppingCart(driver);
        buildExpensiveCompPage = new BuildExpensiveCompPage(driver);
        driver.manage().window().maximize();
        }
    @Test
    public void gridSizeTest() {
        driver.get(ConfProperties.getProperty("testingPageMain"));
        mainPage.processComputersMenu();
        mainPage.processDesktopsLink();
        desktopsPage.selectPageSize4();
        String gridSize = desktopsPage.getGridSize();
        Assert.assertEquals("4", gridSize);
    }
    @Test
    public void shoppingCartAddTest() throws InterruptedException {
        driver.get(ConfProperties.getProperty("testingPageMain"));
        mainPage.processComputersMenu();
        mainPage.processDesktopsLink();
        desktopsPage.selectPageSize4();
        desktopsPage.sortHighToLow();
        desktopsPage.addToCart();                           //Возможно не совсем правильно понял задание и добавил
        Thread.sleep(2000);                           //нажатие еще одной кнопки addToCart в выборе дополнительных
        buildExpensiveCompPage.addToCartButton();          //характеристик продукта и сравнил по названию
        Thread.sleep(2000);                          //продукт в окне и продукт в корзине
        String itemInWindow = buildExpensiveCompPage.getItemInWindow();
        String itemInCart = buildExpensiveCompPage.getItemInCart();
        Assert.assertEquals(itemInWindow, itemInCart);
    }
    @Test
    public void shoppingCartIncrementTest() throws InterruptedException {
        driver.get(ConfProperties.getProperty("testingChooseParametersPage"));
        buildExpensiveCompPage.chooseFastProcessor();
        buildExpensiveCompPage.chooseRam8Gb();
        buildExpensiveCompPage.chooseSoftwareImageViewer();
        buildExpensiveCompPage.chooseSoftwareOfficeSuit();
        buildExpensiveCompPage.chooseSoftwareOtherOfficeSuit();
        int cartQtyBeforeAdd = buildExpensiveCompPage.getCartQuantity();
        buildExpensiveCompPage.addToCartButton();
        Thread.sleep(2000);
        int cartQtyAfterAdd = buildExpensiveCompPage.getCartQuantity();
        Assert.assertEquals(++cartQtyBeforeAdd,cartQtyAfterAdd);
    }
    @Test
    public void shoppingCartPriceTest() {
        driver.get(ConfProperties.getProperty("testingChooseParametersPage"));
        buildExpensiveCompPage.chooseFastProcessor();
        buildExpensiveCompPage.chooseRam8Gb();
        buildExpensiveCompPage.chooseSoftwareImageViewer();
        buildExpensiveCompPage.chooseSoftwareOfficeSuit();
        buildExpensiveCompPage.chooseSoftwareOtherOfficeSuit();
        buildExpensiveCompPage.addToCartButton();
        buildExpensiveCompPage.processShoppingCartLink();
        Assert.assertEquals(2105.0, shoppingCart.getTotalPrice(), 0);
    }
    @Test
    public void shoppingCartItemTest(){
        driver.get(ConfProperties.getProperty("testingChooseParametersPage"));
        buildExpensiveCompPage.chooseFastProcessor();
        buildExpensiveCompPage.chooseRam8Gb();
        buildExpensiveCompPage.chooseSoftwareImageViewer();
        buildExpensiveCompPage.chooseSoftwareOfficeSuit();
        buildExpensiveCompPage.chooseSoftwareOtherOfficeSuit();
        buildExpensiveCompPage.addToCartButton();
        String orderingItem = buildExpensiveCompPage.getItemInWindow();
        buildExpensiveCompPage.processShoppingCartLink();
        String itemInCart = shoppingCart.getItemName();
        Assert.assertEquals(orderingItem, itemInCart);
        shoppingCart.tagRemoveFlag();
        shoppingCart.updateCart();
    }
    @AfterClass
    public static void closeDriver()    {
        driver.close();
    }
}
