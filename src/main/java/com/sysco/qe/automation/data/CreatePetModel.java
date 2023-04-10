package com.sysco.qe.automation.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreatePetModel {

    public CreatePetModel() {
    }

    private int id;
    private String name;
    private String status;
    private ArrayList photoUrls;
    private ArrayList tags;
    private Array category;

}


