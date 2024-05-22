package example.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

//@note start our spring boot application and make it available for our test to perform requests to it
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashcardApplicationTests {
	// @note inject a test helper that will allow me to make HTTP requests to the
	// locally running application
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnACashCardWhenDataIsSaved() {
		// @note make HTTP GET request to our application endpoint at /cashcards/99
		// @note restTemplate: will return a ResponseEntity,
		// @note ResponseEntity is another helpful Spring object that provides valuable
		// information about what happened with our request.
		ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/99", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}

// ()
// 1 2 3 4 5 6 7 8 9 0