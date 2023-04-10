package com.sysco.qe.automation.functions;

import com.sysco.qe.automation.common.CommonApi;
import com.sysco.qe.automation.common.SpecBuilder;
import com.sysco.qe.automation.data.CreatePetModel;
import com.sysco.qe.automation.data.DeletePetModel;
import io.restassured.specification.RequestSpecification;

public class PetStoreService {

    public static CreatePetModel getPetIById(String url, int statusCode, int id){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(url, "", "id", Integer.toString(id));
        return CommonApi.get(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .response()
                .as(CreatePetModel.class);
    }

    public static CreatePetModel createPet(String url, int statusCode, String jsonBody){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(url, jsonBody);
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .response()
                .as(CreatePetModel.class);
    }

    public static CreatePetModel updatePet(String url, int statusCode, String jsonBody){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(url, jsonBody);
        return CommonApi.put(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .response()
                .as(CreatePetModel.class);
    }

    public static DeletePetModel deletePet(String url, int statusCode, int id){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(url, "", "id", Integer.toString(id));
        return CommonApi.delete(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .response()
                .as(DeletePetModel.class);
    }
}
