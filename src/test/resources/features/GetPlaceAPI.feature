@GetPlaceAPI
Feature: Get Place API

  @GetPlaceAPI
  Scenario: Get a place via recently added from Add Place API
    Given "Get Place" Payload
    When user calls "GetPlaceAPI" with "Get" http request
    Then API call got success with status code 200
    And user matches the get place response with add place payload
