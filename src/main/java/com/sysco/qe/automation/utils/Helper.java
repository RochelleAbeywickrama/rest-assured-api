package com.sysco.qe.automation.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helper {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static String getObjectMapper(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

}
