package utilities;

import java.io.FileOutputStream;
import java.io.PrintStream;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseUtil {

	public RequestSpecification requestSpec;
	public GenericUtil genericUtil;
	public Context context;

	public BaseUtil(GenericUtil genericUtil,Context context) {		
		this.genericUtil = genericUtil;
		this.context = context;
	}	

	public RequestSpecification requestSpecification()
			throws JsonIOException, JsonSyntaxException, Throwable {

		if (requestSpec == null) {
			PrintStream log = new PrintStream(new FileOutputStream(context.getLogFileName()));
			requestSpec = new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri(genericUtil.fetchValueBasedOnKey("BaseURI"))
					.addFilter(RequestLoggingFilter.logRequestTo(log)).addQueryParam("key", genericUtil.fetchValueBasedOnKey("AuthValue"))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return requestSpec;
		}

		return requestSpec;

	}

	public ResponseSpecification responseSpecification(int responseCode)
			throws JsonIOException, JsonSyntaxException, Throwable {

		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(responseCode).expectContentType(ContentType.JSON)
				.build();
		return responseSpec;

	}

}
