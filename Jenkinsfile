@Library('my-shared-library') _

pipeline {
    agent any

    stages {
        stage('Load Config') {
            steps {
                script {
                    // Load environment configuration using the helper class in src/
                    def config = jenkins.loadEnvironmentConfig('dev')  // This calls the method in jenkins.groovy which calls src/com/example/PipelineHelper.groovy
                    echo "Loaded config: ${config}"
                }
            }
        }

        stage('Greeting') {
            steps {
                script {
                    // Call the greet method (using the helper class)
                    jenkins.greet("Alice")  // This calls the greet function from PipelineHelper
                }
            }
        }

        stage('Fetch API Data') {
            steps {
                script {
                    // Fetch data from API (using the helper class)
                    def apiData = jenkins.fetchAPIData("https://example.com/api")
                    echo "API Data: ${apiData}"
                }
            }
        }
    }
}
