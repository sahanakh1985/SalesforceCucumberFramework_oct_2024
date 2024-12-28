package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
		addObject("accountTab", By.xpath("//a[@title='Accounts Tab']"));
		addObject("newBtn", By.xpath("//input[@name='new']"));
		addObject("accountNameTb", By.id("acc2"));
		addObject("typeDropdown", By.xpath("//select[@id='acc6']"));
		addObject("customerPrioriyDrodown", By.id("00N5g00000ffIOQ"));
		addObject("saveBtn", By.name("save"));
		// ************************
		addObject("newViewLink", By.xpath("//a[text()='Create New View']"));
		addObject("viewNameTb", By.id("fname"));
		addObject("viewUniqueNameTb", By.id("devname"));
		addObject("saveViewName", By.name("save"));
		// *******************************
		addObject("viewNameDropdown", By.xpath("//span/select[@id='fcf']"));
		addObject("editLink", By.xpath("//a[text()='Edit']"));
		addObject("editNewView", By.id("fname"));
		addObject("filterFileDropdown", By.id("fcol1"));
		addObject("operatorDropdown", By.id("fop1"));
		addObject("filterValue", By.id("fval1"));
		addObject("addBtn", By.xpath("//a[@id='colselector_select_0_right']"));
		addObject("editViewSaveBtn", By.name("save"));
		addObject("viewName", By.id("fcf"));

		// ************* Tc-13 ***************
		addObject("mergeAccount", By.xpath("//a[contains(text(),'Merge Accounts')]"));
		addObject("findAccountTb", By.id("srch"));
		addObject("findAccounBtn", By.xpath("//input[@value='Find Accounts']"));
		addObject("account1", By.xpath("//input[@id='cid0']"));
		addObject("account2", By.xpath("//input[@id='cid1']"));
		addObject("nextBtnInPage1", By.xpath("(//input[@value=' Next '])[2]"));
		addObject("mergeBtnInPage2",
				By.xpath("//form/div[1]/div/div/div[@class='pbTopButtons']/input[@value=' Merge ']"));

		// ******************* TC-14 ******************
		addObject("accountActivityLink", By.linkText("Accounts with last activity > 30 days"));
		addObject("dateFieldDropdown", By.xpath("//img[@id='ext-gen148']"));
		addObject("createdDate", By.xpath("//div[@class='x-combo-list-item x-combo-selected']"));
		addObject("fromCalender", By.xpath("//img[@id='ext-gen152']"));
		addObject("fromDate", By.xpath("//td[@title='Today']//span[contains(text(),'10')]"));
		addObject("toCalender", By.xpath("//img[@id='ext-gen154']"));
		addObject("toDate", By.xpath("//td[@class='x-date-active x-date-selected']//span[contains(text(),'10')]"));
		addObject("saveBtnInDateField", By.xpath("//button[@id='ext-gen49']"));
	}

}
