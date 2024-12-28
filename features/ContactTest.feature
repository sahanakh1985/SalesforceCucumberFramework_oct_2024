Feature: Contact module testcases


Background:
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "invalidPassword" "Ammu@1015"
Then User click on button "loginBtn"

@TC-25
Scenario: Create new contact
Given User is on "ContactPage"
Given User click on button "contactTab"
When User click on button "newBtnInContact"
When User enter into textbox "lastNameTb" "raj"
When User enter into textbox "accountNameTb" "Ammu8"
And User click on button "saveBtn"
And User switch to new window and close that window

@TC-26
Scenario: Create new view name
Given User is on "ContactPage"
Given User click on button "contactTab"
When User click on button "newViewLinkInContact"
When User enter into textbox "viewNameTb" "qwer"
And User click on button "saveBtnCreateView"

@TC-27
Scenario: Check recently created contact list
Given User is on "ContactPage"
Given User click on button "contactTab"
Given User selects "Recently Created" by visible text from the dropdown "recentlyCreatedContactList"

@TC-28
Scenario: Check myContacts view in ContactPage
Given User is on "ContactPage"
Given User click on button "contactTab"
Given User selects "My Contacts" by visible text from the dropdown "myContactDropdown"

@TC-29
Scenario: Click on contact name under recent contact list
Given User is on "ContactPage"
Given User click on button "contactTab"
Then User click on button "contactNameUnderRecentContact"

@TC-30
Scenario: Validate ErrorMsg while creating new view in ContactPage
Given User is on "ContactPage"
Given User mouseover and click on button "contactTab"
Given User click on button "createNewViewLink"
Given User enter into textbox "viewUniqueNameTb" "qwer"
And User click on button "saveBtnInNewView"
Then User verify the text "errMsg" "Error: You must enter a value"


@TC-31
Scenario: Check cancel button in contact view link
Given User is on "ContactPage"
Given User mouseover and click on button "contactTab"
Given User click on button "createNewViewLink"
Given User enter into textbox "viewNameTb" "qwer"
And User click on button "cancelBtn"

@TC-32
Scenario: Check save and new button in contact new view link
Given User is on "ContactPage"
Given User mouseover and click on button "contactTab"
Given User mouseover and click on button "newBtnInContact"
When User wait and enter into textbox "lastNameTb" "raj"
When User wait and enter into textbox "accountNameTb" "Ammu8"
And User click on button "saveAndNewButton"
Then User verify the text "errorMsgAfterClickingSaveAndButton" "Error: Invalid Data.\r\n" + "Review all error messages below to correct your data."


