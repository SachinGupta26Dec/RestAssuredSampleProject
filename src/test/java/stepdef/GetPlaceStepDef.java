package stepdef;

import io.cucumber.java.en.Then;
import pojos.GetPlaceResponse;
import pojos.AddPlacePayload;
import utilities.Context;

public class GetPlaceStepDef {

	public Context context;

	public GetPlaceStepDef(Context context) {
		this.context = context;
	}

	@Then("user matches the get place response with add place payload")
	public void user_matches_the_get_place_response_with_add_place_payload() {

		GetPlaceResponse actual = context.getResponse().as(GetPlaceResponse.class);
		AddPlacePayload expected = context.getAddPlacePayload();

		System.out.println("actual : " + actual);
		System.out.println("expected : " + expected);

		
	}

}
