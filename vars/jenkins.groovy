// vars/jenkins.groovy

// Function to load environment config by calling the PipelineHelper class
def loadEnvironmentConfig(String environment) {
    // Instantiate the helper class
    def helper = new com.example.PipelineHelper()
    return helper.loadConfig(environment)  // Use the helper method to load the config
}

// Function to greet a person
def greet(String name) {
    def helper = new com.example.PipelineHelper()
    helper.greet(name)
}

// Example function to interact with an API using the helper class
def fetchAPIData(String apiUrl) {
    def helper = new com.example.PipelineHelper()
    return helper.fetchDataFromAPI(apiUrl)
}
