package com.jaz.utils;

import com.jaz.constants.FrameworkConstant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ReadConfigFile {

    public static Properties properties = new Properties();
    public static Map<String, String> map = new HashMap<>();
    private static final String DEFAULT_PROPERTIES = "configurations/config.properties";

//    public static void initz() throws Exception {
//        try (InputStream fileInputStream = ResourceLoader.getResource(DEFAULT_PROPERTIES))
//        ) {
//            properties = new Properties();
//            properties.load(fileInputStream);
//            properties.entrySet().
//                    stream().
//                    forEach(
//                            el ->
//
//                            {
//                                map.put(String.valueOf(el.getKey()), String.valueOf(el.getValue()));
//                            }
//                    );
//            System.out.println(map);
//
//        } catch (Exception e) {
//
//          //  System.out.println(map);
//           // System.exit(0);
//        }
//
//    }
//public static void initialize(){
//
//    // load default properties
//
//
//    // check for any override
////    for(String key: properties.stringPropertyNames()){
////        if(System.getProperties().containsKey(key)){
////            properties.setProperty(key, System.getProperty(key));
////        }
////    }
//
//    // print
//
//
//
//}
//
//
//    public static String getConfigValue(String key) {
//        if (Objects.isNull(key.toLowerCase())) {
//            throw new RuntimeException("Key Is Invalid , Please enter a valid one");
//        }
//        if (System.getProperties().containsKey(key.toLowerCase())) {
//            return System.getProperty(key.toLowerCase());
//        } else {
//            return map.get(key.toLowerCase());
//        }
//
//    }
//}

    public static void initialize() {

        // load default properties
        properties = loadProperties();

        // check for any override
        for (String key : properties.stringPropertyNames()) {
            if (System.getProperties().containsKey(key)) {
                properties.setProperty(key, System.getProperty(key));
            }
        }

        // print
        System.out.println("Test Properties");
        System.out.println("-----------------");
        for (String key : properties.stringPropertyNames()) {
            System.out.println(key);
            System.out.println(properties.getProperty(key));
        }
        System.out.println("-----------------");

    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {
            properties.load(stream);
        } catch (Exception e) {
            System.out.println("Error");
        }
        return properties;
    }
}