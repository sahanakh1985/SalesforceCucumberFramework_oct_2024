package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class MySettingsPage extends BasePage{

	public MySettingsPage(WebDriver driver) {
		super(driver);
		addObject("mySettings", By.xpath("//a[@title='My Settings']"));
		addObject("personalLink", By.xpath("//span[@id='PersonalInfo_font']"));
		addObject("loginHistory", By.id("LoginHistory_font"));
		addObject("downloadLink", By.xpath("//a[contains(text(),'Download login')]"));
		//************** display and layout
		addObject("displayAndLayoutLink", By.id("DisplayAndLayout_font"));
		addObject("customiseMyTab", By.id("CustomizeTabs_font"));
		addObject("availableTabDropdown", By.id("duel_select_0"));
		addObject("addBtn", By.xpath("//a[@id='duel_select_0_right']/img"));
		addObject("saveBtnInDisplayAndLayout", By.xpath("//input[@class='btn primary']"));
		//************** email settings****************
		addObject("emailSettings", By.xpath("//span[@id='EmailSetup_font']"));
		addObject("myEmailSettings", By.id("EmailSettings_font"));
		addObject("emailNameTab", By.id("sender_name"));
		addObject("emailAddressTab", By.id("sender_email"));
		addObject("bbcRadioBtn", By.id("auto_bcc1"));
		addObject("saveBtnInEmailSettings", By.name("save"));
		//************** calender and reminder ***************
		addObject("calenderAndRemindersLink", By.id("CalendarAndReminders_font"));
		addObject("acivityRemindersLink", By.id("Reminders_font"));
		addObject("openTestBtn", By.id("testbtn"));
		addObject("cancelBtn", By.xpath("//input[@name='cancel']"));
		
		}

}
