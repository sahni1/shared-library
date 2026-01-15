def call(boolean enabled = true) {
    if (!enabled) {
        echo "Pipeline execution disabled"
        return
    }

    // Configuration lives here (or can be dynamic)
    def config = [
        env    : 'dev',
        version: '1.0',
        team   : 'platform'
    ]

    pipeline {
        agent any

        stages {
            stage('Load Properties') {
                steps {
                    script {
                        echo "Loaded config: ${config}"
                    }
                }
            }

            stage('Greeting') {
                steps {
                    script {
                        greet("Alice")
                    }
                }
            }
        }
    }
}
