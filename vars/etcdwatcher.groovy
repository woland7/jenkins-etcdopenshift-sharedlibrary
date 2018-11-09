/**
 * This groovy file contains the shared library to use the etcdwatcher primitive in Jenkins.
 * Address is local the testing cluter. It should be changed accordingly. However, it is just
 * a workaround. A better solution should be devised.
 *
 * The etcdwatcher primitive is retrievable at https://github.com/woland7/etcdwatcher-openshift
 */

/**
 * This function downloads the primitive executable to Jenkins pipeline instance.
 * It then give is execution permissions.
 */
def downloadEtcdWatcher(){
    sh "curl 192.168.10.18:80/etcdwatcher -o etcdwatcher"
    sh "chmod +x ./etcdwatcher"
}

/**
 * This is a legacy function. A first version of the primitive allowed only to watch for a pod already
 * been deployed.
 *
 * @param namespace the OpenShift project one is working on
 * @param key the pod's name
 * @timeout the timeout (seconds) to wait before declaring the synchronization failed; useful for byzantine faults
 * it has to be specified as an unsigned integer
 */
def watchWithTimeout(namespace, key, timeout) {
    try {
        sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watchWithTimeout $namespace $key $timeout"
    }
    catch (exc){
        echo "Operation could not be completed on time. Do something."
    }
}
/**
 *This function watches for a build followed by an automated deploy and suspend the pipeline execution until
 * the deployed pods become ready.
 *
 * @param namespace the OpenShift project one is working on
 * @param key the pod's name
 * @timeout the timeout to wait before declaring the synchronization failed; useful for byzantine faults
 * @mode mode, ALL or ATLEASTONCE, allows to watch for all the pods to be ready or for at least once, respectively
 */
def watchBuildWithTimeout(namespace, key, timeout, mode) {
    try {
        sh "./etcdwatcher -cacert ./master.etcd-ca.crt -cert ./master.etcd-client.crt -key ./master.etcd-client.key watchBuildWithTimeout $namespace $key $timeout $mode"
    }
    catch (exc){
        echo "Operation could not be completed on time. Do something."
    }
}