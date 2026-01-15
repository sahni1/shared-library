// vars/jenkins.groovy
def customFunction(boolean enabled = true) {
    echo "customFunction is running!"
    
    if (!enabled) {
        echo "Pipeline execution disabled"
        return
    }

    // Configuration for the pipeline
    def config = [
        env    : 'dev',
        version: '1.0',
        team   : 'platform'
    ]
    
    echo "Loaded config: ${config}"
    return config
}
