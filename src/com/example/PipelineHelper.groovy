// src/com/example/PipelineHelper.groovy

package com.example

class PipelineHelper {

    // Example method to load config
    def loadConfig(String environment) {
        // Logic to load configuration based on environment
        return "Configuration for ${environment} environment loaded."
    }

    // Example method to greet someone
    def greet(String name) {
        return "Hello, ${name}!"
    }

    // Example method to fetch data from an API
    def fetchDataFromAPI(String apiUrl) {
        // Logic to fetch API data (stubbed response here)
        return "Data fetched from API: ${apiUrl}"
    }
}
