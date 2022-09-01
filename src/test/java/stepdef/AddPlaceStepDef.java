package stepdef;

import io.cucumber.java.en.Then;
import pojos.AddPlaceResponse;
import utilities.Context;

public class AddPlaceStepDef {

	public Context context;

	public AddPlaceStepDef(Context context) {
		this.context = context;
	}

	@Then("user fetches the generated place id from the add place api response")
	public void user_fetches_the_generated_place_id_from_the_add_place_api_response() {

		AddPlaceResponse ar = context.getResponse().as(AddPlaceResponse.class);
		String placeID = ar.getPlace_id();
		System.out.println(ar.getPlace_id());
		context.setPlace_id(placeID);
	}

}
