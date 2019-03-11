
node('docker_mvn') {
withEnv(['MAVEN_OPTS=Xms256M Xmx2048M']){
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

        withSonarQubeEnv('Sonar1') {
          sh 'mvn clean package sonar:sonar \
                -Dsonar.projectKey=ayanendude_first_spring \
                -Dsonar.organization=ayanendude-github \
                -Dsonar.host.url=https://sonarcloud.io \
                -Dsonar.login=f538d1cdfae15608808898a0437676e813b9bbee'
        }

        }
    }}
}
