Feature:
  Background:
    Given User navigates to "https://www.a101.com.tr/"
    And User accepts cookies
    Then Verify that user should be able to land on home page

  @TC001
  Scenario:
    Given User hovers mouse over <giyim ve aksesuar> module
    When User clicks <Dizaltı Çorap> category from opened submenu
    And User clicks first product
    Then Verify that color is black of the product


