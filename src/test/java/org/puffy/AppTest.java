package org.puffy;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

// assertTrue( true );
@Narrative(text={"Test",
"epic",
"theme"}
)
@ExtendWith(SerenityJUnit5Extension.class)
public class AppTest extends PageObject
{
    @Managed
    WebDriver driver;

    @Title("Lanuch Browser")
    @Test
    public void launchBrowser() throws InterruptedException {
       open();
//        System.out.println("============BEFORE==========");
//        System.out.println(driver.getPageSource());

       $("//input[@name='email']").type("sys");
       Thread.sleep(5000);
       $("//button[text()='Sign up']").click();
        Thread.sleep(2000);
//        System.out.println("**************************");
//        System.out.println("============AFTER==========");
//        String messageText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML", "Please fill in this field.");
//        System.out.println(messageText);
//        System.out.println(driver.getPageSource());
        Assert.assertTrue(driver.getPageSource().contains("Please include"));




    }

}
