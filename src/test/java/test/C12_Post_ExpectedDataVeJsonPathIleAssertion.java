package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

/*
https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
bir POST request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

Request body
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
       }

Response Body
{
    "bookingid": 24,
    "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
}

 */



  @Test
  public void  Post_ExpectedData(){
      /*
       // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla
    // 2 - Eger soruda bize verilmisse Expected Data hazirla
    // 3 - Bize donen Response'i Actual Data olarak kaydet
    // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion
       */


      // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

  String url = "https://restful-booker.herokuapp.com/booking";

  JSONObject innerbody = new JSONObject();

  innerbody.put("checkin","2021-06-01");
  innerbody.put("checkout","2021-06-10");


      JSONObject Requestbody = new JSONObject();

      Requestbody.put("firstname","Ahmet");
      Requestbody.put("lastname","Bulut");
      Requestbody.put("totalprice",500);
      Requestbody.put("depositpaid","false");
      Requestbody.put("bookingdates",innerbody);
      Requestbody.put("additionalneeds","wi-fi");

      // 2 - Eger soruda bize verilmisse Expected Data hazirla

   JSONObject expectedbody = new JSONObject();

   expectedbody.put("bookingid",24);
   expectedbody.put("booking",Requestbody);

      // 3 - Bize donen Response'i Actual Data olarak kaydet

      Response response = given().contentType(ContentType.JSON)
              .when().body(Requestbody.toString()).post(url);

      response.prettyPrint();

      // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion

      // expected ile karsılastırmak için response jsonPathe cevirmemiz lazım

      JsonPath responspath = response.jsonPath();

      assertEquals(expectedbody.getJSONObject("booking.firstname"),responspath.get("booking.firstname"));
      assertEquals(expectedbody.getJSONObject("booking").get("lastname"),responspath.get("booking.lastname"));
      assertEquals(expectedbody.getJSONObject("booking").get("additionalneeds"),responspath.get("booking.additionalneeds"));
      assertEquals(expectedbody.getJSONObject("booking").get("totalprice"),responspath.get("booking.totalprice"));
      assertEquals(expectedbody.getJSONObject("booking").get("depositpaid"),responspath.get("booking.depositpaid"));
      assertEquals(expectedbody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
              responspath.get("booking.bookingdates.checkin"));
      assertEquals(expectedbody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
              responspath.get("booking.bookingdates.checkout"));  




  }





}
