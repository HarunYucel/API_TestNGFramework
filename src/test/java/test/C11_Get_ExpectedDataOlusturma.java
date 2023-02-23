package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {

/*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda
    donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
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

 public void expecteddata(){

    // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla
    // 2 - Eger soruda bize verilmisse Expected Data hazirla
    // 3 - Bize donen Response'i Actual Data olarak kaydet
    // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion


    // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

    String url  = "https://jsonplaceholder.typicode.com/posts/22";

    // 2 - Eger soruda bize verilmisse Expected Data hazirla

  JSONObject expectedbody= new JSONObject();

  expectedbody.put("userId", 3);
  expectedbody.put("id",22);
  expectedbody.put("title", "dolor sint quo a velit explicabo quia nam");
  expectedbody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");




    //  3 - Bize donen Response'i Actual Data olarak kaydet

  Response response = given().when().get(url);


    JsonPath responsejsPath = response.jsonPath();
// 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion
    Assert.assertEquals(expectedbody.get("userId"),responsejsPath.getInt("userId"));
    Assert.assertEquals(expectedbody.get("id"),responsejsPath.getInt("id"));
    Assert.assertEquals(expectedbody.get("title"),responsejsPath.getString("title"));
    Assert.assertEquals(expectedbody.get("body"),responsejsPath.getString("body"));












}








}
