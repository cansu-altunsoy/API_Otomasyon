package tests.c02_ApiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_POSTResponseBodyTesti {


      /*
      https://jsonplaceholder.typicode.com/posts
          url’ine asagidaki body ile bir POST request
            gonderdigimizde

             {
             "title":"API",
             "body":"API ogrenmek ne guzel",
             "userId":10,
             }

             donen Response’un,

             status code’unun 201,
             ve content type’inin application/json
             ve Response Body'sindeki,
             "title"'in "API" oldugunu
             "userId" degerinin 100'den kucuk oldugunu
             "body" nin "API" kelimesi icerdigini
             test edin.

       */

    @Test
    public void post01() {

        // EndPoint ve request Body olusturalim

        String url = "  https://jsonplaceholder.typicode.com/posts";

        JSONObject postRequestBody = new JSONObject();

        postRequestBody.put("title", "API");
        postRequestBody.put("body", "API ogrenmek ne guzel");
        postRequestBody.put("userId", 10);

        System.out.println("postRequestBody = " + postRequestBody);


        // Expected data hazirlanir

        // Response kaydedelim

        Response response = given().contentType(ContentType.JSON)
                .when().body(postRequestBody.toString()).post(url);

        //response.prettyPrint();


        // Assertion

        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", Matchers.equalTo("API"))
                .body("userId", Matchers.lessThan(100))
                .body("body", Matchers.containsString("API"));


    }


}
