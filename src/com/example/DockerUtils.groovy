package com.example

class DockerUtils {

    // Method to build the Docker image
    static void buildImage(String dockerImageName) {
        sh "docker build -t ${dockerImageName} ."
    }

    // Method to tag the Docker image
    static void tagImage(String dockerImageName, String ecrRepositoryUri) {
        sh "docker tag ${dockerImageName} ${ecrRepositoryUri}:${dockerImageName}"
    }

    // Method to push the Docker image to ECR
    static void pushImage(String ecrRepositoryUri, String dockerImageName) {
        sh "docker push ${ecrRepositoryUri}:${dockerImageName}"
    }
}
