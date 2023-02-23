package test;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.pojoHerokuappExpected;
import pojos.pojoHerokuappbooking;
import pojos.pojoHerokuappbookingdates;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Post_Pojo extends HerokuappBaseUrl {

/*
https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
 gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin
 */

  /*  Request body
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


    Response Body // expected data
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
    public void post(){
    // 1 - URL ve Body hazirla
    // 2 - Expected Data hazirla
    // 3 - Response'i kaydet
    // 4-   Assertion

    // 1 - URL ve Body hazirla

    specHerokuapp.pathParam("pp1","booking");

    pojoHerokuappbookingdates bookingdates = new pojoHerokuappbookingdates("2021-06-01","2021-06-10");

    pojoHerokuappbooking requestbody = new pojoHerokuappbooking("Ahmet","Bulut",500,false,"wi-fi",bookingdates);

    System.out.println("responsepojo = " + requestbody);
    // 2 - Expected Data hazirla

    pojoHerokuappExpected expectedData = new pojoHerokuappExpected(24,requestbody);
    // 3 - Response'i kaydet

    Response response = given().spec(specHerokuapp).contentType(ContentType.JSON).
            when().body(requestbody).post("/{pp1}");

    response.prettyPrint();

    //4-Assertion

    pojoHerokuappExpected responsepojo = response.as(pojoHerokuappExpected.class);

    assertEquals(expectedData.getBooking().getFirstname(),responsepojo.getBooking().getFirstname());
    assertEquals(expectedData.getBooking().getLastname(),responsepojo.getBooking().getLastname());
    assertEquals(expectedData.getBooking().getAdditionalneeds(),responsepojo.getBooking().getAdditionalneeds());
    assertEquals(expectedData.getBooking().isDepositpaid(),responsepojo.getBooking().isDepositpaid());
    assertEquals(expectedData.getBooking().getTotalprice(),responsepojo.getBooking().getTotalprice());
    assertEquals(expectedData.getBooking().getBookingdates().getCheckin(),responsepojo.getBooking().getBookingdates().getCheckin());
    assertEquals(expectedData.getBooking().getBookingdates().getCheckout(),responsepojo.
            getBooking().getBookingdates().getCheckout());
    



}
}
