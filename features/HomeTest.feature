Feature:Perform functions related usermenu dropdown in homepage

Background:
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "invalidPassword" "Ammu@1015"
Then User click on button "loginBtn"


@TC-5
Scenario: Validate usermenu dropdown
Given User is on "HomePage"
When User click on button "usermenudropdown"
#Then User verify the text "actualUserMenuElementList"  " "

@TC-6
Scenario: Select myProfile under usermenu dropdown
Given User is on "HomePage"
When User click on button "usermenudropdown"
Given User is on "ProfilePage"
Then User click on button "myProfileUnderUsermenu"
Then User click on button "editProfileIcon"
When User switch to frame "contactInfoFrame"
When User click on button "aboutTab"
When User enter into textbox "lastNameTab" "Gowda"
Then User click on button "saveAllBtn"
And User switch to new window and close that window

@TC-7a
Scenario: click on login history under mySettings
Given User is on "HomePage"
When User click on button "usermenudropdown"
Given User is on "MySettingsPage"
When User click on button "mySettings"
When User click on button "personalLink"
When User click on button "loginHistory"
When User click on button "downloadLink"

@TC-7b
Scenario: Click on display and settings
Given User is on "HomePage"
And User waits for 2 seconds
When User click on button "usermenudropdown"
Given User is on "MySettingsPage"
When User click on button "mySettings"
When User click on button "displayAndLayoutLink"
When User click on button "customiseMyTab"
Given User selects "Reports" by visible text from the dropdown "availableTabDropdown"
And User click on button "addBtn"
And User click on button "saveBtnInDisplayAndLayout"

@TC-7c
Scenario: Click on display and settings
Given User is on "HomePage"
And User waits for 2 seconds
When User click on button "usermenudropdown"
Given User is on "MySettingsPage"
When User click on button "mySettings"
When User click on button "emailSettings"
When User click on button "myEmailSettings"
When User enter into textbox "emailNameTab" "Sahana.K.H"
When User enter into textbox "emailAddressTab" "sahanakh1985@gmail.com"
Then User click on button "bbcRadioBtn"
Then User click on button "saveBtnInEmailSettings"

@TC-7d
Scenario: Click on display and settings
Given User is on "HomePage"
And User waits for 2 seconds
When User click on button "usermenudropdown"
Given User is on "MySettingsPage"
When User click on button "mySettings"
When User click on button "calenderAndRemindersLink"
When User click on button "acivityRemindersLink"
When User click on button "openTestBtn"
When User click on button "cancelBtn"
And User switch to new window and close that window

@TC-8
Scenario: close developer console
Given User is on "HomePage"
And User waits for 2 seconds
When User click on button "usermenudropdown"
Given User is on "DeveloperConsolePage"
Then User close all the windows except parentWindow
When User click on button "developerConsole"
And User switch to new window and close that window

@TC-9
Scenario: Click on logout button
Given User is on "HomePage"
And User waits for 2 seconds
When User click on button "usermenudropdown"
Given User is on "HomePage"
And User click on button "logoutBtn"
Then User verify the url "https://tekarch95-dev-ed.develop.my.salesforce.com/secur/logout.jsp" of page "LoginPage"












