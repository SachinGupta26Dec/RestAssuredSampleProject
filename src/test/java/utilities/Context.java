package utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import pojos.AddPlacePayload;

@Getter
@Setter
public class Context {

	private RequestSpecification requestSpecification;
	private Response response;
	private String place_id;
	private AddPlacePayload addPlacePayload;
	private String logFileName;


}
