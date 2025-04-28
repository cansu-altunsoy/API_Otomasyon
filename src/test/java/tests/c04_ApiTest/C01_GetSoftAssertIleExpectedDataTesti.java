package tests.c04_ApiTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C01_GetSoftAssertIleExpectedDataTesti {

    /*

       http://dummy.restapiexample.com/api/v1/employee/3   url’ine bir GET request
        gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
         Response Body
         {
         }
         "status": "success",
         "data": {
         "id": 3,
         "employee_name": "Ashton Cox",
         "employee_salary": 86000,
         "employee_age": 66,
         "profile_image": ""
         },
         "message": "Successfully! Record has been fetched."

     */


    @Test
     public void get01(){

        // 1- Url hazirla

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";


        // 2- Expected Data hazirla

        JSONObject innerData = new JSONObject();

        innerData.put("id", 3);
        innerData.put("employee_name", "Ashton Cox");
        innerData.put("employee_salary", 86000);
        innerData.put("employee_age", 66);
        innerData.put("profile_image", "");


        JSONObject expectedData = new JSONObject();

        expectedData.put("status","success");
        expectedData.put("data", innerData);
        expectedData.put("message", "Successfully! Record has been fetched.");


        // 3- Response kaydetme

        Response response = given().when().get(url);

        response.prettyPrint(); // response gormek icin yazıyoruz


        // 4- Assertion

        SoftAssert softAssert = new SoftAssert();

        // Bize donen response degerlerinin icine girmek ve degerleri kullana bilmek icin
       // donen degerleri JSONPath'e donusturup o sekilde kullanabiliriz

       JsonPath responsPath = response.jsonPath(); // Response degerleri donusturuyoruz
        softAssert.assertEquals(responsPath.get("status"), expectedData.get("status"));
        softAssert.assertEquals(responsPath.get("message"), expectedData.get("message"));
        softAssert.assertEquals(responsPath.get("data.id"), expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responsPath.get("data.employee_name"), expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responsPath.get("data.employee_salary"), expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responsPath.get("data.employee_age"), expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responsPath.get("data.profile_image"), expectedData.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();

    }

}
