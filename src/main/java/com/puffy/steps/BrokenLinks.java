package com.puffy.steps;

import com.puffy.pages.JungleHomePage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.junit.Assert.assertTrue;


public class BrokenLinks {

    JungleHomePage junglehomepage;

    @Step("Launch JUNGLE app")
    public void launchApp(){
        junglehomepage.open();
     //   return this;
    }

    @Step("Check of Broken Links")
    public void getBrokenLinks(){
        String links = null;
      List<String> brokenLinks = junglehomepage.getAllBrokenLinks();
        System.out.println(StringUtils.join(brokenLinks, ", "));
        Serenity.recordReportData().withTitle("Broken Links @ " + getDriver().getCurrentUrl()).andContents(StringUtils.join(brokenLinks, ", \n"));
        if (brokenLinks.size()>0) {
            assertTrue("There is broken links ", false);
        }

    }
}
