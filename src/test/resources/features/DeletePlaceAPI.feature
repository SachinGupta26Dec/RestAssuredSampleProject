@DeletePlaceAPI
Feature: Delete Place API

  @DeletePlaceAPI
  Scenario: Delete a place via recently added from Add Place API
    Given "Add Place" Payload
    When user calls "AddPlaceAPI" with "POST" http request
    Then API call got success with status code 200
    And user validates the "status" value "OK" from the repsonse body
    And user validates the "scope" value "APP" from the repsonse body
    And user fetches the generated place id from the add place api response
    Given "Delete Place" Payload
    When user calls "DeletePlaceAPI" with "Delete" http request
    Then API call got success with status code 200
    And user validates the "status" value "OK" from the repsonse body
    