package example.cashcard;
//@note TDD to create a data contract for your CashCard API
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest //@note wrapper to the jackson json parsing library. it handles serialization and deserialization
public class CashCardJsonTest {
    @Autowired //@note is an annotation that directs spring to create an object of the requested type
    private JacksonTester<CashCard> json; // @note test the JSON serialization and deserialization of CashCard objects

    @Test
    void cashCardSerializationTest() throws IOException {
        CashCard cashCard = new CashCard(99L, 123.45);
        //@note json.write serializes the CashCard object to a JSON string
        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json"); //@note verifies that the serialized JSON is exactly the same as the JSON content in the expected.json file
//        @note: both these next assertThat checks that JSON output has a field ID with the value 99
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);

//        @note: checks that it has the field amount with right value
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
    }

    @Test
    void cashCardDeserializationTest() throws IOException {
        String expected = """ 
                {
                    "id": 99,
                    "amount": 123.45
                }
                """;
        assertThat(json.parse(expected))
                .isEqualTo(new CashCard(99L, 123.45));
        assertThat(json.parseObject(expected).id()).isEqualTo(99);
        assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
    }
}


// () "" 1 2 3 4 5 6 7 8 9 0