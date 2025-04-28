package tests.baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class HerokuAppBaseUrl {



    protected RequestSpecification specHerokuAppUrl;


    @BeforeTest
    public void setUp(){

        specHerokuAppUrl = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }




}
