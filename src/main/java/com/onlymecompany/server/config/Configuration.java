/**
 * This file is part of the OnlyMeCompany Server project.
 * It is licensed under the GNU General Public License v3.0.
 *
 * @copyright 2025 OnlyMeCompany
 */
package com.onlymecompany.server.config;

/**
 * Represents the configuration settings for the server.
 * This class contains properties for the server's port and web root directory.
 */
public class Configuration {
    /**
     * The port number on which the server will run.
     */
    private String port;

    /**
     * The root directory for the server's web files.
     */
    private String webRoot;

    /**
     * Retrieves the port number for the server.
     *
     * @return The port number as a String.
     */
    public String getPort() {
        return port;
    }

    /**
     * Retrieves the web root directory for the server.
     *
     * @return The web root directory as a String.
     */
    public String getWebRoot() {
        return webRoot;
    }
}