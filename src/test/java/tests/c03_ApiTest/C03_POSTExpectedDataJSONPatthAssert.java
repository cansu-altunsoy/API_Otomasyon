package tests.c03_ApiTest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C03_POSTExpectedDataJSONPatthAssert {


    /*
     https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST
        request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

                   Request body
             {
             }
             "firstname" : "Ayse",
             "lastname" : “Sezen",
             "totalprice" : 500,
             "depositpaid" : false,

             "bookingdates" : {
             "checkin" : "2025-06-01",
             "checkout" : "2026-06-10"
                   },

             "additionalneeds" : "wi-fi


              Response Body - Expected data
             {
             }
             "bookingid": 24,

             "booking": {
             "firstname": "Asyse",
             "lastname": "Sezen",
             "totalprice": 500,
             "depositpaid": false,

             "bookingdates": {
             "checkin": "2025-06-01",
             "checkout": "2026-06-10"
             },

             "additionalneeds": "wi-fi"
     */


    @Test
    public void post01(){

        //1- Url ve Request body hazirla

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2025-06-01");
        bookingDates.put("checkout", "2026-06-01");

        JSONObject requestBody = new JSONObject();

        requestBody.put("firstname" ,"Ayse");
        requestBody.put("lastname" ,"Sezen");
        requestBody.put("totalprice" ,5000);
        requestBody.put("depositpaid" ,false);
        requestBody.put("additionalneeds" ,"wi-fi");
        requestBody.put("bookingdates", bookingDates);

        //2- EXPECTED DATA HAZIRLAMA

        JSONObject expectedData = new JSONObject();

        expectedData.put("bookingid", 24);
        expectedData.put("booking", requestBody);

        //3- Response Kaydet

        Response response = given().contentType(ContentType.JSON)
                                   .when().body(requestBody.toString()).post(url);

        response.prettyPrint();

        // 4- Assertion

        JsonPath responsePath = response.jsonPath();

        // JsonPath de verilere ulasmak icin . kullanlır, JsonObj de objeler arrayler uzerinden erisilir
        assertEquals(expectedData.getJSONObject("booking").get("firstname"), responsePath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"), responsePath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"), responsePath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"), responsePath.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                      responsePath.get("booking.bookingdates.checkin"));



    }



}
