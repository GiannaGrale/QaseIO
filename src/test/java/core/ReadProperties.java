package core;

import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
    private static ReadProperties instance;
    protected static Properties properties;

    private ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    public String getURL() {
        return properties.getProperty("url");
    }

    public String getBrowserName() {
        return properties.getProperty("browser");
    }

    public boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public String getProject() { return  properties.getProperty("project").toUpperCase(); }

    public String getToken() {
        return properties.getProperty("token");
    }

    public String getPicture() {
        return properties.getProperty("picture");
    }

    public int getDefectID() { return Integer.parseInt(properties.getProperty("defectID")); }

    public int getRunID() { return Integer.parseInt(properties.getProperty("runID")); }

    public String getMilestoneTitle() {
        return properties.getProperty("milestone");
    }

    public String getSuiteTitle() {
        return properties.getProperty("suite");
    }

    public String getRole() {
        return properties.getProperty("role");
    }
}
