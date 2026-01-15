// Jenkinsfile

@Library('shared-library') _  // Load the shared library

pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = "your-dockerhub-username/my-node-app"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'npm install'  // Install app dependencies
            }
        }

        stage('Run Tests') {
            steps {
                sh 'npm test'  // Run your tests (adjust if using another testing framework)
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                buildAndPushDockerImage('node-app', env.DOCKER_IMAGE_NAME)
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after the build
        }
    }
}
