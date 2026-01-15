// Jenkinsfile

@Library('my-shared-library') _  // Load the shared library

pipeline {
    agent any

    stages {
        stage('Load Config') {
            steps {
                script {
                    // This calls loadEnvironmentConfig('dev') from vars/jenkins.groovy
                    def config = jenkins.loadEnvironmentConfig('dev')  
                    echo "Loaded config: ${config}"
                }
            }
        }

        stage('Greeting') {
            steps {
                script {
                    // This calls greet('Alice') from vars/jenkins.groovy
                    jenkins.greet("Alice")
                }
            }
        }

        stage('Fetch API Data') {
            steps {
                script {
                    // This calls fetchAPIData() from vars/jenkins.groovy
                    def apiData = jenkins.fetchAPIData("https://example.com/api")
                    echo "API Data: ${apiData}"
                }
            }
        }
    }
}
