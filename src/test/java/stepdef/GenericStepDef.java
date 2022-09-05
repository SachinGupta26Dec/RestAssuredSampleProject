package stepdef;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.testng.Assert;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.AddPlacePayload;
import utilities.API_EndPoints;
import utilities.BaseUtil;
import utilities.Context;
import utilities.GenericUtil;

public class GenericStepDef extends BaseUtil {

	public GenericStepDef(GenericUtil genericUtil, Context context) {
		super(genericUtil,context);
	}

	/*
	 * @Before(order = 100, value = "@GetPlaceAPI_Exclude") public void setUp1()
	 * throws JsonIOException, JsonSyntaxException, Throwable { addPlaceAPI(); }
	 */	
	
	@Given("{string} Payload")
	public void payload(String payload) throws JsonIOException, JsonSyntaxException, FileNotFoundException, Throwable {

		Object obj;
		RequestSpecification request;

		if (payload.equalsIgnoreCase("Add Place")) {
			obj = genericUtil.addPlacePayload();
			context.setAddPlacePayload((AddPlacePayload) obj);
		} else if (payload.equalsIgnoreCase("Get Place")) {
			request = given().spec(requestSpecification()).queryParam("place_id", context.getPlace_id());
			context.setRequestSpecification(request);
			return;
		} else if (payload.equalsIgnoreCase("Delete Place")) {
			obj = genericUtil.deletePlacePayload();
		} else if (payload.equalsIgnoreCase("Update Place")) {
			obj = genericUtil.updatePlacePayload();
		} else
			throw new IllegalStateException("payload keyword is mnot matched");

		request = given().spec(requestSpecification()).body(obj);
		context.setRequestSpecification(request);
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String endPointName, String requestType) {

		String endpoint = API_EndPoints.valueOf(endPointName).getEndPoint();
		Response response;

		if (requestType.equalsIgnoreCase("post"))
			response = context.getRequestSpecification().when().post(endpoint);
		else if (requestType.equalsIgnoreCase("get"))
			response = context.getRequestSpecification().when().get(endpoint);
		else if (requestType.equalsIgnoreCase("delete"))
			response = context.getRequestSpecification().when().delete(endpoint);
		else if (requestType.equalsIgnoreCase("put"))
			response = context.getRequestSpecification().when().put(endpoint);
		else
			throw new IllegalStateException("Request type is not matched : " + requestType);

		context.setResponse(response);
	}

	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(int responseCode)
			throws JsonIOException, JsonSyntaxException, Throwable {

		context.getResponse().then().spec(responseSpecification(responseCode));
	}

	@Then("user validates the {string} value {string} from the repsonse body")
	public void user_validates_the_value_from_the_repsonse_body(String key, String value) {
		Response response = context.getResponse();
		JsonPath jsonPath = response.jsonPath();
		Assert.assertEquals(jsonPath.get(key), value);
	}

}
