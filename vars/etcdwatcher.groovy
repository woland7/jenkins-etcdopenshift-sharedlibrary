def downloadEtcdWatcher(){
    sh "curl 192.168.10.18:80/etcdwatcher -o etcdwatcher"
    sh "chmod +x ./etcdwatcher"
}

def watchWithTimeout(namespace, key, timeout) {
    try {
        sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watchWithTimeout $namespace $key $timeout"
    }
    catch (exc){
        echo "Operation could not be completed on time. Do something."
    }
}
def watchBuildWithTimeout(namespace, key, timeout, mode) {
    try {
        sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watchBuildWithTimeout $namespace $key $timeout $mode"
    }
    catch (exc){
        echo "Operation could not be completed on time. Do something."
    }
}














