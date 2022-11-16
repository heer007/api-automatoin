@All @TagsApiTest
Feature: Tags API test

  Scenario: API add new tag
    Given POST a request to add new tag
    Then the API should return status 201
    Then validate that new tag is created


  Scenario: API get list of tags
    Given GET a request to list all the tags within offset 1 to limit 10
    Then the API should return status 200
    Then validate that new tag is created

  Scenario: API get tag with id and list of associated assets
    Given GET a request for a tag with id 3 associated with "asset"
    Then the API should return status 200
    Then validate that new tag is created

  Scenario: API get tag with id and list of associated collections
    Given GET a request for a tag with id 3 associated with "collections"
    Then the API should return status 200
    Then validate that new tag is created

  Scenario: API update tag with id
    Given PUT a request to update tag with id 3
    Then the API should return status 200
    Then validate that new tag is created