package tests.c02_ApiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C04_PostJsonBodyTesti {

    /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
           request gonderdigimizde

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

            donen Response’un,

                 status code’unun 200,
                 ve content type’inin application-json,
                 ve response body’sindeki
                 "firstname“in,"Ahmet",
                 ve "lastname“in, "Bulut",
                 ve "totalprice“in,500,
                 ve "depositpaid“in,false,
                 ve "checkin" tarihinin 2021-06-01
                 ve "checkout" tarihinin 2021-06-10
                 ve "additionalneeds“in,"wi-fi"
                 oldugunu test edin

     */


    @Test
    public void postJsonBody01() {

        //1- Endpoint ve request body  hazirla

        String url = " https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2025-06-01");
        bookingdates.put("checkout", "2026-06-10");


        JSONObject requestBody = new JSONObject();

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("additionalneeds", "wi-fi");
        requestBody.put("bookingdates", bookingdates);


        //2- Expected data hazirla

        //3- Response kaydet

        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString()).post(url);


        response.prettyPrint();


        //4- Assertion

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstname", equalTo("Ahmet"))
                .body("booking.lastname", equalTo("Bulut"))
                .body("booking.totalprice", equalTo(500))
                .body("booking.depositpaid", equalTo(false))
                .body("booking.additionalneeds", equalTo("wi-fi"))
                .body("booking.bookingdates.checkin", equalTo("2025-06-01"))
                .body("booking.bookingdates.checkout", equalTo("2026-06-10"));


    }


}
