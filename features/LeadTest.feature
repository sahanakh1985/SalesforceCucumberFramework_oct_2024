Feature: Lead module testcases

Background:
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "invalidPassword" "Ammu@1015"
Then User click on button "loginBtn"

@TC-20
Scenario: Check lead tab
Given User is on "LeadPage"
When User click on button "leadTab"


@TC-21
Scenario: Validate lead dropdown
Given User is on "LeadPage"
When User mouseover and click on button "leadTab"
Then User mouseover and click on button "leadDropdownElements"
#Then User validate the element list "acualLeadDropdownElements" " "

@TC-22
Scenario: Select Recently viewed lead under leadViewDropdown
Given User is on "LeadPage"
When User mouseover and click on button "leadTab"
Given User mouseover and click on button "leadViewDropdown"
Given User selects "Recently Viewed Leads" by visible text from the dropdown "leadViewDropdown"
Given User is on "HomePage"
When User click on button "logoutBtn"
Given User is on "LoginPage"
Then User click on button "loginBtn"
Then User is on "LeadPage"
Then validate the text "leadViewDropdown " "Recently Viewed Leads"

@TC-23
Scenario: Select Today lead under viewLeadDropdown
Given User is on "LeadPage"
When User mouseover and click on button "leadTab"
Given User selects  by index 3 of dropdown "leadViewDropdown"
Then User get text from selected dropdown "leadViewDropdown"


@TC-24
Scenario: Check new button in leadPage
Given User is on "LeadPage"
When User mouseover and click on button "leadTab"
When User mouseover and click on button "newBtn"
And User waits for 5 seconds 
When User wait and enter into textbox "lastNameTb" "ABCD"
When User wait and enter into textbox "companyNameTb" "ABCD"
And User click on button "topSaveBtn"



