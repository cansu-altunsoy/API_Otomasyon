package tests.c01_ApiTest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C01_GETApiSorgulama {

     /*
       https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
         status code’unun 200,
         ve content type’inin application/json; charset=utf-8,
         ve Server isimli Header’in degerinin Cowboy,
         ve status Line’in HTTP/1.1 200 OK
         ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */


     /*
      Tüm API sorguları 4 aşamada yapılır
        1-EndPonit hazırlanır(url ve varsa(PUT-POST-PATCH) request Body hazırlanır)
        2-Soruda verilmiş ise Expected Data hazırlanır. Verilmemişse hazırlanmaz
        3-Dönen cevap kaydedilir
        4-Assertion işlemleri yapılır

     */

    @Test
    public void get01() {

        // 1-EndPonit hazırlanır(url ve varsa(PUT-POST-PATCH) request Body hazırlanır)

        String url = "  https://restful-booker.herokuapp.com/booking/10";

        // 2-Soruda verilmiş ise Expected Data hazırlanır. Verilmemişse hazırlanmaz


        // 3-Bize donen Response'i  Actual Data olarak kaydedilir

        Response response = given().when().get(url);

        // response.prettyPrint(); // Donen response yazdirmak icin kullanlan komut

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Content Type : " + response.getContentType());
        System.out.println("Server Header Degeri  : " + response.getHeader("Server"));
        System.out.println("Response Suresi : " + response.getTime());
        System.out.println("Status Line : " + response.getStatusLine());


    }


}
