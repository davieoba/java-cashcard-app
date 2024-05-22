package example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @note tells spring this is a component that is capable of handling HTTP
// requests

@RequestMapping("/cashcards") // @note indicates which address requests must have to access this controller
public class CashCardController {

    // @note marks a method as a handler method GET requests that match
    // cashcards/{requestID} will be handled by this method
    @GetMapping("/{requestId}")
    private ResponseEntity<String> findById() {
        return ResponseEntity.ok("{}");
    }
}

// () ""