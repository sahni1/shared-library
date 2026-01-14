@Library('my-shared-library') 
pipeline {
    agent any
    environment {
        SERVER_URL = libraryResource('config.properties')
        CONFIG = readProperties(text: SERVER_URL)
    }
    stages {
        stage('Greeting') {
            steps {
                script {
                    greet("Alice")  
                }
            }
        }
        stage('Logging') {
            steps {
                script {
                    logMessage("This is a log message.")  
                }
            }
        }
        stage('Calculation') {
            steps {
                script {
                    def utility = new com.example.Utility()  
                    def sum = utility.addNumbers(5, 3)  
                    echo "Sum of 5 and 3 is: ${sum}"
                }
            }
        }
        stage('Goodbye') {
            steps {
                script {
                    bye("Bob")  
                }
            }
        }
    }
}
