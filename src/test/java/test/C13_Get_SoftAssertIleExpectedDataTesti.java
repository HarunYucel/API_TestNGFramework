package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {

 /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
     Response Body

{
    "status": "success",
    "data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}

  */

@Test
    public void Get_SoftAssert(){
    // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla
    // 2 - Eger soruda bize verilmisse Expected Data hazirla
    // 3 - Bize donen Response'i Actual Data olarak kaydet
    // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion


    // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

    String url  = " http://dummy.restapiexample.com/api/v1/employee/3";

    // 2 - Eger soruda bize verilmisse Expected Data hazirla

    JSONObject innerbody = new JSONObject();
    innerbody.put("id",3);
    innerbody.put("employee_name","Ashton Cox");
    innerbody.put("employee_salary",86000);
    innerbody.put("employee_age",66);
    innerbody.put("profile_image","");

    JSONObject expectedbody = new JSONObject();

    expectedbody.put("status","success");
    expectedbody.put("data",innerbody);
    expectedbody.put("message","Successfully! Record has been fetched.");

    // 3 - Bize donen Response'i Actual Data olarak kaydet

    Response response = given().when().get(url);

    response.prettyPrint();
    // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion

 JsonPath responsjsonpath = response.jsonPath();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertEquals(responsjsonpath.get("status"),expectedbody.get("status"));
    softAssert.assertEquals(responsjsonpath.get("message"),expectedbody.get("message"));
    softAssert.assertEquals(responsjsonpath.get("data.id"),expectedbody.getJSONObject("data").get("id"));
    softAssert.assertEquals(responsjsonpath.get("data.employee_name"),expectedbody.getJSONObject("data").get("employee_name"));
    softAssert.assertEquals(responsjsonpath.get("data.employee_salary"),expectedbody.getJSONObject("data").get("employee_salary"));
    softAssert.assertEquals(responsjsonpath.get("data.employee_age"),expectedbody.getJSONObject("data").get("employee_age"));
    softAssert.assertEquals(responsjsonpath.get("data.profile_image"),expectedbody.getJSONObject("data").get("profile_image"));




    softAssert.assertAll();




}




}
