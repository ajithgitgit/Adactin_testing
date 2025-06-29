pipeline {
    agent any

    stages {
        stage('Checkout code') {
            steps {
                echo 'Checking out source code from GitHub...'
                git url: 'https://github.com/ajithgitgit/Adactin_testing.git', branch: 'Update_frame'
            }
        }

        stage('Building') {
            steps {
                echo 'Building the Maven project...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running Maven tests...'
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Publishing JUnit test results...'
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
            cleanWs()
        }
    }
}
