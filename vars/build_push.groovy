// Docker utility functions to build and push to ECR

def buildAndPushToECR(String appName, String awsRegion, String ecrRepoUri, String dockerFileDir) {
    // Authenticate Docker to AWS ECR
    withAWS(region: awsRegion) {
        sh "aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrRepoUri}"
    }

    // Build the Docker image
    sh "docker build -t ${ecrRepoUri}:${appName} ${dockerFileDir}"

    // Tag the image to match the ECR repo URI
    sh "docker tag ${ecrRepoUri}:${appName} ${ecrRepoUri}:${appName}"

    // Push the image to the ECR repository
    sh "docker push ${ecrRepoUri}:${appName}"
}

return this
