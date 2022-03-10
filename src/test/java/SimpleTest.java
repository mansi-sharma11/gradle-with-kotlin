import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SimpleTest  {
    @Test
    public void simpleTest(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.amazon.com");
        webDriver.close();

    }
}
