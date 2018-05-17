def info(message) {
    echo "INFO: ${message}"
    sh "curl --version"
    sh "pwd"
}