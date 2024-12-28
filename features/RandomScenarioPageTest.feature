Feature: Random scenarios testcases

Background:
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "invalidPassword" "Ammu@1015"
Then User click on button "loginBtn"

@TC-33
Scenario: Check save and new button in contact view link
Given User is on "HomePage"
And User waits for 2 seconds
Given User is on "RandomScenarioPage"
When User mouseover and click on button "firstNameLastnameLink"
Given User is on "HomePage"
When User mouseover and click on button "usermenudropdown"
Then User click on button "logoutBtn" by JS
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "invalidPassword" "Ammu@1015"
Then User click on button "loginBtn"
Given User is on "HomePage"
When User click on button "usermenudropdown"
Given User is on "ProfilePage"
And User click on button "myProfileUnderUsermenu"

@TC-34
Scenario: verify edited lastname in various places
Given User is on "HomePage"
And User mouseover and click on button "usermenudropdown"
Given User is on "ProfilePage"
When User click on button "myProfileUnderUsermenu"
When User click on button "editProfileIcon"
When User switch to frame "contactInfoFrame"
When User click on button "aboutTab"
When User enter into textbox "lastNameTab" "Gowda"
Then User click on button "saveAllBtn"
And User switch to new window and close that window

@TC-35
Scenario: verify the tab customization
Given User is on "RandomScenarioPage"
Then User gets the list of elements on "tabBarMenu1"
Then User click on button "allTabs"
Then User click on button "customiseTab"
Given User selects "Reports" by visible text from the dropdown "availableTabDropdown"
And User click on button "removeBtn"
And User click on button "saveBtn"
Then User gets the list of elements "tabBarMenu2"

@TC-36
Scenario: Blocking an event in the calender
Given User is on "HomePage"
When User mouseover and click on button "homeTab"
Given User is on "RandomScenarioPage"
Given User mouseover and click on button "dateLink"
Given User mouseover and click on button "link_8pm" 
Then User wait and enter into textbox "subjectTab" "other"
And User click on button "endDate"
And User click on button "endTime"
And User click on button "saveBtnInCalender"

@TC-37
Scenario:Blocking an event in the calender with weekly recurrance
Given User is on "HomePage"
When User click on button "homeTab"
Given User is on "RandomScenarioPage"
Given User click on button "dateLink"
Given User click on button "link_8pm"
Then User enter into textbox "subjectTab" "other"
And User click on button "endDate"
And User click on button "endTime"
When User click on button "endDateDropdown"
When User click on button "recurrence"
When User click on button "weeklyRadioBtn"
When User click on button "recurrenceEndDate"
Given User handles the calender popup
When User click on button "expectedDate"
When User click on button "saveBtnInCalender2"
When User click on button "monthView"
When User click on button "nextMonth"


