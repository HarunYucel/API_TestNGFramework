package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {

    /*
        http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
    donen Response'in
    status code'unun 200,
    ve content type'inin Aplication.JSON,
    ve response body'sindeki
        employees sayisinin 24
        ve employee'lerden birinin "Ashton Cox"
        ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin
    test edin.

     */

    @Test
    public void listKullanimi(){

        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla


        String url = "http://dummy.restapiexample.com/api/v1/employees";


        // 2 - Eger soruda bize verilmisse Expected Data hazirla

        // 3 - Bize donen Response'i Actual Data olarak kaydet

        Response response = given().when().get(url);

        response.prettyPrint();


        // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion


        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("data.id", hasSize(24),"data.employee_name",hasItem("Ashton Cox"),

                        "data.employee_age",hasItems(61,21,35) );







    }




}
