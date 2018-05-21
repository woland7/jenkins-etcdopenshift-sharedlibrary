def watchPodReadyState(pod) {
    echo "Watch ready state of $pod"
    sh "curl 192.168.10.31:80/etcdhelper -o etcdwatcher"
    sh "chmod +x ./etcdwatcher"
    sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watch /kubernetes.io/pods/ciao1/$pod"
}