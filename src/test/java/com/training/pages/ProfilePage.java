package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class ProfilePage extends BasePage{

	public ProfilePage(WebDriver driver) {
		super(driver);
		addObject("myProfileUnderUsermenu", By.xpath("//a[@title='My Profile']"));
		addObject("editProfileIcon", By.xpath("(//img[@title='Edit Profile'])[1]"));
		addObject("contactInfoFrame", By.xpath("//iframe[@id='contactInfoContentId']"));
		addObject("aboutTab", By.xpath("//li[@id='aboutTab']"));
		addObject("lastNameTab", By.xpath("//input[@id='lastName']"));
		addObject("saveAllBtn", By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		addObject("postLink", By.xpath("//span[text()='Post']"));
		addObject("iFrameOfpostLink", By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		addObject("postLinkBody", By.xpath("//body[contains(text(),'Share an update, @mention someone...')]"));
		addObject("shareBtn", By.name("publishersharebutton"));
		//***********************************
		addObject("fileLink", By.xpath("//li/a[@id='publisherAttachContentPost']/span[1]"));
		addObject("uploadfileLink", By.id("chatterUploadFileAction"));
		addObject("chooseBtnToBrowse", By.id("chatterFile"));
		addObject("shareBtnInfileUpload", By.id("publishersharebutton"));
		//***************** tc-6d ****************
		addObject("profilePhotoImage", By.xpath("(//img[@class='chatter-photo'])[1]"));
		addObject("photoUploadLink", By.id("uploadLink"));
		addObject("frameInPhotoUpload", By.xpath("//iframe[@id='uploadPhotoContentId']"));
		addObject("chooseFile", By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
		addObject("saveBtnInPhotoUpload", By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
		addObject("cropPhoto", By.xpath("//div[@class='imgCrop_dragArea']/div[5]/div[9]"));
		addObject("cropSaveBtn", By.xpath("//input[@id='j_id0:j_id7:save']"));
	}

}
