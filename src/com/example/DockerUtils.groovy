// src/com/mycompany/DockerUtils.groovy

package com.mycompany

class DockerUtils {
    // Method to build the Docker image
    static void buildImage(String dockerImageName) {
        sh "docker build -t ${dockerImageName} ."
    }

    // Method to push the Docker image
    static void pushImage(String dockerImageName) {
        withDockerRegistry([credentialsId: 'dockerhub-credentials', url: 'https://index.docker.io/v1/']) {
            sh "docker push ${dockerImageName}"
        }
    }
}
