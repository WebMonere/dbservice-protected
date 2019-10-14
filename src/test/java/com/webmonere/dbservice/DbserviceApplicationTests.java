package com.webmonere.dbservice;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)  // Need for Autowired WebTestClient
public class DbserviceApplicationTests {

	@Autowired
	private WebTestClient webClient;

	private String auth_token;

	public DbserviceApplicationTests() throws UnirestException {
		HttpResponse<String> response = Unirest.post("https://rajdeepdev.auth0.com/oauth/token")
				.header("content-type", "application/json")
				.body("{\"client_id\":\"AQQFPs6alhdlGPXy1hHq66JZA1JqdYuD\",\"client_secret\":\"tj3hdzE1KIWE6uXBTtLHSrvj1j7OqNWNkC5Qzzr2IFAf5w7wzqJH_aDdCqveidvU\",\"audience\":\"https://localhost/\",\"grant_type\":\"client_credentials\"}")
				.asString();
		JSONObject temp1 = new JSONObject(response.getBody());
		System.out.println(temp1.get("access_token"));
		this.auth_token=temp1.get("access_token").toString();
	}

/*	@Test
	public void contextLoads() throws UnirestException {
		HttpResponse<String> response = Unirest.post("https://rajdeepdev.auth0.com/oauth/token")
				.header("content-type", "application/json")
				.body("{\"client_id\":\"AQQFPs6alhdlGPXy1hHq66JZA1JqdYuD\",\"client_secret\":\"tj3hdzE1KIWE6uXBTtLHSrvj1j7OqNWNkC5Qzzr2IFAf5w7wzqJH_aDdCqveidvU\",\"audience\":\"https://localhost/\",\"grant_type\":\"client_credentials\"}")
			    .asString();
		JSONObject temp1 = new JSONObject(response.getBody());
		System.out.println(temp1.get("access_token"));
		this.auth_token=temp1.get("access_token").toString();
	}*/

	//Check http://localhost/ has public access
	@Test
	public void resourceEntryPointNonAuthApiAccess()
	{
		this.webClient.get().uri("/").exchange().expectStatus().isOk();
	}
	@Test
	public void userResourceNonAuthIsBlocked()
	{
		this.webClient.get().uri("/users").exchange().expectStatus().isUnauthorized();
	}
	@Test
	public void userResourceAuthAccessPermit() {
		this.webClient.get().uri("/users")
				.header("Authorization", "Bearer"+" "+this.auth_token)
				.exchange().expectStatus().isOk();
	}
	@Test
	public void HostNameResourceNonAuthIsBlocked()
	{
		this.webClient.get().uri("/hostnames").exchange().expectStatus().isUnauthorized();
	}
	@Test
	public void HostNamesResourceAuthAccessPermit() {
		this.webClient.get().uri("/hostnames")
				.header("Authorization","Bearer"+" "+this.auth_token)
				.exchange().expectStatus().isOk();
	}
	@Test
	public void HostMappingResourceNonAuthIsBlocked()
	{
		this.webClient.get().uri("/hostmappings").exchange().expectStatus().isUnauthorized();
	}
	@Test
	public void HostMappingResourceAuthAccessPermit() {
		this.webClient.get().uri("/hostmappings")
				.header("Authorization","Bearer"+" "+this.auth_token)
				.exchange().expectStatus().isOk();
	}


}
