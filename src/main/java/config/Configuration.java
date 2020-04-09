package config;

import enums.DriverType;

import static enums.DriverType.CHROME;

public final class Configuration {
    public static final String url = "https://www.softserveinc.com/uk-ua";
    public static final String screenshotDir = "Screenshots\\";
    public static final String webDriverName = "chromedriver";

    public static final DriverType driverType = CHROME;

    public static final int implicitWaitTimeOut = 3;
    public static final int explicitWaitTimeOut = 3;
    public static final int ajaxWaitTimeOut = 15;
}
