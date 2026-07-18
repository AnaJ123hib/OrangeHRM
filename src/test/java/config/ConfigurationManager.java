package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigurationManager.class
                .getClassLoader()
                .getResourceAsStream("config/config.properties")) {

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}