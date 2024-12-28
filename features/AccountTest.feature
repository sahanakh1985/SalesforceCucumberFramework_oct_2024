Feature: Account module testcases

Background:
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "invalidPassword" "Ammu@1015"
Then User click on button "loginBtn"

@TC-10
Scenario: Create an account
Given User is on "HomePage"
And User waits for 2 seconds
Given User is on "AccountPage"
When User click on button "accountTab"
When User click on button "newBtn"
When User enter into textbox "accountNameTb" "Ammu7"
Given User selects "Technology Partner" by visible text from the dropdown "typeDropdown"
Given User selects "High" by visible text from the dropdown "customerPrioriyDrodown"
And User click on button "saveBtn"

@TC-11
Scenario: Create new view in contactPage
Given User is on "HomePage"
And User waits for 2 seconds
Given User is on "AccountPage"
When User click on button "accountTab"
When User click on button "newViewLink"
When User enter into textbox "viewNameTb" "ABCD"
When User enter into textbox "viewUniqueNameTb" " "
And User click on button "saveViewName"

@TC-12
Scenario: Edit view in AccountPage
Given User is on "HomePage"
And User waits for 2 seconds
Given User is on "AccountPage"
When User click on button "accountTab"
Given User selects "QWER" by visible text from the dropdown "viewNameDropdown"
When User click on button "editLink"
When User enter into textbox "editNewView" "QWER"
Given User selects "Account Name" by visible text from the dropdown "filterFileDropdown"
Given User selects "contains" by visible text from the dropdown "operatorDropdown"
When User enter into textbox "filterValue" "a"
And User click on button "addBtn"
And User click on button "editViewSaveBtn"
And User switch to new window and close that window

@TC-13
Scenario: Merge Account in AccountPage
Given User is on "HomePage"
And User waits for 2 seconds
Given User is on "AccountPage"
When User click on button "accountTab"
When User click on button "mergeAccount"
When User enter into textbox "findAccountTb" "Ammu"
When User click on button "findAccounBtn"
When User click on button "account1"
When User click on button "account2"
When User click on button "nextBtnInPage1"
When User click on button "mergeBtnInPage2"
Then User click on ok button of alert popup
And User switch to new window and close that window


@TC-14
Scenario: Create account report in AccountPage
Given User is on "HomePage"
And User waits for 2 seconds
Given User is on "AccountPage"
When User click on button "accountTab"
When User mouseover and click on button "accountActivityLink"
When User mouseover and click on button "dateFieldDropdown"
When User mouseover and click on button "createdDate"
When User mouseover and click on button "fromCalender"
When User mouseover and click on button "fromDate"
When User mouseover and click on button "toCalender"
When User mouseover and click on button "toDate"
Then User mouseover and click on button "saveBtnInDateField"
And User switch to new window and close that window





