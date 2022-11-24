package restassuredapitest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RestAssuredTest {

    @Test
    public void getClientsTest() {

        when()
                .get("https://generator.swagger.io/api/gen/clients")
                .then()
                .statusCode(200);
    }

    @Test
    public void getLanguageTest() {
        when()
                .get("https://generator.swagger.io/api/gen/clients/java")
                .then()
                .statusCode(200);
    }

    @Test
    public void getDummyLanguageTest() {
        when()
                .get("https://generator.swagger.io/api/gen/clients/dummy")
                .then()
                .statusCode(200);
    }

    @Test
    public void postLanguageTest() {
        String postData = "{\n"
                + "  \"spec\": {},\n"
                + "  \"options\": {\n"
                + "    \"additionalProp1\": \"string1\",\n"
                + "    \"additionalProp2\": \"string2\",\n"
                + "    \"additionalProp3\": \"string3\"\n"
                + "  },\n"
                + "  \"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\",\n"
                + "  \"authorizationValue\": {\n"
                + "    \"value\": \"string\",\n"
                + "    \"type\": \"string\",\n"
                + "    \"keyName\": \"string\",\n"
                + "    \"urlMatcher\": {}\n"
                + "  },\n"
                + "  \"usingFlattenSpec\": true,\n"
                + "  \"securityDefinition\": {\n"
                + "    \"type\": \"string\",\n"
                + "    \"description\": \"string\"\n"
                + "  }\n"
                + "}";

        given()
                .contentType(ContentType.JSON)
                .body(postData)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(200);
    }

}

