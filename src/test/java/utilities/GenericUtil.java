package utilities;

import java.io.FileNotFoundException;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import pojos.AddPlacePayload;

public class GenericUtil {

	public Context context;

	public GenericUtil(Context context) {
		this.context = context;
	}

	public String fetchValueBasedOnKey(String key)
			throws JsonIOException, JsonSyntaxException, FileNotFoundException, Throwable {
		String environment = System.getProperty("environment", "Prod");
		String value = DataManager.fetchObjectObject(DataManager.getEnvironmentDetailsJSONURL(), environment, key);
		return value;
	}

	public AddPlacePayload addPlacePayload() {
		return new AddPlacePayload(new AddPlacePayload().new Location(-50, 10), 50, "Sachin House", "9891135337",
				"276 Satya Niketan 3rd Floor", new String[] { "tie", "buckle" }, "https://sachin.com", "English");
	}

	public String deletePlacePayload() throws JsonIOException, JsonSyntaxException, FileNotFoundException {

		JsonObject jsonObject = DataManager.getSpecificPayloadJSONURL("deletePlacePayload.json");
		jsonObject.addProperty("place_id", context.getPlace_id());
		return jsonObject.toString();
	}

	public String updatePlacePayload() throws Throwable {

		JsonObject jsonObject = DataManager.getSpecificPayloadJSONURL("updatePlacePayload.json");
		jsonObject.addProperty("place_id", context.getPlace_id());
		jsonObject.addProperty("key", fetchValueBasedOnKey("AuthValue"));
		return jsonObject.toString();

	}
	
}
