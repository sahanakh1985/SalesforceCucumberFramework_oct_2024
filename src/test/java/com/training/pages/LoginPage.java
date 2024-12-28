package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

		addObject("username", By.id("username"));
		addObject("validPassword", By.id("password"));
		addObject("invalidPassword", By.id("password"));
		addObject("loginBtn", By.id("Login"));
		addObject("remembermeChecbox", By.xpath("//input[@id='rememberUn']"));
		addObject("errMsg", By.xpath("//div[@id='error']"));
		addObject("forgotPassword", By.id("forgot_password_link"));
		addObject("unTbInForgotPasswordPage", By.xpath("//input[@id='un']"));
		addObject("continueInForgotPasswordPage", By.id("continue"));

	}

}
