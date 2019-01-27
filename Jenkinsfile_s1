
node('dockerspr1') {

    stage ('Build'){
        sh "sleep 1"
        sh "echo 1"
        //mvn
    }

    stage ('test'){
        parallel 2:{
        sh "sleep 2"
        sh "echo 2"
        }, 3:{
        sh "sleep 3"
        sh "echo 3"
        }
    }
}
