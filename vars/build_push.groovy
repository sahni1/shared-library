def call(String appName, String ecrRepositoryUri, String awsRegion, String awsCredentialsId) {
    node {
        stage('Checkout') {
            checkout scm
        }

        stage('Authenticate with AWS ECR') {
            script {
                // Authenticate to AWS ECR
                withCredentials([string(credentialsId: awsCredentialsId, variable: 'AWS_ACCESS_KEY_ID'),
                                 string(credentialsId: awsCredentialsId, variable: 'AWS_SECRET_ACCESS_KEY')]) {
                    sh """
                        aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${awsRegion}.amazonaws.com
                    """
                }
            }
        }

        stage('Build Docker Image') {
            script {
                // Use DockerUtils to build the Docker image
                com.example.DockerUtils.buildImage(appName)
            }
        }

        stage('Tag Docker Image') {
            script {
                // Use DockerUtils to tag the Docker image
                com.example.DockerUtils.tagImage(appName, ecrRepositoryUri)
            }
        }

        stage('Push Docker Image to ECR') {
            script {
                // Use DockerUtils to push the Docker image to ECR
                com.example.DockerUtils.pushImage(ecrRepositoryUri, appName)
            }
        }
    }
}
