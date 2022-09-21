Feature:

  Background:
    Given User navigates to "https://www.a101.com.tr/"
    And User accepts cookies
    Then Verify that user lands on home page successfully
  @TC003
  Scenario:
    Given User hovers mouse over <giyim ve aksesuar> module
    When User clicks <Dizaltı Çorap> category from opened submenu
    And User clicks first product
    And User clicks <Sepete Ekle> button
    When User clicks <Sepeti Görüntüle> button
    And User clicks <Sepeti Onayla> button
    And User clicks <ÜYE OLMADAN DEVAM ET> button
    And User enters email address and clicks enter key
    When User clicks <Yeni adres oluştur> link
    And User enters required information
    And User clicks <Kaydet> button
    And User selects any radio button
    And User clicks <Kaydet ve Devam Et> button
    And User enters payment information and selects checkbox
    And User clicks <Siparişi Tamamla> button
    Then Verify that user has been navigated to bank of page

















