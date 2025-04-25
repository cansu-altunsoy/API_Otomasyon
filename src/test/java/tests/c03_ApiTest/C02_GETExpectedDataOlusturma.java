package tests.c03_ApiTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C02_GETExpectedDataOlusturma {

    /*
         https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
            yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test
            ediniz
             Response body :
             {
             "userId":3,
             "id":22,
             "title":"dolorsintquoavelitexplicaboquianam",
             "body":"eosquietipsumipsamsuscipitaut\nsedomnisnonodio\nexpeditaear
            ummollitiamolestiaeautatqueremsuscipit\nnamimpeditesse"
          }
     */


    @Test
    public void getExpectedData01() {

        //1- Endpoind ve request body hazirla

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        //2- Expected Data hazirla

        JSONObject expectedData = new JSONObject();

        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolorsintquoavelitexplicaboquianam");
        expectedData.put("body", "eosquietipsumipsamsuscipitaut\nsedomnisnonodio\nexpeditaear ummollitiamolestiaeautatqueremsuscipit\nnamimpeditesse");

        System.out.println("expected Data :" + expectedData); // Expected data cıktısı

        //3- Response degerini kaydet

        Response response = given().when().get(url);

        //response.prettyPrint(); // Donen response cıktısı

        response.prettyPeek(); // Response ile ilgili tum degerleri dondurur, detaylı olarak herseyi dondurur


        // 4 - Assertion (junit ile yapıyoruz burda) jsonpath kutuphanesinden

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.get("userId"), responseJsonPath.get("userId"));
        Assert.assertEquals(expectedData.get("id"), responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"), responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"), responseJsonPath.get("body"));


    }


}
