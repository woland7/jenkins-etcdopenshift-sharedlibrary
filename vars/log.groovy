def info(message) {
    echo "INFO: ${message}"
    def filePath =  "./etcdwatcher"
    def file = new File(filePath)
    if(!file.exists()){
        sh "curl -L https://github.com/woland7/etcdwatcher-openshift/releases/download/first/etcdwatcher-openshift -o etcdwatcher"
        sh "chmod +x ./etcdwatcher"
    }
    sh "./etcdwatcher"
}