@UpdatePlaceAPI
Feature: Update Place API

  @UpdatePlaceAPI
  Scenario: Update a place via recently added from Add Place API
    Given "Add Place" Payload
    When user calls "AddPlaceAPI" with "POST" http request
    Then API call got success with status code 200
    And user validates the "status" value "OK" from the repsonse body
    And user validates the "scope" value "APP" from the repsonse body
    And user fetches the generated place id from the add place api response
    Given "Update Place" Payload
    When user calls "UpdatePlaceAPI" with "Put" http request
    Then API call got success with status code 200
    And user validates the "msg" value "Address successfully updated" from the repsonse body
    Given "Get Place" Payload
    When user calls "GetPlaceAPI" with "Get" http request
    Then API call got success with status code 200
    And user matches the get place response with updated details
