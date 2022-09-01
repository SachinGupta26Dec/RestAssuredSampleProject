@AddPlaceAPI
Feature: Add Place API
  @AddPlaceAPI
  Scenario: Add a new place via Add place API
    Given "Add Place" Payload
    When user calls "AddPlaceAPI" with "POST" http request
    Then API call got success with status code 200
    And user validates the "status" value "OK" from the repsonse body
    And user validates the "scope" value "APP" from the repsonse body
    And user fetches the generated place id from the add place api response
    
    
 