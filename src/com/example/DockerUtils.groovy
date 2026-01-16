package com.example

class DockerUtils implements Serializable {
    def steps

    DockerUtils(steps) {
        this.steps = steps
    }

    void buildAndPush(String appName, String awsRegion, String ecrRepoUri, String dockerFileDir) {
        steps.echo "Building and pushing Docker image to ECR"

        // Build Docker image
        steps.sh "docker build -t ${ecrRepoUri}:${appName} ${dockerFileDir}"

        // Login to AWS ECR
        steps.sh """
        aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrRepoUri}
        """

        // Push Docker image
        steps.sh "docker push ${ecrRepoUri}:${appName}"
    }
}
