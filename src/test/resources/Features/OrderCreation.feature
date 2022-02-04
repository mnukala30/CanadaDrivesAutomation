@Order-Creation
Feature: Purchase a car through Canada Drives Website

  Background: 
    Given Open the browser and Launch the application

  Scenario Outline: Pick available RAM vehicle in desired province
    When User fills the form from given "<sheetName>" and <RowNum>
    When User fills the address and warranty Months from given "<sheetName>" and <RowNum>

    Examples: 
      | sheetName   | RowNum |
      | RAMVehicles |         0 |
  #    | RAMVehicles |         1 |
