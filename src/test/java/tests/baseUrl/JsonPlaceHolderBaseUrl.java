package tests.baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class JsonPlaceHolderBaseUrl {


    // class level da instance veriable olusturulmalı,  RequestSpecification data type'na sahip olmali
    protected RequestSpecification specJsonPlace;

    @BeforeTest
    public void setUp(){

        specJsonPlace = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

    }





}
