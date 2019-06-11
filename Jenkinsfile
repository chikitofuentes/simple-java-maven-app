pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' args '-p 8001:8001'
        }
    }
    stages {
        stage('Construcción') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Pruebas') {
            steps {
                sh 'mvn test'
            }
	    post {
		always {
			junit 'target/surefire-reports/*.xml'
		}
	    }

        }
        stage('Despliegue') { 
            steps {
                sh './jenkins/scripts/deliver.sh' 
            }
        }
    }
}
