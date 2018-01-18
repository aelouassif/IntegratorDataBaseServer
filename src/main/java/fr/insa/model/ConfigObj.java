package fr.insa.model;

import org.hibernate.cfg.Configuration;

public class ConfigObj {
    private static Configuration configObj;
    private ConfigObj(){

    }

    public static Configuration getConfigObj() {
        if(configObj != null)
            return configObj;
        else{
            configObj = new Configuration().configure("hibernate.cfg.xml");
            return configObj;
        }
    }

    public static void setConfigObj(Configuration configObj) {
        ConfigObj.configObj = configObj;
    }
}
