
node('docker_mvn') {

    stage ('Checkout') {
        git url: 'https://github.com/ayanendude/first_spring.git'
    }

    stage ('Build'){
        sh "sleep 1"
        sh "echo 1"
        //mvn
        sh "mvn -DskipTests=true clean install"
    }

    stage ('Test & Scan'){
        parallel Test:{
        sh "sleep 2"
        sh "echo 2"
        sh "mvn test"
        }, BlackDuck:{
        sh "sleep 3"
        sh "echo 3"
        }, SonarQube:{
        sh "sleep 3"
        sh "echo 3"
        }
    }
}
