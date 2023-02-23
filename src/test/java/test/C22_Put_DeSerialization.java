package test;

import TestData.TestdataJsonplaceholder;
import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;

import java.util.HashMap;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
     body’e sahip bir PUT request yolladigimizda donen response’in
     response body’sinin asagida verilen ile ayni oldugunu test ediniz

Request Body
{
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
}


	Expected Data :
{
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
}
     */


    @Test
    public void put(){




        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

      specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestdataJsonplaceholder testdataJsonplaceholder = new TestdataJsonplaceholder();

        HashMap<String,Object> RequestbodyMap = testdataJsonplaceholder.requestbodyMap();


        // 2 - Eger soruda bize verilmisse Expected Data hazirla

        HashMap<String,Object> expectedbodyMap = testdataJsonplaceholder.requestbodyMap();

        // 3 - Bize donen Response'i Actual Data olarak kaydet

        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).when().
                body(RequestbodyMap).put("/{pp1}/{pp2}");

        HashMap<String,Object> responseMap = response.as(HashMap.class);

        // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion

      assertEquals( testdataJsonplaceholder.basariliStatusCode,response.statusCode());
     assertEquals(expectedbodyMap.get("title"),responseMap.get("title"));
     assertEquals(expectedbodyMap.get("body"),responseMap.get("body"));
     assertEquals(expectedbodyMap.get("userId"),responseMap.get("userId"));
     assertEquals(expectedbodyMap.get("id"),responseMap.get("id"));




    }


}
