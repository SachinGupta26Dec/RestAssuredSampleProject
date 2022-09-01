package stepdef;

import io.cucumber.java.en.Then;
import pojos.GetPlaceResponse;
import pojos.AddPlacePayload;
import utilities.Context;

public class UpdatePlaceStepDef {

	public Context context;

	public UpdatePlaceStepDef(Context context) {
		this.context = context;
	}

	@Then("user matches the get place response with updated details")
	public void user_matches_the_get_place_response_with_updated_details() {

		GetPlaceResponse actual = context.getResponse().as(GetPlaceResponse.class);
		AddPlacePayload expected = context.getAddPlacePayload();
		
		System.out.println("actual : " + actual);
		System.out.println("expected : " + expected);

		
	}

}
