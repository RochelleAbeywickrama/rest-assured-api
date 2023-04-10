package com.sysco.qe.automation.common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.sysco.qe.automation.common.Constants.BASE_URL;

public class SpecBuilder {

    public static RequestSpecification requestSpecificationBuilder() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setAccept(ContentType.JSON)
                .build();
        return requestSpec;
    }

    public static RequestSpecification requestSpecificationBuilder(String url,String jsonBody) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(url)
                .setAccept(ContentType.JSON)
                .setBody(jsonBody)
                .build();
        return requestSpec;
    }

    public static RequestSpecification requestSpecificationBuilder(String url,String jsonBody, String pathParamName, String pathParam) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(url)
                .setAccept(ContentType.JSON)
                .setBody(jsonBody)
                .addPathParam(pathParamName, pathParam)
                .build();
        return requestSpec;
    }

}