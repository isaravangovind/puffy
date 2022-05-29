package com.puffy.base;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasePage extends PageObject {

    public void scrollToview(WebElementFacade element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForCondition().until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForAlert(){
        waitFor(ExpectedConditions.alertIsPresent());
        return false;
    }


    public List<String> validateBrokenLinks() {

        HttpURLConnection huc = null;
        int respCode = 200;
        String url = "";

//    String homePage = "https://jungle.co/";
        List<WebElementFacade> links = findAll(By.tagName("a"));
        Iterator<WebElementFacade> it = links.iterator();
        List<String> brokenUrls = new ArrayList<>();

        while (it.hasNext()) {

            try {
                url = it.next().getAttribute("href");

                if (url == null || url.isEmpty()) {
                    System.out.println("URL is either not configured for anchor tag or it is empty");
                    brokenUrls.add(url);
                    continue;
                }
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setConnectTimeout(5000);
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();

                if (respCode >= 400) {
                    brokenUrls.add(url + "    ---->   " + huc.getResponseMessage());
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return brokenUrls;

    }

}
