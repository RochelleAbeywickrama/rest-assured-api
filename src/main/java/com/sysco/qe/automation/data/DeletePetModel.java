package com.sysco.qe.automation.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DeletePetModel {

    public DeletePetModel() {
    }

    private int code;
    private String type;
    private String message;

}


