package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class OpportunityPage extends BasePage{

	public OpportunityPage(WebDriver driver) {
		super(driver);
		//************ TC-15 ************
		addObject("opportunityTab", By.xpath("//li[@id='Opportunity_Tab']"));
		addObject("opportunityDropdown", By.id("fcf"));
		//*********** TC-16 **************
		addObject("newBtn", By.xpath("//input[@title='New']"));
		addObject("opportunityName", By.xpath("//input[@name='opp3']"));
		addObject("accountName", By.xpath("//input[@name='opp4']"));
		addObject("closeDate", By.xpath("//input[@name='opp9']"));
		addObject("stageElement", By.xpath("//select[@id='opp11']"));
		addObject("probabilityPercentage", By.xpath("//input[@id='opp12']"));
		addObject("leadSource", By.xpath("//select[@id='opp6']"));
		addObject("primaryCampaign", By.xpath("//input[@id='opp17']"));
		addObject("saveBtnInCreateOpp", By.xpath("//td[@id='topButtonRow']/input[@title='Save']"));
		//**************** TC-17 ***************
		addObject("pipeLineLink", By.xpath("//a[text()='Opportunity Pipeline']"));
		//************** TC-18 **********************
		addObject("stuckOppLink", By.xpath("//a[text()='Stuck Opportunities']"));
		//************* TC-19 ********************
		addObject("intrvalTb", By.xpath("//select[@id='quarter_q']"));
		addObject("intervalDropdown", By.xpath("//select[@id='quarter_q']"));
		addObject("includeDropdown", By.xpath("//select[@id='open']"));
		addObject("runBtn", By.xpath("//input[@value='Run Report']"));
	}

}
