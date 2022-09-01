package utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum API_EndPoints {

	AddPlaceAPI("maps/api/place/add/json"), DeletePlaceAPI("maps/api/place/delete/json"),
	GetPlaceAPI("maps/api/place/get/json"), UpdatePlaceAPI("maps/api/place/update/json");

	@Getter
	private String endPoint;

}
