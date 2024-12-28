package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class RandomScenariosPage extends BasePage{

	public RandomScenariosPage(WebDriver driver) {
		super(driver);
	addObject("firstNameLastnameLink", By.xpath("//div/span[@class='pageDescription']"));
	
	//************* TC-34 *****************
	addObject("usermenuDropdown", By.xpath("//span[@id='userNavLabel']"));
	addObject("firstnameLastname", By.xpath("//div/span/h1/a"));
	//******************** tc-35 ****************
	addObject("tabBarMenu1", By.xpath("//ul[@id='tabBar']/li"));
	addObject("tabBarMenu2", By.xpath("//ul[@id='tabBar']/li"));
	addObject("allTabs", By.xpath("//a/img[@alt='All Tabs']"));
	addObject("customiseTab", By.xpath("//input[@name='customize']"));
	addObject("selectedTab", By.xpath("//select[@name='duel_select_1']"));
	addObject("removeBtn", By.xpath("//a/img[@alt='Remove']"));
	addObject("saveBtn", By.xpath("//tbody/tr[1]/td[2]/input[@class='btn primary']"));
	//**************** tc-36 *********************
	addObject("dateLink", By.xpath("//span[@class='pageDescription']/a/../../../../../div/div[1]//div[2]/span[2]/a"));
	addObject("link_8pm",By.xpath("//a[normalize-space()='8:00 pm']"));
	addObject("subjectTab",By.xpath("//tbody/tr[2]/td[2]/div[1]/input[@id='evt5']"));
	addObject("endDate",By.xpath("//span/input[@id='EndDateTime']"));
	addObject("endTime",By.xpath("//span/input[@id='EndDateTime_time']"));
	addObject("saveBtnInCalender",By.xpath("//tbody/tr[1]/td[@id='topButtonRow']/input[1]"));
	//*************** TC-37 *******************
	addObject("link_4pm",By.xpath("//a[normalize-space()='4:00 pm']"));
	addObject("endDateDropdown",By.xpath("//div[@id='timePickerItem_38']"));
	addObject("recurrence",By.xpath("//tbody/tr/td/div/input[@id='IsRecurrence']"));
	addObject("weeklyRadioBtn",By.xpath("//input[@id='rectypeftw']"));
	addObject("recurrenceOfEvery",By.xpath("//table[@class='recurrenceTable']/tbody/tr/td[2]/div[1]/div[2]/input[@value='1']"));
	addObject("recurrenceEndDate", By.xpath("//span/input[@id='RecurrenceEndDateOnly']"));
	addObject("actualMonth", By.name("calMonthPicker"));
	addObject("actualYear", By.name("calYearPicker"));
	addObject("nextBtnInCalender", By.xpath("//img[@alt='Next Month']"));
	addObject("expectedDate", By.xpath("//tbody/tr[4]/td[text()='15']"));
	addObject("saveBtnInCalender2", By.xpath("//div[@id='ep']//div[contains(@class,'pbHeader')]//input[1]"));
	addObject("monthView", By.xpath("//img[contains(@class,'monthViewIcon')]"));
	addObject("nextMonth", By.xpath("//img[contains(@class,'nextCalArrow')]"));
	
	}

}
