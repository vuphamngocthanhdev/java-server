package com.onlymecompany.server;

import com.onlymecompany.server.config.Configuration;
import com.onlymecompany.server.config.ConfigurationManager;

import java.io.IOException;

public class SimpleServerApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting Simple Server Application...");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getCurrentConfiguration();
        System.out.println("Server started with port: " + conf.getPort());
        System.out.println("Server started with webRoot: " + conf.getWebRoot());
    }
}
