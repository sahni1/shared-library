

// vars/dockerUtils.groovy
def call(String appName, String awsRegion, String ecrRepoUri, String dockerFileDir) {
    echo "Building and pushing Docker image to ECR"

    // Build the Docker image
    sh "docker build -t ${ecrRepoUri}:${appName} ${dockerFileDir}"

    // Login to AWS ECR
    sh """
    aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrRepoUri}
    """

    // Push the Docker image to AWS ECR
    sh "docker push ${ecrRepoUri}:${appName}"
}
