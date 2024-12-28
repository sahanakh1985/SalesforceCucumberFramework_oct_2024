package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class DeveloperConsolePage extends BasePage{

	public DeveloperConsolePage(WebDriver driver) {
		super(driver);
		addObject("developerConsole", By.xpath("//a[@title='Developer Console (New Window)']"));
	}

}
