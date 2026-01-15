def call(String appName, String dockerImageName) {
    node {
        stage('Checkout') {
            checkout scm
        }

        stage('Build Docker Image') {
            sh "docker build -t ${dockerImageName} ."
        }

        stage('Push Docker Image') {
            withDockerRegistry([credentialsId: 'dockerhub-credentials', url: 'https://index.docker.io/v1/']) {
                sh "docker push ${dockerImageName}"
            }
        }
    }
}
