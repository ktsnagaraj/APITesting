package com.api.step_definition;

import java.io.IOException;
import com.api.utilities.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.support.PageFactory;
import com.itextpdf.text.DocumentException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITestingGET {
	
		int statusCodeGET, statusCodePOST;
		String statusTextGET, statusTextPOST;
		HttpResponse<JsonNode> responseGET, responsePOST;
		
		
		@Given("^the URL to perform API Testing$")
		public void the_URL_to_perform_API_Testing() throws IOException {	
		}		

		@Given("^trigger the GET request$")
		public void trigger_the_GET_request() throws UnirestException {		
			HttpResponse<JsonNode> responseGET = Unirest.get("https://reqres.in/api/users?page=2").asJson();
			statusCodeGET = responseGET.getStatus();
			statusTextGET = responseGET.getStatusText();
		}		

		@Given("^trigger the POST request$")
		public void trigger_the_POST_request() throws UnirestException {
			HttpResponse<JsonNode> responsePOST = Unirest.post("https://reqres.in/api/users")
				.body("{\name\":\"Nagaraj\",\"designation\":\"Automation Engineer\"}").asJson();
			statusCodePOST = responsePOST.getStatus();
			statusTextPOST = responsePOST.getStatusText();
		}		

		@Given("^valid status code received as response$")
		public void valid_status_code_received_as_response() {	
			System.out.println("Get: StatusCode - " + statusCodeGET + " statusText - " + statusTextGET);
			System.out.println("Post: StatusCode - " + statusCodePOST + " statusText - " + statusTextPOST);
		}
	}