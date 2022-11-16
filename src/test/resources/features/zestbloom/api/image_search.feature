@All @AssetApiTest
Feature: image search tests

  Scenario: Search for Image with valid id
    When search image by valid id

  Scenario: Search for Image with invalid id
    When search image by invalid id

  Scenario: Get Asset for image search
    Given user is able to search asset by id

  Scenario: Search By Text for image search
    Given user is able to search image by text

  Scenario: Get Asset - negative scenario
    Given user is able to search asset by  invalid id

  Scenario: Search By Text - negative scenario
    Given user is able to search image by invalid text

  Scenario: Search by Text - with negative offset value
    Given user is able to search image with negative offset value

  Scenario: Search by Text - with special characters offset value
    Given user is able to search image with special characters offset value

  Scenario: Search by Text - without showNsfw value
    Given user is able to search image without showNsfw value

  Scenario: Search by Text - with special chars in  showNsfw
    Given user is able to search image with special chars in  showNsfw

  Scenario: Search by Text - with invalid text
    Given user is able to search with invalid text

  Scenario: Search by Text - with javascript code in text
    Given user is able to search with javascript code in text

  Scenario: Search by Text - with invalid network
    Given user is able to search with invalid network

  Scenario: Search by Image - with negative offset value
    Given user is able to search by image with negative offset value

  Scenario: Search by Image - with special characters offset value
    Given user is able to search by image with special characters offset value

  Scenario: Search by Image - with negative offset value
    Given user is able to search by image with negative offset value
