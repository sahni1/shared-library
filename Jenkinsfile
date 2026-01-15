@Library('my-shared-library1') _  // Load the shared library

pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = "node-app" // Name of your Docker image
        ECR_REPOSITORY_URI = "701532066975.dkr.ecr.ap-south-1.amazonaws.com/node-app/new" // Your ECR repository URI
        AWS_REGION = "ap-south-1" // Your AWS region
        AWS_CREDENTIALS_ID = "credentialsId" // AWS credentials ID in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm  // Checkout the latest code
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'npm install'  // Install app dependencies
            }
        }

        stage('Run Tests') {
            steps {
                sh 'npm test'  // Run tests
            }
        }

        stage('Build and Push Docker Image to ECR') {
            steps {
                // Use the shared library function to build and push the image to ECR
                buildAndPushDockerImage(DOCKER_IMAGE_NAME, ECR_REPOSITORY_URI, AWS_REGION, AWS_CREDENTIALS_ID)
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after the build
        }
    }
}
