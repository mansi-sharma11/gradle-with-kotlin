package com.gwk.uitests;

import common.CommonDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    CommonDriver commonDriver;
    SimpleTest simpleTest;

    @BeforeClass
    public void stepup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        commonDriver = new CommonDriver("chrome");
        commonDriver.openPage("https://www.google.com");
        simpleTest =  new SimpleTest();
    }

    @AfterClass
    public void cleanUp() {
        commonDriver.close();
    }
}
