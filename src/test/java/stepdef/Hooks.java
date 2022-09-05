package stepdef;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseUtil;
import utilities.Context;

public class Hooks {

	public Context context;
	public GenericStepDef genericStepDef;
	public AddPlaceStepDef addPlaceStepDef;

	public Hooks(Context context,GenericStepDef genericStepDef,AddPlaceStepDef addPlaceStepDef) {
		this.context = context;
		this.genericStepDef=genericStepDef;
		this.addPlaceStepDef=addPlaceStepDef;
	}

	@Before(order = 10)
	public void setUp(Scenario scenario) {

		if (scenario.getSourceTagNames().contains("@GetPlaceAPI"))
			context.setLogFileName("GetPlaceAPI.txt");
		else if (scenario.getSourceTagNames().contains("@AddPlaceAPI"))
			context.setLogFileName("AddPlaceAPI.txt");
		else if (scenario.getSourceTagNames().contains("@UpdatePlaceAPI"))
			context.setLogFileName("UpdatePlaceAPI.txt");
		else if (scenario.getSourceTagNames().contains("@DeletePlaceAPI"))
			context.setLogFileName("DeletePlaceAPI.txt");
	}	

	@After
	public void tearDown(Scenario scenario) throws IOException {

		FileInputStream fis = new FileInputStream(context.getLogFileName());
		byte[] log = fis.readAllBytes();
		scenario.log(new String(log));
	}
	
	@Before(order = 100, value = "@GetPlaceAPI")
	public void setUp2() throws JsonIOException, JsonSyntaxException, Throwable {
		genericStepDef.payload("Add Place");
		genericStepDef.user_calls_with_http_request("AddPlaceAPI", "post");
		genericStepDef.api_call_got_success_with_status_code(200);
		addPlaceStepDef.user_fetches_the_generated_place_id_from_the_add_place_api_response();
	}
}
