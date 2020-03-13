package config;

import enums.DriverType;

import static enums.DriverType.*;

public class Configuration {
    public static String url = "https://google.com";
    public static DriverType driverType = FIREFOX;
    public static String screenshotDir = "Screenshots\\";
    public static int explicitWaitTimeOut = 10;
}
