// package com.example

// class DockerUtils {

//     // Method to authenticate to AWS ECR
//     static void authenticateECR(String awsRegion, String awsCredentialsId) {
//         // Use Jenkins' AWS credentials plugin to retrieve the credentials
//         withCredentials([aws(credentialsId: awsCredentialsId, region: awsRegion)]) {
//             // Run AWS CLI to authenticate to the ECR
//             sh "aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrRepositoryUri}"
//         }
//     }

//     // Method to build the Docker image
//     static void buildImage(String dockerImageName) {
//         sh "docker build -t ${dockerImageName} ."
//     }

//     // Method to tag the Docker image
//     static void tagImage(String dockerImageName, String ecrRepositoryUri) {
//         sh "docker tag ${dockerImageName} ${ecrRepositoryUri}:${dockerImageName}"
//     }

//     // Method to push the Docker image to ECR
//     static void pushImage(String ecrRepositoryUri, String dockerImageName) {
//         sh "docker push ${ecrRepositoryUri}:${dockerImageName}"
//     }
// }
