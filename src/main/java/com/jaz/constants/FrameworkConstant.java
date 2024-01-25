package com.jaz.constants;

public class FrameworkConstant {

    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/configurations/config.properties";

    public static final String SELENIUM_GRID_URL_FORMAT = "selenium.grid.urlformat";
    public static final String SELENIUM_HUB = "selenium.hub";
    public static final String BROWSER = "browser";
    public static final String SELENIUM_GRID_ENABLED = "selenium.grid.enabled";
    public static final String APPLICATION_URL = "url";

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

}
