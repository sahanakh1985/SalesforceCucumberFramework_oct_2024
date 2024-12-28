Feature: Opportunity module testcases

Background:
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "invalidPassword" "Ammu@1015"
Then User click on button "loginBtn"

@TC-15
Scenario: Opportunity dropdown
Given User is on "OpportunityPage"
When User click on button "opportunityTab"
When User click on button "opportunityDropdown"

@TC-16
Scenario:  Create new Opportunity 
Given User is on "OpportunityPage"
When User click on button "opportunityTab"
When User click on button "newBtn"
When User enter into textbox "opportunityName" "opp_6"
When User enter into textbox "accountName" "Ammu4"
When User enter into textbox "closeDate" "29-12-24"
Given User selects "Prospecting" by visible text from the dropdown "stageElement"
When User enter into textbox "probabilityPercentage" "90"
Given User selects "Web" by visible text from the dropdown "leadSource"
When User enter into textbox "primaryCampaign" "Aana"
And User click on button "saveBtnInCreateOpp"


@TC-17
Scenario:  Create Opportunity pipeline report
Given User is on "OpportunityPage"
When User mouseover and click on button "opportunityTab"
When User mouseover and click on button "pipeLineLink"
#And User validate the title of "PipelineLinkPage" with "Opportunity Pipeline ~ Salesforce - Developer Edition "

@TC-18
Scenario:  Create Opportunity stuck report
Given User is on "OpportunityPage"
When User mouseover and click on button "opportunityTab"
When User mouseover and click on button "stuckOppLink"
#And User validate the title of "PipelineLinkPage" with "Stuck Opportunities ~ Salesforce - Developer Edition "


@TC-19
Scenario:  Create Opportunity quaterly summary report
Given User is on "OpportunityPage"
When User mouseover and click on button "opportunityTab"
Given User click on button "intrvalTb"
Given User selects "Current and Next FQ" by visible text from the dropdown "intervalDropdown"
Given User selects "closed" by visible text from the dropdown "includeDropdown"
And User click on button "runBtn"
