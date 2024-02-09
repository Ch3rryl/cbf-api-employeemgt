package com.cbfacademy.apiassessment;


import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/greeting");
	}

	@Test
	@Description("/greeting endpoint returns expected response for default name")
	public void greeting_ExpectedResponseWithDefaultName() {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

		assertEquals(200, response.getStatusCode().value());
		assertEquals("Hello World", response.getBody());
	}

	@Test
	@Description("/greeting endpoint returns expected response for specified name parameter")
	public void greeting_ExpectedResponseWithNameParam() {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "?name=John", String.class);

		assertEquals(200, response.getStatusCode().value());
		assertEquals("Hello John", response.getBody());
	}
} 
// additional tests to incorporate 
// check employee name

// @Test
// @DisplayName("employee id check returns expected details")
// public void findbByIdTest() {

// 	String testEmployeeID = findById("a0aef67d-9244-4a3e-8b69-1b1e3f31ab09"); 
// 	String testEmployeeName = "John Doe"; 

// 	assertEquals(testEmployeeID, testEmployeeName);
	
// }

// @GetMapping("/employees/{id}")
// public ResponseEntity<Employee> findEmployeeById(@PathVariable UUID id) {
// 	Optional<Employee> employeeOptional = repository.findById(id);

// 	if (employeeOptional.isPresent()) {
// 		Employee employee = employeeOptional.get();
// 		return new ResponseEntity<>(employee, HttpStatus.OK);
// 	} else {
// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	}
// }