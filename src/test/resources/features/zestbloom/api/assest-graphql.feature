Feature: Asset Graphql test

  Scenario: Query all assets for network algo
    Given Query and verify all the asset for network "ALGO"

  Scenario: Issue-2 : Need ION API Test Case for GetAssets Query Pagination
    Given Query and validate pagination for all assets list as per following data
      | offset  | limit | orderBy    | pagination |
      | 0       | 10    | updated_at | 10         |
      | 12      | 12    | updated_at | 12         |
      | 24      | 24    | updated_at | 24         |

  Scenario: Query all assets for network eth
    Given Query and verify all the asset for network "ETH "

  Scenario: Query all assets by selecting first 7 fields
    Given Query and verify all the asset with criteria firstAssetId and hasMedia and hasMedia and isDestroyed and limit and network and offset and orderBy and resultCount
    |firstAssetId|hasMedia|isDestroyed|limit|network|offset|orderBy|resultCount|
    | 10         |false    |false     |1    |ALGO   | 1    |id|1               |

#  Scenario: Query all assets by selecting asset metadata
#    Given Query and verify all the asset with following data
#      |assetId|assetInfo|animationMime|animationOriginalUrl|animationThumbNailUrls|cid|externalLink|id|imageMime|imageOriginalUrl|imageThumbnailUrl|assetMetadata|

#  Scenario: Query all assets by selecting Collections asset metadata
#    Given Query and verify all the asset with following data with criteria createdAt and creator and description and id and isOfficial and name
#      |createdAt|creator|description|id|isOfficial|name|resultCount|


  Scenario: Query all assets by selecting stringTraitSummary metadata
    Given Query and verify all the asset with following data for StringTraitSummary with search criteria name and values
        |name|values|resultCount|
        |empty|empty|2          |


  Scenario: Query all assets by selecting another 7 fields
    Given Query and verify all the asset with following data with criteria createdAt and description and id and isDestroyed and isNfsfw and name and network and updatedAt
      |createdAt|description|id|isDestroyed|isNsfw|name|network|updatedAt|resultCount|
      |  empty   |  empty     |emmpty|empty |empty |empty |empty  |empty   |10|


  Scenario: Query asset by id for network ALGO with invalid asset id
    Given Query asset by invalid id for network "algo" and verify the error message

  Scenario: Query asset by id for network ALGO with assestInfo
    Given Query asset by id for network "algo" and verify assetInfoData

  Scenario: Query asset by id for network ALGO with assestInfo, assetMetData, name and network
    Given Query asset by id for network "algo" and verify assetInfoData and assetMetaData and name and network

  Scenario: Query assets by id for network ALGO with assestInfo, assetMetData, name and network
    Given Query assets by id for network "algo" and verify assetInfoData and assetMetaData and name and network

  Scenario: Query tags with id
    Given Query tags with id

  Scenario: Query tags with name
    Given Query tags with name

  Scenario: Query tags by limit
    Given Query tags with limit

  Scenario: Query tag with id
    Given Query tag with id

  Scenario: Query tag with name
    Given Query tag with name


