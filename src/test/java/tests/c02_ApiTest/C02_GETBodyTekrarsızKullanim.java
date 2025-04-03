package tests.c02_ApiTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C02_GETBodyTekrarsızKullanim {

    /*
     https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
        donen Response’un,

         status code’unun 200,
         ve content type’inin application-json,
         ve response body’sindeki

         "firstname“in, "Eric",
         ve "lastname“in, "Wilson",
         ve "totalprice“in, 289,
         ve "depositpaid“in, true,
         ve "additionalneeds“in, "Breakfast"

         oldugunu test edin

     */


    @Test
    public void get01() {


        //1-EndPoint hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2- Expected data hazirla

        //3- Response Kaydet

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4-Assertion
        /*

        response.then().assertThat()
                .statusCode(200)
                .contentType("application-json")
                .body("firstname", Matchers.equalTo("Eric"),
                        "lastname", Matchers.equalTo("Wilson"),
                        "totalprice", Matchers.equalTo(289),
                        "depositpaid", Matchers.equalTo(true),
                        "additionalneeds", Matchers.equalTo("Breakfast"));

         */

        response.then().assertThat()            //Her satirda tek tek Matchers import etmeden
                // daha temiz kod icin kullanilan yontem
                .statusCode(200)
                .contentType("application-json")
                .body("firstname", equalTo("Eric"),
                        "lastname", equalTo("Wilson"),
                        "totalprice", equalTo(289),
                        "depositpaid", equalTo(true),
                        "additionalneeds", equalTo("Breakfast"));


    }


}
