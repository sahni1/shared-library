// vars/jenkins.groovy

// Function to load environment config by calling the PipelineHelper class
def loadEnvironmentConfig(String environment) {
    def helper = new com.example.PipelineHelper()
    return helper.loadConfig(environment, echo)  // Pass echo here
}

// Function to greet a person (just an example)
def greet(String name) {
    def helper = new com.example.PipelineHelper()
    helper.greet(name, echo)  // Pass echo here
}

// Example function to interact with an API using the helper class
def fetchAPIData(String apiUrl) {
    def helper = new com.example.PipelineHelper()
    return helper.fetchDataFromAPI(apiUrl, echo)  // Pass echo here
}
