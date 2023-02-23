package test;

import TestData.TestdataDummy;
import baseURL.DummyBaseurl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Get_DeSerialization extends DummyBaseurl {
  /*  http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir
    // GET request gonderdigimizde donen response’un status code’unun 200,
    // content Type’inin application/json ve body’sinin asagidaki gibi oldugunu test edin.

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
 public void get(){

  // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

 specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);


  // 2 - Eger soruda bize verilmisse Expected Data hazirla

 TestdataDummy testdataDummy = new TestdataDummy();

HashMap<String,Object> expectedMap  = testdataDummy.evpectedMapOlustur();


  // 3 - Bize donen Response'i Actual Data olarak kaydet

  Response response = given().spec(specDummy).
          when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

  // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion


     assertEquals(testdataDummy.basarilisatatuskod,response.statusCode());
     assertEquals(testdataDummy.contentType,response.contentType());

     HashMap<String,Object>resmap = response.as(HashMap.class);


  assertEquals(expectedMap.get("status"),resmap.get("status"));
  assertEquals(expectedMap.get("message"),resmap.get("message"));

  assertEquals(    ((Map)(expectedMap.get("data"))).get("id"),((Map)(resmap.get("data"))).get("id") );
  assertEquals(    ((Map)(expectedMap.get("data"))).get("employee_name"),((Map)(resmap.get("data"))).get("employee_name") );
  assertEquals(    ((Map)(expectedMap.get("data"))).get("employee_salary"),((Map)(resmap.get("data"))).get("employee_salary") );
  assertEquals(    ((Map)(expectedMap.get("data"))).get("employee_age"),((Map)(resmap.get("data"))).get("employee_age") );
  assertEquals(    ((Map)(expectedMap.get("data"))).get("profile_image"),((Map)(resmap.get("data"))).get("profile_image") );


}



}
