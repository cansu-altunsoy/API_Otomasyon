package tests.c05_ApiTest;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.testData.TestDataJsonPlace;
import static io.restassured.RestAssured.given;


public class C01_GETTestDataClassKullanimi extends tests.baseUrl.JsonPlaceHolderBaseUrl {

        /*
            https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
            yolladigimizda donen response’in status kodunun 200 ve response body’sinin
            asagida verilen ile ayni oldugunutest ediniz

             Response body : ==> Expected Data
             {
             "userId":3,
             "id":22,
             "title":"dolorsintquoavelitexplicaboquianam",
             "body":"eosquietipsumipsamsuscipitaut\nsedomnisnonodio\nexpeditaear
            ummollitiamolestiaeautatqueremsuscipit\nnamimpeditesse"
             }
         */


    @Test
    public void get01(){

        // 1- Url hazirla

        specJsonPlace.pathParams("pp1", "posts", "pp2", 22);

        // 2- Expected Data hazirla
        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();

          JSONObject expectedData = testDataJsonPlace.expectedDataOlusturJSON();

        // 3- Response Kaydet

        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        // 4- Assertion

        JsonPath responseJson = response.jsonPath();

        Assert.assertEquals(testDataJsonPlace.basariliStatusCode, response.getStatusCode());

        Assert.assertEquals(expectedData.get("userId"), responseJson.get("userId"));
        Assert.assertEquals(expectedData.get("id"), responseJson.get("id"));
        Assert.assertEquals(expectedData.get("title"), responseJson.get("title"));
        Assert.assertEquals(expectedData.get("body"), responseJson.get("body"));



    }

}
