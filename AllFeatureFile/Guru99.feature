Feature: Test the Guru99 Application

  Scenario: Validate the Register Page Functionality
    Given user is on Register Page
    When user enter firstname,lastname,phone and email
    And user enter address,city,state,postal code and select country
    And user enter username,password,confirm password and click on submit button
    Then us and er is on Register success page and validate success page url

  Scenario: Validate Login Page Functionality
    When user click on sign in link
    And user enter username,password and click on submit button
    Then user is on Login Successfully page and validate url
    And user validate successfully keword in login success page
