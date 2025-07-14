/**
 * Utility class for JSON processing using Jackson library.
 * It is licensed under the GNU General Public License v3.0
 *
 * @copyright 2025 OnlyMeCompany
 */
package com.onlymecompany.server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

/**
 * Utility class for JSON processing using Jackson library.
 * Provides methods for parsing, converting, and serializing JSON data.
 */
public class Json {

    /**
     * Singleton instance of ObjectMapper used for JSON operations.
     */
    private static final ObjectMapper objectMapper = defaultObjectMapper();

    /**
     * Configures and returns the default ObjectMapper instance.
     * Sets up the ObjectMapper to ignore unknown properties during deserialization.
     *
     * @return A configured ObjectMapper instance.
     */
    private static ObjectMapper defaultObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }

    /**
     * Parses a JSON string and returns a JsonNode representation.
     *
     * @param json The JSON string to parse.
     * @return A JsonNode representing the parsed JSON.
     * @throws JsonProcessingException If the JSON string cannot be processed.
     */
    public static JsonNode parse(String json) throws JsonProcessingException {
        return objectMapper.readTree(json);
    }

    /**
     * Converts a JSON string into an object of the specified class.
     *
     * @param json  The JSON string to convert.
     * @param clazz The class type to convert the JSON into.
     * @param <A>   The type of the object.
     * @return An object of the specified class.
     * @throws JsonProcessingException If the JSON string cannot be processed.
     */
    public static <A> A fromJson(String json, Class<A> clazz) throws JsonProcessingException {
        return objectMapper.readValue(json, clazz);
    }

    /**
     * Converts an object into a JsonNode representation.
     *
     * @param object The object to convert.
     * @return A JsonNode representing the object.
     * @throws JsonProcessingException If the object cannot be processed.
     */
    public static JsonNode toJson(Object object) throws JsonProcessingException {
        return objectMapper.valueToTree(object);
    }

    /**
     * Serializes a JsonNode into a compact JSON string.
     *
     * @param node The JsonNode to serialize.
     * @return A compact JSON string representation of the JsonNode.
     * @throws JsonProcessingException If the JsonNode cannot be processed.
     */
    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generateJsonString(node, false);
    }

    /**
     * Serializes a JsonNode into a pretty-printed JSON string.
     *
     * @param node The JsonNode to serialize.
     * @return A pretty-printed JSON string representation of the JsonNode.
     * @throws JsonProcessingException If the JsonNode cannot be processed.
     */
    public static String stringifyPretty(JsonNode node) throws JsonProcessingException {
        return generateJsonString(node, true);
    }

    /**
     * Generates a JSON string from an object, with optional pretty-printing.
     *
     * @param object The object to serialize.
     * @param pretty Whether to pretty-print the JSON string.
     * @return A JSON string representation of the object.
     * @throws JsonProcessingException If the object cannot be processed.
     */
    private static String generateJsonString(Object object, boolean pretty) throws JsonProcessingException {
        ObjectWriter ow = objectMapper.writer();
        if (pretty) {
            ow = ow.with(SerializationFeature.INDENT_OUTPUT);
        }
        return ow.writeValueAsString(object);
    }
}