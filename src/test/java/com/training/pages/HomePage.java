package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

		addObject("homeTab", By.xpath("//li/a[contains(text(),'Home')]"));
		addObject("usermenudropdown", By.xpath("//div[@id='userNavButton']"));
		addObject("logoutBtn", By.xpath("//a[@title='Logout']"));
		addObject("actualUserMenuElementList", By.cssSelector("div#userNav-menuItems a"));
	}

}
