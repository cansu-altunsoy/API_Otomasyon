package tests.c04_ApiTest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C02_PutSoftAssertExpectedData {

    /*
      http://dummy.restapiexample.com/api/v1/update/21  url’ine asagidaki body’ye sahip bir PUT
            request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

             Request Body

             {
             }
             "status": "success",
             "data": {

             "name": “Ahmet",
             "salary": "1230",
             "age": "44",
             "id": 40
                 }

             Response Body

             { "status": "success",
             "data": {

             "status": "success",
             "data": {
             "name": “Ahmet",
             "salary": "1230",
             "age": "44",
             "id": 40
               }

             },
             "message": "Successfully! Record ha
             s been updated."}

     */


    @Test
    public void put01() {

        // 1- Url ve Request Body hazirla

        String url = " http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject innerData = new JSONObject();

        innerData.put("name", "Ahmet");
        innerData.put("salary", "1230");
        innerData.put("age", "44");
        innerData.put("id", 40);


        JSONObject requestData = new JSONObject();

        requestData.put("status", "success");
        requestData.put("data", innerData);


        // 2- Expected Data hazirlama


        JSONObject expectedData = new JSONObject();

        expectedData.put("status", "success");
        expectedData.put("data", requestData);
        expectedData.put("message", "Successfully! Record has been updated.");


        // 3- Response kaydet

        Response response = given().contentType(ContentType.JSON).when().body(requestData.toString()).put(url);
        response.prettyPrint();


        // 4- Assertion

        SoftAssert softAssert = new SoftAssert();

        JsonPath responsePath = response.jsonPath();

        softAssert.assertEquals(responsePath.get("status"), expectedData.get("status"));
        softAssert.assertEquals(responsePath.get("message"), expectedData.get("message"));
        softAssert.assertEquals(responsePath.get("data.data.name"), expectedData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responsePath.get("data.data.salary"), expectedData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(responsePath.get("data.data.age"), expectedData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(responsePath.get("data.data.id"), expectedData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(responsePath.get("data.status"), expectedData.getJSONObject("data").get("status"));

        softAssert.assertAll();


    }

}
