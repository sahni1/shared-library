@Library('my-shared-library') _  // Make sure to replace with your actual shared library name

pipeline {
    agent any

    environment {
        AWS_REGION = 'ap-south-1'  // Set your AWS region
        ECR_REPO_URI = '701532066975.dkr.ecr.ap-south-1.amazonaws.com/node-app/new'  // Replace with your ECR URI
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
            // Any post-processing steps can be added here
        }
    }
}
