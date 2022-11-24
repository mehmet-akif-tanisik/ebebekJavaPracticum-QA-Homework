package seleniumuitest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "testdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.e-bebek.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/cx-storefront/header/cx-page-layout[1]/div/div[1]/div[2]/cx-page-layout/cx-page-slot/eb-search-box/div/div/img")));
        WebElement search = driver.findElement(By.id("txtSearchBox"));
        search.sendKeys("biberon", Keys.ENTER);
        Thread.sleep(5000);


        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@id=\"cmbSortRelevance\"]/div/div/a/text()"), "Akıllı Sıralama"));
        WebElement productItem = driver.findElement(By.className("product-item"));
        productItem.click();


        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("btnProductDetailsTab"), "Ürün Özellikleri"));
        WebElement productButton = driver.findElement(By.id("addToCartBtn"));
        productButton.click();



        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnShowCart")));
        WebElement showProduct = driver.findElement(By.id("btnShowCart"));
        showProduct.click();

        WebElement productNumber = driver.findElement(By.xpath("/html/body/app-root/cx-storefront/header/cx-page-layout[1]/div/div[1]/div[3]/cx-page-layout/cx-page-slot[3]/eb-mini-cart/a/span/span"));
        String text = productNumber.getAttribute("textContent");

        if(text.equals("1")) {
            System.out.println("Add to cart test is passed.");
            System.out.println("Expected output : 1");
            System.out.println("Received output : " + text);
        } else {
            System.out.println("Add to cart test is failed.");
            System.out.println("Expected output : 1");
            System.out.println("Received output : " + text);
        }

    }

}
