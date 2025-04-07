package tests.c03_ApiTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C01_GETResponseBodyTEstListKullanimi {

    /*
    http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request
        yolladigimizda
         donen Response'in

         status code'unun 200,
         ve content type'inin Aplication.JSON,

         ve response body'sindeki
         employees sayisinin 24
         ve employee'lerden birinin "Ashton Cox"
         ve girilen yaslar icinde 61,21 ve 35

         degerinin oldugunu test edin
         test edin.
     */

    @Test
    public void get01(){

        // 1- Endpoint ve request body hazirla

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        //2- Expected data hazirlanir

        //3- Response kaydet

        Response response = given().when().get(url);

        response.prettyPrint();

        //4- Assertion

        response.then().assertThat().statusCode(200)
                .contentType("Aplication.JSON")
                .body("data.id", hasSize(24),
                        "data.emloyee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(61,21,35));

    }


























}
