@Library('my-shared-library') _  // Reference the shared library

pipeline {
    agent any  // You can specify a specific agent here if needed

    environment {
        AWS_REGION = 'ap-south-1'      // AWS region where ECR is hosted
        ECR_REPO_URI = '701532066975.dkr.ecr.ap-south-1.amazonaws.com/node-app/new'  // ECR repository URI
        APP_NAME = 'node-app'      // Docker image name (you can dynamically fetch this from the app)
        DOCKER_FILE_DIR = '.'         // Directory where Dockerfile is located (usually the root of the repo)
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the SCM
                checkout scm
            }
        }

        stage('Build & Push Docker Image') {
            steps {
                script {
                    // Call the dockerUtils function from the shared library to build and push the image
                    dockerUtils(APP_NAME, AWS_REGION, ECR_REPO_URI, DOCKER_FILE_DIR)
                }
            }
        }
    }

    post {
        always {
            echo "Cleaning up..."
            // Cleanup steps like deleting workspace, etc.
            deleteDir()
        }

        success {
            echo "Build and push completed successfully."
        }

        failure {
            echo "Build or push failed."
        }
    }
}
