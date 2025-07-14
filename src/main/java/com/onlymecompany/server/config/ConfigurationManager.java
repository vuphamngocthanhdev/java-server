/**
 * It is responsible for managing the server's configuration settings.
 * It is licensed under the GNU General Public License v3.0.
 *
 * @copyright 2025 OnlyMeCompany
 */
package com.onlymecompany.server.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.onlymecompany.server.util.Json;

import java.io.FileReader;
import java.io.IOException;

/**
 * ConfigurationManager is a singleton class responsible for managing the configuration
 * of the server. It provides methods to retrieve and update the current configuration.
 * This class ensures that there is only one instance of ConfigurationManager throughout
 * the application, adhering to the Singleton design pattern.
 */
public class ConfigurationManager {

    /**
     * The singleton instance of ConfigurationManager.
     * This static variable holds the single instance of the class.
     */
    private static ConfigurationManager instance;

    /**
     * The current configuration of the server.
     * This static variable stores the configuration details.
     */
    private static Configuration currentConfiguration;

    public ConfigurationManager() {
    }

    /**
     * Retrieves the singleton instance of the ConfigurationManager.
     * If the instance does not already exist, it initializes a new ConfigurationManager.
     *
     * @return The singleton instance of ConfigurationManager.
     */

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    /**
     * Retrieves the current configuration of the server.
     * Throws an IllegalStateException if the configuration has not been initialized.
     *
     * @return The current configuration of the server.
     * @throws IllegalStateException If the current configuration is not initialized.
     */
    public static Configuration getCurrentConfiguration() {
        if (currentConfiguration == null) {
            throw new IllegalStateException("Current configuration is not initialized");
        }
        return currentConfiguration;
    }

    /**
     * Loads the server configuration from a specified file.
     * Reads the file content, parses it as JSON, and converts it into a Configuration object.
     *
     * @param filePath The path to the configuration file.
     * @throws IOException If an error occurs while reading or processing the file.
     */
    public void loadConfigurationFile(String filePath) throws IOException {
        int i;
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(filePath)) {
            while ((i = fileReader.read()) != -1) {
                sb.append((char) i);
            }
            JsonNode conf = Json.parse(sb.toString());
            currentConfiguration = Json.fromJson(Json.stringify(conf), Configuration.class);
        } catch (IOException e) {
            throw new IOException("Error loading configuration file: " + filePath, e);
        }
    }
}