package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonDriver {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public CommonDriver(String browsertype) throws Exception {
        if (browsertype.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browsertype.equalsIgnoreCase("firfox")) {
            driver = new FirefoxDriver();

        } else if (browsertype.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new Exception("");
        }
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
