def info(message) {
    echo "INFO: ${message}"
    sh "curl --version"
    curl --version
    sh "pwd"
}