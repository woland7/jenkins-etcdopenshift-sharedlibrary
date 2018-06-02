def watchWithTimeout(namespace, key, timeout) {
    try {
        sh "curl 192.168.10.24:80/watcher -o etcdwatcher"
        sh "chmod +x ./etcdwatcher"
        sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watchWithTimeout $namespace $key $timeout"
    }
    catch (exc){
        echo "Operation could not be completed on time. Do something."
    }
}
def watchBuildWithTimeout(namespace, key, timeout) {
    try {
        sh "curl 192.168.10.24:80/watcher -o etcdwatcher"
        sh "chmod +x ./etcdwatcher"
        sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watchBuildWithTimeout $namespace $key $timeout"
    }
    catch (exc){
        echo "Operation could not be completed on time. Do something."
    }
}
