package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties props;

    static  {
        try {
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            props = new Properties();
            props.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                }
                catch (IOException e)   {
                    e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key)    {
        return props.getProperty(key);
    }
}
