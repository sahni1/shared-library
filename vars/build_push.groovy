def call(String appName, String ecrRepositoryUri, String awsRegion, String awsCredentialsId) {
    node {
        stage('Checkout') {
            checkout scm
        }

        stage('Authenticate with AWS ECR') {
            script {
                com.example.DockerUtils.authenticateECR(awsRegion, awsCredentialsId)
            }
        }

        stage('Build Docker Image') {
            script {
                com.example.DockerUtils.buildImage(appName)
            }
        }

        stage('Tag Docker Image') {
            script {
                com.example.DockerUtils.tagImage(appName, ecrRepositoryUri)
            }
        }

        stage('Push Docker Image to ECR') {
            script {
                com.example.DockerUtils.pushImage(ecrRepositoryUri, appName)
            }
        }
    }
}
