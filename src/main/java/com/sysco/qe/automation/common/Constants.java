package com.sysco.qe.automation.common;

import com.sysco.qe.automation.config.Config;

public class Constants {

    private Constants(){}
    public static final String BASE_URL = Config.getProperty("base.url");
}
