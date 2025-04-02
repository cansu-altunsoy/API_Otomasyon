package tests.c01_ApiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C04_PUTResponseAssertion {

      /*
       https://jsonplaceholder.typicode.com/posts/70

          url’ine asagidaki Json formatindaki body ile
        bir PUT request gonderdigimizde
        {
         }
         "title": "Ahmet",
         "body": "Merhaba",
         "userId": 10,
         "id": 70
         donen Response’un,

         status code’unun 200,
         ve content type’inin application/json; charset=utf-8,
         ve Server isimli Header’in degerinin cloudflare,
         ve status Line’in HTTP/1.1 200 OK

         oldugunu kontrol ediniz

       */


    @Test
    public void put01() {

        // 1- EndPoint ve request Body hazirlanir

        String url = "https://jsonplaceholder.typicode.com/posts/70";


        JSONObject requestBody = new JSONObject();

        requestBody.put("title", "Ahmet");
        requestBody.put("body", "Merhaba");
        requestBody.put("userId", 10);
        requestBody.put("id", 70);

        // 2- Expected data hazirla

        // 3- Response kaydet

        // Eger bir request body gonderiyor isek body'nin
        // contentType'ni secmek zorundayız (Postman'da JSON sectigimiz gibi)
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .put(url);

        // response.prettyPrint();


        // 4- Assertion islemleri yapilir

        response.then()
                .assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("server", "cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }


}
