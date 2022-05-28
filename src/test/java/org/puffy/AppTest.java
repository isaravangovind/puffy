package org.puffy;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.pages.PageObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

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
       $("//a[@class='nav__link'][text()='Explore']").click();
        assertTrue("Title Mismatch", getTitle().equals("Jungle NFT | Buy, Sell & Create NFT Marketplace"));
    }

}
