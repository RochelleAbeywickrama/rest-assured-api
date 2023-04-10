package com.sysco.qe.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static String configFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";

    public static final String CREATE_PET_PATH = "/pet";
    public static final String UPDATE_PET_PATH = "/pet";
    public static final String VIEW_PET_PATH = "/pet/{id}";
    public static final String DELETE_PET_PATH = "/pet/{id}";
    private static Properties properties = null;

    public static void loadProperties() {
        properties = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(configFilePath);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (properties == null)
            loadProperties();
        String p = System.getProperty(key);
        return p != null ? p : properties.getProperty(key);
    }
}
