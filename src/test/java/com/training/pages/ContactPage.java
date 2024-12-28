package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class ContactPage extends BasePage{

	public ContactPage(WebDriver driver) {
		super(driver);
		addObject("contactTab", By.xpath("//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[5]/a[1]"));
		addObject("newBtnInContact", By.name("new"));
		addObject("accountNameTb", By.xpath("//tr/td[2]/span[@class='lookupInput']/input[@name='con4']"));
		addObject("lastNameTb", By.id("name_lastcon2"));
		addObject("saveBtn", By.xpath("//td[@id='topButtonRow']/input[@name='save']"));
		//*******************
		addObject("newViewLinkInContact", By.xpath("//a[text()='Create New View']"));
		addObject("viewNameTb", By.xpath("//input[@id='fname']"));
		addObject("saveBtnCreateView", By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		//********************************* TC-27 ****************
		addObject("recentlyCreatedContactList", By.xpath("//select[@id='hotlist_mode']"));
		//************ tc-28*****************
		addObject("myContactDropdown", By.xpath("//select[@id='fcf']"));
		addObject("contactHomeElement", By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		//***************** TC-29 ******************
		addObject("contactNameUnderRecentContact", By.xpath("//tbody/tr[2]/th"));
		
		//****************TC-30 *****************
		addObject("createNewViewLink", By.xpath("//a[text()='Create New View']"));
		addObject("viewUniqueNameTb", By.id("devname"));
		addObject("saveBtnInNewView", By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		addObject("errMsg", By.xpath("//div[text()=' You must enter a value']"));
		//***************** TC-31 ********************
		addObject("cancelBtn", By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[2]"));
		// ****************** TC-32 ******************
		addObject("saveAndNewButton", By.xpath("//td[@id='topButtonRow']//input[@name='save_new']"));
		addObject("errorMsgAfterClickingSaveAndButton", By.xpath("//div[@id='errorDiv_ep']"));
	}

}
