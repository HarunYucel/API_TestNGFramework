package test;

import TestData.TestdataJsonplaceholder;
import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {

    /*
  https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
  yolladigimizda donen response’in status kodunun 200 ve response body’sinin
  asagida verilen ile ayni oldugunutest ediniz
   Response body :
{
    "userId": 3,
    "id": 22,
    "title": "dolor sint quo a velit explicabo quia nam",
    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
             um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */


@Test
    public void get(){
    // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

   specJsonPlace.pathParams("pp1","posts","pp2",22);

    // 2 - Eger soruda bize verilmisse Expected Data hazirla

    TestdataJsonplaceholder testdataJsonplaceholder = new TestdataJsonplaceholder();


   JSONObject expectedData = testdataJsonplaceholder.expextedbodyJson();

    // 3 - Bize donen Response'i Actual Data olarak kaydet

    Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");



    // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion

   JsonPath responsePath = response.jsonPath();

   assertEquals(testdataJsonplaceholder.basariliStatusCode,response.statusCode());
   assertEquals(expectedData.get("userId"),responsePath.get("userId"));
   assertEquals(expectedData.get("id"),responsePath.get("id"));
   assertEquals(expectedData.get("title"),responsePath.get("title"));
   assertEquals(expectedData.get("body"),responsePath.get("body"));


}

}
