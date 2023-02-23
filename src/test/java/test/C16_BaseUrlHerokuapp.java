package test;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C16_BaseUrlHerokuapp extends HerokuappBaseUrl {
  /*  Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
1-  https://restful-booker.herokuapp.com/booking endpointine
bir GET request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
 Response’ta 12 booking oldugunu test edin

2- https://restful-booker.herokuapp.com/booking endpointine
asagidaki body’ye sahip bir POST request gonderdigimizde donen
 response’un status code’unun 200 oldugunu ve “firstname” degerinin “Ahmet” oldugunu test edin

  "firstname" : "Ahmet",
   "lastname" : “Bulut",
   "totalprice" : 500,
  "depositpaid" : false,
  "bookingdates" : {"checkin" : "2021-06-01", "checkout" : "2021-06-10"},
  "additionalneeds" : "wi-fi"}

*/

 @Test
 public void get(){

 /*    1-  https://restful-booker.herokuapp.com/booking endpointine
     bir GET request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
     Response’ta 12 booking oldugunu test edin   */


  // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla
specHerokuapp.pathParam("pp1","booking");

  // 2 - Eger soruda bize verilmisse Expected Data hazirla

  // 3 - Bize donen Response'i Actual Data olarak kaydet

  Response response = given().spec(specHerokuapp).when().get("/{pp1}");

  response.prettyPrint();

  // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion

 response.then().assertThat()
          .statusCode(200)
          .body("bookingid",hasItem(154));


 }

 @Test
 public void POST(){

 /*   https://restful-booker.herokuapp.com/booking endpointine
asagidaki body’ye sahip bir POST request gonderdigimizde donen
 response’un status code’unun 200 oldugunu ve “firstname” degerinin “Ahmet” oldugunu test edin

  "firstname" : "Ahmet",
   "lastname" : “Bulut",
   "totalprice" : 500,
  "depositpaid" : false,
  "bookingdates" : {"checkin" : "2021-06-01", "checkout" : "2021-06-10"},
  "additionalneeds" : "wi-fi"}  */


  // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla
  specHerokuapp.pathParam("pp1","booking");

  // 2 - Eger soruda bize verilmisse Expected Data hazirla

  JSONObject innerbody = new JSONObject();

  innerbody.put("checkin","2021-06-01");
  innerbody.put("checkout","2021-06-10");


  JSONObject requestbody = new JSONObject();

  requestbody.put("firstname","Ahmet");
  requestbody.put("lastname","Bulut");
  requestbody.put("totalprice",500);
  requestbody.put("depositpaid","true");
  requestbody.put("bookingdates",innerbody);
  requestbody.put("additionalneeds","wi-fi");


  // 3 - Bize donen Response'i Actual Data olarak kaydet

  Response response = given().spec(specHerokuapp).contentType(ContentType.JSON).
          when().body(requestbody.toString())
          .post("/{pp1}");

  response.prettyPrint();

  // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion

  response.then().assertThat()
          .statusCode(200)
          .body("booking.firstname",equalTo("Ahmet"));


 }

 /*
 2- https://restful-booker.herokuapp.com/booking endpointine
  gerekli Query parametrelerini yazarak “firstname” degeri “Eric” olan
   rezervasyon oldugunu test edecek bir GET request gonderdigimizde, donen
   response’un status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin

  */


 @Test
 public void get01(){
  // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Eric");

// 2 - Eger soruda bize verilmisse Expected Data hazirla

  // 3 - Bize donen Response'i Actual Data olarak kaydet

Response response = given().spec(specHerokuapp).when().get("/{pp1}");


response.prettyPrint();

  // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion
response.then().statusCode(200)
        .body("bookingid",(hasSize(1)));





 }




}
