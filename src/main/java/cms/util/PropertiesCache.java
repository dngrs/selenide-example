package cms.util;

import cms.pages.uielements.Language;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class PropertiesCache {

    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final PropertiesCache INSTANCE = new PropertiesCache();
    private final Properties configProp = new Properties();
    private final String language = System.getProperty("lg", Language.RU.name().toLowerCase());

    private PropertiesCache() {
        LOG.info("Read all properties from file");
        InputStream property = this.getClass().getClassLoader().getResourceAsStream(language + "-test.properties");
        try {
            configProp.load(property);
        } catch (IOException e) {
            LOG.error("Cann't read all properties from file. Exception: " + e);
        }
    }

    public static String getProperty(String key) {
        return INSTANCE.configProp.getProperty(key);
    }

}
