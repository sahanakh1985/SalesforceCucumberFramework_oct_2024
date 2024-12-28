Feature:Login to Salesforce application

@TC-1
Scenario: Login with invalid credentials
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "invalidPassword" "Ammu@1234"
Then User click on button "loginBtn"

@TC-2
Scenario: Login with valid credentials
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "validPassword" "Ammu@1015"
Then User click on button "loginBtn"
Given User is on "HomePage"

@TC-3
Scenario: Login with valid credentials and click on rememberme checkbox
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "validPassword" "Ammu@1015"
And User click on button "remembermeChecbox"
Then User click on button "loginBtn"
Given User is on "HomePage"
When User click on button "usermenudropdown"
And User click on button "logoutBtn"

@TC-4
Scenario: Login with valid credentials and click on rememberme checkbox
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User click on button "forgotPassword"
When User wait and enter into textbox "unTbInForgotPasswordPage" "sahana@tek.com"

@TC-5
Scenario: Verify the error message
Given User launch the application
Given User is on "LoginPage"
When User wait and enter into textbox "username" "sahana@tek.com"
When User enter into textbox "invalidPassword" "Ammu@1234"
Then User click on button "loginBtn"
Then User verify the text "errMsg" "Please check your username and password. If you still can't log in, contact your Salesforce administrator."

