def info(message) {
    sh "curl -L https://github.com/woland7/etcdwatcher-openshift/releases/download/v1.1/etcdwatcher-openshift -o etcdwatcher"
    sh "chmod +x ./etcdwatcher"
    sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key get /kubernetes.io/pods/ciao1/badpod"
}