Feature: Superuser role tests

  Scenario: Verify that SuperUser can get all the blacklist
    Given Super user GET all the blacklist
    Then Validate the response

  Scenario: Verify that SuperUser can add to the blacklist
    Given Super user ADD to the blacklist
    Then Validate the response after adding to the blacklist

  Scenario: Verify that SuperUser can delete from  the blacklist
    Given Super user DELETE from the blacklist
    Then Validate the response