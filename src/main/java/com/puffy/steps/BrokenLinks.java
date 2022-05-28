package com.puffy.steps;

import com.puffy.pages.JungleHome;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class BrokenLinks {

    JungleHome junglehome;

    @Step("Launch JUNGLE app")
    public void launchApp(){
        junglehome.open();
     //   return this;
    }

    @Step("Check of Broken Links")
    public void getBrokenLinks(){
        String links = null;
      List<String> brokenLinks = junglehome.getAllBrokenLinks();
        System.out.println(StringUtils.join(brokenLinks, ", "));
        Serenity.recordReportData().withTitle("Broken Links").andContents(StringUtils.join(brokenLinks, ", \n"));
        if (brokenLinks.size()>0) {
            assertTrue("There is broken links ", false);
        }

    }
}
