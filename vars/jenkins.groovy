// vars/jenkins.groovy

// Function to load environment config by calling the PipelineHelper class
def loadEnvironmentConfig(String environment) {
    echo "Loading environment config for: ${environment}"
    def helper = new com.example.PipelineHelper()
    return helper.loadConfig(environment)  // Calls the helper's loadConfig method
}

// Function to greet a person (just an example)
def greet(String name) {
    echo "Calling greet function for: ${name}"
    def helper = new com.example.PipelineHelper()
    helper.greet(name)  // Calls the helper's greet method
}

// Example function to interact with an API using the helper class
def fetchAPIData(String apiUrl) {
    echo "Fetching API data from: ${apiUrl}"
    def helper = new com.example.PipelineHelper()
    return helper.fetchDataFromAPI(apiUrl)  // Calls the helper's fetchDataFromAPI method
}
