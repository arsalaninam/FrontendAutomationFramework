package com.abc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    protected static Properties properties;

    public PropertyReader() {
        try {
            properties = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
                    + "/config/config.properties");
            properties.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
