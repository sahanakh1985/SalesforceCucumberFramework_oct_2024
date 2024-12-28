package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class LeadPage extends BasePage {

	public LeadPage(WebDriver driver) {
		super(driver);

		addObject("leadTab", By.xpath("//li[@id='Lead_Tab']/a"));
		// *********** select leadDropdown ******************
		addObject("leadDropdownElements", By.xpath("//select[@id='fcf']"));
		// ***************** default lead view ****************
		addObject("leadViewDropdown", By.xpath("//span[1]/select[@id='fcf']"));
		// ****************************
		addObject("newBtn", By.xpath("//input[@name='new']"));
		addObject("lastNameTb", By.id("name_lastlea2"));
		addObject("companyNameTb", By.xpath("//tbody/tr[5]/td[2]/div[1]/input"));
		addObject("topSaveBtn", By.xpath("//tr/td[@id='topButtonRow']/input[@name='save']"));
	}

}
