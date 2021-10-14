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

    // Методы получения property
    public String getURL() {
        return properties.getProperty("url");
    }

    public String getMilestoneURL(){
        return  properties.getProperty("urlMilestone");
    }

    public String getUsersURL(){
        return  properties.getProperty("urlUsers");
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

    public String getToken() {
        return properties.getProperty("token");
    }
}
