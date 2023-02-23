package test;

import io.restassured.response.Response;

import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class C7_Get_BodyTekrarlardanKurtulma {

/*
https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
 	status code’unun 200,
	ve content type’inin application-json,
	ve response body’sindeki
 		"firstname“in, "Mark",
    		ve "lastname“in, "Jones",
    		ve "totalprice“in, 930,
    		ve "depositpaid“in, true,
    		ve "additionalneeds“in, "Breakfast"
oldugunu test edin


 */


    @Test
    public void getRequest(){

        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla
        // 2 - Eger soruda bize verilmisse Expected Data hazirla
        // 3 - Bize donen Response'i Actual Data olarak kaydet
        // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion


        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response  = given().when().get(url);

        response.prettyPrint();


        response.then().assertThat()
                .contentType("application/json")
                .body("firstname", equalTo("Mark"),
                        "lastname",equalTo("Jones"),
                        "totalprice",equalTo(930),
                        "depositpaid",equalTo("true"),
                        "additionalneeds",equalTo("Breakfast")


                );





    }


}
