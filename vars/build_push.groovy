// vars/buildAndPushDockerImage.groovy

def call(String appName, String dockerImageName) {
    node {
        stage('Checkout') {
            checkout scm
        }

        stage('Build Docker Image') {
            script {
                com.mycompany.DockerUtils.buildImage(dockerImageName)
            }
        }

        stage('Push Docker Image') {
            script {
                com.mycompany.DockerUtils.pushImage(dockerImageName)
            }
        }
    }
}
