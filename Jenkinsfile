@Library('my-shared-library') _ 

pipeline {
    agent any
    
    stages {
        stage('Load Properties') {
            steps {
                script {
                    def props = [:]
                    def propsFile = libraryResource('config.properties') 
                    
                    propsFile.eachLine { line ->
                        if (line.trim()) {  
                            def (key, value) = line.split('=')
                            props[key.trim()] = value.trim()
                        }
                    }
                    
                    echo "Loaded properties: ${props}"
                }
            }
        }
        
        stage('Greeting') {
            steps {
                script {
                    greet("Alice")  
                }
            }
        }
    }
}
