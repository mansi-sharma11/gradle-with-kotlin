package com.gwk.uitests;

import common.CommonDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleTest extends BaseTest {
    CommonDriver commonDriver;

    @Test
    public void simpleTest() {
        Assert.assertEquals(commonDriver.getDriver().getTitle(), "Google");
    }

}


