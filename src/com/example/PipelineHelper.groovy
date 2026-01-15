// src/com/example/PipelineHelper.groovy
package com.example

class PipelineHelper {

    // Function to load configuration based on environment (for example)
    def loadConfig(String env, Closure echo) {
        echo("Loading configuration for environment: ${env}")
        
        // In a real scenario, this might fetch configuration from a file, API, or database
        def config = [
            dev  : [env: 'dev', version: '1.0', team: 'devops'],
            prod : [env: 'prod', version: '2.0', team: 'platform']
        ]
        
        return config[env]
    }

    // Function to greet a person (just an example)
    def greet(String name, Closure echo) {
        echo("Hello, ${name}!")
    }

    // Example of a more complex function (interacting with an external API or system)
    def fetchDataFromAPI(String apiUrl, Closure echo) {
        echo("Fetching data from API: ${apiUrl}")
        // Simulate API response
        return [status: "success", data: "Sample data"]
    }
}
