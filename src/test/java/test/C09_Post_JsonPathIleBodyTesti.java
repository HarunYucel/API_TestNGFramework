package test;


import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C09_Post_JsonPathIleBodyTesti {

 /*   https://restful-booker.herokuapp.com/booking url’ine
 asagidaki body'ye sahip bir POST request gonderdigimizde

    {
        "firstname" : "Ahmet",
            "lastname" : “Bulut",
        "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
        "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
    },
        "additionalneeds" : "wi-fi"


donen Response’un,
   status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
       "firstname“in,"Ahmet",
       ve "lastname“in, "Bulut",
   ve "totalprice“in,500,
   ve "depositpaid“in,false,
   ve "checkin" tarihinin 2021-06-01
   ve "checkout" tarihinin 2021-06-10
   ve "additionalneeds“in,"wi-fi"

   oldugunu test edin   */


@Test
    public void postJsonPath(){

    // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

    String url = " https://restful-booker.herokuapp.com/booking";

    JSONObject innerbody = new JSONObject();

    innerbody.put("checkin","2021-06-01");
    innerbody.put("checkout","2021-06-10");

    JSONObject requestbody = new JSONObject();
    requestbody.put( "firstname", "Ahmet");
    requestbody.put( "lastname", "Ahmet");
    requestbody.put( "totalprice", 500);
    requestbody.put( "depositpaid", "false");
    requestbody.put( "bookingdates", innerbody);
    requestbody.put( "additionalneeds", "wi-fi");


    // 2 - Eger soruda bize verilmisse Expected Data hazirla

    // 3 - Bize donen Response'i Actual Data olarak kaydet
    Response response = given().contentType("application/json").
            when().body(requestbody.toString()).post(url);

    response.prettyPrint();

    // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion

response.then().assertThat()
        .statusCode(200)
        .contentType("application/json")
        .body("booking.firstname",equalTo("Ahmet"),
         "booking.lastname",equalTo("Bulut"),
                "booking.totalprice",equalTo(500),
                "booking.depositpaid",equalTo("false"),
                "booking.bookingdates.checkin",equalTo("2021-06-01"),
                "booking.bookingdates.checkout",equalTo("2021-06-10"),
                "additionalneeds",equalTo("wi-fi")
        );








}






}
