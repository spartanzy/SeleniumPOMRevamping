package Utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configManager {

    private static final Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream(".\\src\\main\\java\\Utility\\config.properties"));
        } catch (IOException ignored) {
		}
    }

    public static String getUsername() {
        return getValue("TEST_USER_EMAIL", "username");
    }

    public static String getPassword() {
        return getValue("TEST_USER_PASSWORD", "password");
    }

    private static String getValue(String envKey, String propKey) {
        String envValue = System.getenv(envKey);
        if (envValue != null && !envValue.isEmpty()) return envValue;

        String propValue = props.getProperty(propKey);
        if (propValue != null && !propValue.isEmpty()) return propValue;

        throw new RuntimeException("Missing value for " + envKey + "/" + propKey);
    }
}
