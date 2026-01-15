// vars/buildAndPushDockerImage.groovy

def call(String appName, String ecrRepositoryUri, String awsRegion, String awsCredentialsId) {
    node {
        stage('Checkout') {
            checkout scm
        }

        stage('Authenticate with AWS ECR') {
            script {
                // Authenticate to AWS ECR
                com.mycompany.DockerUtils.authenticateECR(awsRegion, awsCredentialsId)
            }
        }

        stage('Build Docker Image') {
            script {
                // Build Docker image
                com.mycompany.DockerUtils.buildImage(appName)
            }
        }

        stage('Tag Docker Image') {
            script {
                // Tag the Docker image with the ECR repository URI
                com.mycompany.DockerUtils.tagImage(appName, ecrRepositoryUri)
            }
        }

        stage('Push Docker Image to ECR') {
            script {
                // Push the Docker image to ECR
                com.mycompany.DockerUtils.pushImage(ecrRepositoryUri, appName)
            }
        }
    }
}
