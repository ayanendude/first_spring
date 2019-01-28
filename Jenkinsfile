
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

        withSonarQubeEnv('Sonar') {
          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.3.0.603:sonar ' +
          '-f all/pom.xml ' +
          '-Dsonar.projectKey=com.huettermann:all:master ' +
          '-Dsonar.login=$SONAR_UN ' +
          '-Dsonar.password=$SONAR_PW ' +
          '-Dsonar.language=java ' +
          '-Dsonar.sources=. ' +
          '-Dsonar.tests=. ' +
          '-Dsonar.test.inclusions=**/*Test*/** ' +
          '-Dsonar.exclusions=**/*Test*/**'
        }

        }
    }
}
