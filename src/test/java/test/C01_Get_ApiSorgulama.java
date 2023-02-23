package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {

@Test
 public  void get01(){


    /*
    https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */


     // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

/*


git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/HarunYucel/API_TestNGFramework.git
git push -u origin main
 */



    String url = "https://restful-booker.herokuapp.com/booking/445";


    // 2- eger soruda bize verilmişse expected data hazırla
    //3- bize donen response'i actual data olarak kaydet

    Response response = given().when().get(url);
    response.prettyPrint();

    System.out.println("status code"+response.getStatusCode());


    //4- expected data ile actual data karsılastırılması - assertion







}




}
