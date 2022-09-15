Feature:

  Background:
    Given User navigates to "https://www.a101.com.tr/"
    And User accepts cookies
    Then Verify that user lands on home page successfully

  @TC002
  Scenario:
    Given User hovers mouse over <giyim ve aksesuar> module
    When User clicks <Dizaltı Çorap> category from opened submenu
    And User clicks first product
    And User clicks <Sepete Ekle> button
    When User clicks <Sepeti Görüntüle> button
    Then Verify that user can see the product in the basket

