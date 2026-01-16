// vars/jenkins.groovy
def call(boolean runPipeline = true) {
    if (!runPipeline) return

    pipeline {
        agent any

        environment {
            AWS_REGION = 'ap-south-1'
            ECR_REPO_URI = '701532066975.dkr.ecr.ap-south-1.amazonaws.com/node-app/new'
            APP_NAME = 'node-app'
            DOCKER_FILE_DIR = '.'
        }

        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Build & Push Docker Image') {
                steps {
                    script {
                        // Instantiate the package-based class
                        def dockerUtils = new com.example.DockerUtils(this)
                        dockerUtils.buildAndPush(
                            env.APP_NAME,
                            env.AWS_REGION,
                            env.ECR_REPO_URI,
                            env.DOCKER_FILE_DIR
                        )
                    }
                }
            }
        }

        post {
            always {
                echo "Cleaning up..."
                deleteDir()
            }
            success {
                echo "Build and push completed successfully."
            }
            failure {
                echo "Build or push failed."
            }
        }
    }
}
