node('master') {
stage ('Start'){}

    stage('DEV') {

        sh "echo Build"
		sh "pwd"
		sh "touch abc"
		parallel (
        "TRS Build": {
		//build 'jenkins_build'
		stage ('Test'){ echo "TEST"}
		//test stage
            sh "echo 1 Build"
			sh "pwd"
			sh "touch abc"
			sh "sleep 3"
        },
        "1 Build": {
            sh "echo 1 Build"
			sh "sleep 2"
        },
      )
    }
    stage('DEV Deploy'){
      parallel (
        "1 Deploy": {
            sh "echo 1 Deploy"
			sh "sleep 2"
        },
        "2 Deploy": {
            sh "echo 2 Deploy"
			sh "sleep 5"
        },
      )
    }
    stage('DEV Tests'){
      parallel (
        "1 DEV Test": {
            sh "echo 1 DEV Test"
			sh "sleep 2"
        },
        "2 DEV Test": {
            sh "echo 2 DEV Test"
			sh "sleep 5"
        },
      )
    }

	//checkpoint


	stage ('Pause') {
	input 'Proceed to UAT'
	def userInput = input(
 id: 'userInput', message: 'Let\'s promote?', parameters: [
 [$class: 'TextParameterDefinition', defaultValue: 'uat', description: 'Environment', name: 'env'],
 [$class: 'TextParameterDefinition', defaultValue: 'uat1', description: 'Target', name: 'target']
])
echo ("Env: "+userInput['env'])
echo ("Target: "+userInput['target'])

sh "echo env"
	}

	stage('UAT Deploy'){
	  parallel (
		"1 Deploy": {
			sh "echo 1 Deploy"
			sh "sleep 2"
		},
		"2 Deploy": {
			sh "echo 2 Deploy"
			sh "sleep 5"
		},
	  )
	}
    stage('UAT Tests'){
      parallel (
        "1 Test": {
            sh "echo 1 Test"
			sh "sleep 2"
        },
        "2 Test": {
            sh "echo 2 Test"
			sh "sleep 5"
        },
      )
    }

	stage ('ITSM ') {
	retry (5){
	sleep 5
	input 'Proceed to PROD'
	//sh "rm /home/ayanendude/test_jenkins/test.txt"

	}
		}


}