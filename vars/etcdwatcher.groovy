def watchWithTimeout(namespace, key, timeout) {
    try {
        sh "curl 192.168.10.24:80/watcher -o etcdwatcher"
        sh "chmod +x ./etcdwatcher"
        sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watchWithTimeout /kubernetes.io/pods/$namespace/$key $timeout"
    }
    catch (exc){
        echo "Operation could not be completed on time. Do something."
    }
}
def watchBuildWithTimeout(namespace, key, timeout, name, deployment) {
    try {
        sh "curl 192.168.10.31:80/etcdhelper -o etcdwatcher"
        sh "chmod +x ./etcdwatcher"
        sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watchBuildWithTimeout /kubernetes.io/pods/$namespace/$key $timeout $name " +
                "$deployment"
    }
    catch (exc){
        echo "Operation could not be completed on time. Do something."
    }
}
