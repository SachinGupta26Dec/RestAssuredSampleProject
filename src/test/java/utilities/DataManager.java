package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class DataManager {

	private static String environmentDetailsPath = "/src/test/resources/config/EnvironmentDetails.json";
	private static String payloadPath = "/src/test/resources/data/";

	public static JsonObject getEnvironmentDetailsJSONURL()
			throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		String basePath = new File("").getAbsolutePath();
		String completePath = basePath + environmentDetailsPath;
		JsonElement obj = JsonParser.parseReader(new FileReader(completePath));
		JsonObject jsonObject = (JsonObject) obj;
		return jsonObject;
	}

	public static String fetchObjectObject(JsonObject jsonObject, String key1, String key2) throws Throwable {
		JsonObject obj = (JsonObject) jsonObject.get(key1);
		String value = obj.get(key2).getAsString();
		return value;
	}
	
	public static JsonObject getSpecificPayloadJSONURL(String payloadName)
			throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		String basePath = new File("").getAbsolutePath();
		String completePath = basePath + payloadPath + payloadName;
		JsonElement obj = JsonParser.parseReader(new FileReader(completePath));
		JsonObject jsonObject = (JsonObject) obj;
		return jsonObject;
	}
}
