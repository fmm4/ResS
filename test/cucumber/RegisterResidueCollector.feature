Feature: register a residue collector
  As an administrator
  I want to register residue collector
  So that I can store collectors information and manipulate it


  Scenario: new collector
    Given the system has no collector with CNPJ "01.752.271/0001-66"
    When I create a new collector with CNPJ "01.752.271/0001-66"
    Then a collector with CNPJ "01.752.271/0001-66" is stored in the system

  Scenario: duplicated collector
    Given a collector with CNPJ "01.752.271/0001-66" exists in the system
    When I create a new collector with CNPJ "01.752.271/0001-66"
    Then only one collector with CNPJ "01.752.271/0001-66" is stored in the system

  Scenario: collector with incorrect information
    Given the system has no collector with CNPJ "cnpj_invalido"
    When I create a new collector with CNPJ "cnpj_invalido"
    Then no collector with CNPJ "cnpj_invalido" is stored in the system

  Scenario: entering on the collector creation page
    Given I am at the collector list page
    When I click on the new collector button
    Then I am at the collector creation page

  Scenario: creating a collector through UI
    Given I am at the collector creation page
    When I insert all informations correctly
    And I click on the create button
    Then a new collector is created