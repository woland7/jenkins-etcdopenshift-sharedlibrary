def watchPodReadyState(namespace, pod, timeout) {
    try {
        sh "curl 192.168.10.24:80/watcher -o etcdwatcher"
        sh "chmod +x ./etcdwatcher"
        sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watch /kubernetes.io/pods/$namespace/$pod $timeout"
    }
    catch (exc){
        echo "Operation could not be completed on time. Do something."
    }
}
