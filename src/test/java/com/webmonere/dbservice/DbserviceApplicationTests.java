package com.webmonere.dbservice;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
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

	/*@Test
	public void contextLoads() throws UnirestException {
		HttpResponse<String> response = (HttpResponse<String>) Unirest.get("http://localhost/api/private")
				.header("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFVTTBRekUwTWtSQk5qZEJNRE16TWtNMk0wSTNOamRDTkRCQlEwSkZOVU5GT0RSR1FqWXhSQSJ9.eyJpc3MiOiJodHRwczovL3JhamRlZXBkZXYuYXV0aDAuY29tLyIsInN1YiI6IkFRUUZQczZhbGhkbEdQWHkxaEhxNjZKWkExSnFkWXVEQGNsaWVudHMiLCJhdWQiOiJodHRwczovL2xvY2FsaG9zdC8iLCJpYXQiOjE1NzA2NDU3NTcsImV4cCI6MTU3MDczMjE1NywiYXpwIjoiQVFRRlBzNmFsaGRsR1BYeTFoSHE2NkpaQTFKcWRZdUQiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.EGYQSorcFuUqRtacpW-MgAM_XnMPyRaiY_I26YbRnY1n_WiPcJ1Kn3uyEdFYGXXJmwzUZnecT6W6YNn2Vm40lkdJB66d8MAdiYxjCwlSwMqNAW4Nux9h15nbqPmn9XXww3YtHsfykDSk6BDuf_fO3yTRQb0V0E4_vyCsEkFtJE7mgJEBRwc2ggYIq-ePvO6tSWKCHJAL9tIkx_Ou1QPVu_RusOAd0w90sTYfL_Na19bMk4dj9hN-2lBkqr1gL7pIOrn0Ul4CdNLhtsepNV5OX2DjGsvcpVU-_0aQ6LIOV0kl9grw6U69fej3Bj-XGDQfMqMGZQUlNU3ZX-jdmvTItQ")
				.asString();

		System.out.println(response.getBody());
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
				.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFVTTBRekUwTWtSQk5qZEJNRE16TWtNMk0wSTNOamRDTkRCQlEwSkZOVU5GT0RSR1FqWXhSQSJ9.eyJpc3MiOiJodHRwczovL3JhamRlZXBkZXYuYXV0aDAuY29tLyIsInN1YiI6IkFRUUZQczZhbGhkbEdQWHkxaEhxNjZKWkExSnFkWXVEQGNsaWVudHMiLCJhdWQiOiJodHRwczovL2xvY2FsaG9zdC8iLCJpYXQiOjE1NzA2NDU3NTcsImV4cCI6MTU3MDczMjE1NywiYXpwIjoiQVFRRlBzNmFsaGRsR1BYeTFoSHE2NkpaQTFKcWRZdUQiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.EGYQSorcFuUqRtacpW-MgAM_XnMPyRaiY_I26YbRnY1n_WiPcJ1Kn3uyEdFYGXXJmwzUZnecT6W6YNn2Vm40lkdJB66d8MAdiYxjCwlSwMqNAW4Nux9h15nbqPmn9XXww3YtHsfykDSk6BDuf_fO3yTRQb0V0E4_vyCsEkFtJE7mgJEBRwc2ggYIq-ePvO6tSWKCHJAL9tIkx_Ou1QPVu_RusOAd0w90sTYfL_Na19bMk4dj9hN-2lBkqr1gL7pIOrn0Ul4CdNLhtsepNV5OX2DjGsvcpVU-_0aQ6LIOV0kl9grw6U69fej3Bj-XGDQfMqMGZQUlNU3ZX-jdmvTItQ")
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
				.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFVTTBRekUwTWtSQk5qZEJNRE16TWtNMk0wSTNOamRDTkRCQlEwSkZOVU5GT0RSR1FqWXhSQSJ9.eyJpc3MiOiJodHRwczovL3JhamRlZXBkZXYuYXV0aDAuY29tLyIsInN1YiI6IkFRUUZQczZhbGhkbEdQWHkxaEhxNjZKWkExSnFkWXVEQGNsaWVudHMiLCJhdWQiOiJodHRwczovL2xvY2FsaG9zdC8iLCJpYXQiOjE1NzA2NDU3NTcsImV4cCI6MTU3MDczMjE1NywiYXpwIjoiQVFRRlBzNmFsaGRsR1BYeTFoSHE2NkpaQTFKcWRZdUQiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.EGYQSorcFuUqRtacpW-MgAM_XnMPyRaiY_I26YbRnY1n_WiPcJ1Kn3uyEdFYGXXJmwzUZnecT6W6YNn2Vm40lkdJB66d8MAdiYxjCwlSwMqNAW4Nux9h15nbqPmn9XXww3YtHsfykDSk6BDuf_fO3yTRQb0V0E4_vyCsEkFtJE7mgJEBRwc2ggYIq-ePvO6tSWKCHJAL9tIkx_Ou1QPVu_RusOAd0w90sTYfL_Na19bMk4dj9hN-2lBkqr1gL7pIOrn0Ul4CdNLhtsepNV5OX2DjGsvcpVU-_0aQ6LIOV0kl9grw6U69fej3Bj-XGDQfMqMGZQUlNU3ZX-jdmvTItQ")
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
				.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFVTTBRekUwTWtSQk5qZEJNRE16TWtNMk0wSTNOamRDTkRCQlEwSkZOVU5GT0RSR1FqWXhSQSJ9.eyJpc3MiOiJodHRwczovL3JhamRlZXBkZXYuYXV0aDAuY29tLyIsInN1YiI6IkFRUUZQczZhbGhkbEdQWHkxaEhxNjZKWkExSnFkWXVEQGNsaWVudHMiLCJhdWQiOiJodHRwczovL2xvY2FsaG9zdC8iLCJpYXQiOjE1NzA2NDU3NTcsImV4cCI6MTU3MDczMjE1NywiYXpwIjoiQVFRRlBzNmFsaGRsR1BYeTFoSHE2NkpaQTFKcWRZdUQiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.EGYQSorcFuUqRtacpW-MgAM_XnMPyRaiY_I26YbRnY1n_WiPcJ1Kn3uyEdFYGXXJmwzUZnecT6W6YNn2Vm40lkdJB66d8MAdiYxjCwlSwMqNAW4Nux9h15nbqPmn9XXww3YtHsfykDSk6BDuf_fO3yTRQb0V0E4_vyCsEkFtJE7mgJEBRwc2ggYIq-ePvO6tSWKCHJAL9tIkx_Ou1QPVu_RusOAd0w90sTYfL_Na19bMk4dj9hN-2lBkqr1gL7pIOrn0Ul4CdNLhtsepNV5OX2DjGsvcpVU-_0aQ6LIOV0kl9grw6U69fej3Bj-XGDQfMqMGZQUlNU3ZX-jdmvTItQ")
				.exchange().expectStatus().isOk();
	}


}
