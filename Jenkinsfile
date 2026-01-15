@Library('my-shared-library') _  // Make sure to replace with your actual shared library name

pipeline {
    agent any

    environment {
        AWS_REGION = 'us-east-1'  // Set your AWS region
        ECR_REPO_URI = '123456789012.dkr.ecr.us-east-1.amazonaws.com/my-node-app'  // Replace with your ECR URI
        APP_NAME = 'simple-node-app'  // The name of your app
        DOCKER_FILE_DIR = '.'  // The directory containing your Dockerfile (root directory)
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                checkout scm
            }
        }

        stage('Build & Push Docker Image') {
            steps {
                script {
                    // Using the shared library function to build and push the Docker image to ECR
                    dockerUtils.build_push(APP_NAME, AWS_REGION, ECR_REPO_URI, DOCKER_FILE_DIR)
                }
            }
        }

        stage('Clean Up') {
            steps {
                // Clean up Docker images (optional)
                sh 'docker system prune -f'
            }
        }
    }

    post {
        always {
            steps {
                // Add any post-processing steps here, like cleanup or notifications
                echo "Cleaning up or sending notifications..."
            }
        }
    }
}
