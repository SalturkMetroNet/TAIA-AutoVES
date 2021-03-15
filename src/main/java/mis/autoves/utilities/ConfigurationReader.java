package mis.autoves.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader
{
    private static Properties properties;

    static
    {
        try (FileInputStream fileInputStream = new FileInputStream("configuration.properties"))
        {
            properties = new Properties();
            properties.load(fileInputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    public static String getProperty(String keyName)
    {
        return properties.getProperty(keyName);
    }
}


