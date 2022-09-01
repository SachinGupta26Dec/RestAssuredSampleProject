package stepdef;

import java.io.FileInputStream;
import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Context;

public class Hooks {

	public Context context;

	public Hooks(Context context) {
		this.context = context;
	}

	@Before
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
}
