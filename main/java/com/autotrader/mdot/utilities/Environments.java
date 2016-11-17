package com.autotrader.mdot.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by cher1 on 7/11/2015.
 */

// Use this class to get the properties files for environments location
public class Environments {

    Properties prop = null;

    // Constructor
    public Environments() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("target/classes/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the url from the config.properties file
    public String getUrl() {
        return prop.getProperty("pageUrl");
    }

    // Get the vdp form the config.properties file
    public String getVdp() {
        return prop.getProperty("vdpAcura");
    }
}
