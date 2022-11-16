@All @AssetApiTest
Feature: API test

  Scenario: GET all assets for network algo
    Given GET all the asset for network "algo"
    Then the API should return status 200
    Then validate the response body

  Scenario: GET all assets for network eth
    Given GET all the asset for network "eth"
    Then the API should return status 200
    Then validate the response body

  Scenario: Delete all assets for network algo
    Given DELETE all the asset for network "algo"
    Then the API should return status 200
    Then validate the response body for deleted assets

  Scenario: Delete all assets for network eth
    Given DELETE all the asset for network "eth"
    Then the API should return status 200
    Then validate the response body for deleted assets

  Scenario:  GET assets By ID for network algo
    Given GET  the asset for id 701620050 network "algo"
    Then the API should return status 200
    Then validate the response body

  Scenario: GET assets By ID for network eth
    Given GET  the asset for id 701620050 network "eth"
    Then the API should return status 200
    Then validate the response body

  Scenario: Delete asset by id for network algo
    Given DELETE the asset by id for network "algo"
    Then the API should return status 200
    Then validate the response body for deleted asset

  Scenario: Delete asset by id for network eth
    Given DELETE the asset by id for network "eth"
    Then the API should return status 200
    Then validate the response body for deleted asset

  Scenario: Update tag for asset by id for network algo
    Given UDPATE the assetby id with tag for network "algo"
    Then the API should return status 200
    Then validate the response body after updating tag for asset

  Scenario: Update tag for asset by id for network eth
    Given UDPATE the assetby id with tag for network "eth"
    Then the API should return status 200
    Then validate the response body after updating tag for asset
