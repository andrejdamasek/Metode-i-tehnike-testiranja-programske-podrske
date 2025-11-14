import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

    public WebDriver driver;
    public String testURL = "http://www.google.com";
    @BeforeMethod
    //prije svake metode se pokrece
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\student\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(10000);
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("ferit");
        searchTextBox.submit();
        Thread.sleep(15000);
        WebElement testLink =
                driver.findElement(By.xpath("/html/body/div[3]/div/div[12]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")
                );
        Assert.assertEquals(testLink.getText(), "gugugaga");
        System.out.print(testLink.getText());
    }
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }

}
