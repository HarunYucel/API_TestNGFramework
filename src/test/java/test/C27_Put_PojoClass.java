package test;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.pojoJsonplacedata;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Put_PojoClass extends JsonPlaceHolderBaseUrl {
    /*
 https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body’e sahip bir PUT request yolladigimizda donen response’in response
  body’sinin asagida verilen ile ayni oldugunu test ediniz

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
     // 1 - URL ve Body hazirla
     // 2 - Expected Data hazirla
     // 3 - Response'i kaydet
     // 4-   Assertion

     // 1 - URL ve Body hazirla

     specJsonPlace.pathParams("pp1","posts","pp2",70);

     pojoJsonplacedata requestbody = new pojoJsonplacedata("Ahmet","Merhaba",10,70);

     System.out.println("requestbody = " + requestbody);

     // 2 - Expected Data hazirla

     pojoJsonplacedata ExpectedData = new pojoJsonplacedata("Ahmet","Merhaba",10,70);

     // 3 - Response'i kaydet

     Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(requestbody)
             .put("/{pp1}/{pp2}");

     // 4-   Assertion

  // PojoHerokuappExpectedBody respPojo = response.as(PojoHerokuappExpectedBody.class);

   pojoJsonplacedata responsepojo = response.as(pojoJsonplacedata.class);

     assertEquals(ExpectedData.getTitle(),responsepojo.getTitle());
     assertEquals(ExpectedData.getBody(),responsepojo.getBody());
     assertEquals(ExpectedData.getUserId(),responsepojo.getUserId());
     assertEquals(ExpectedData.getId(),responsepojo.getId());

 }








}
