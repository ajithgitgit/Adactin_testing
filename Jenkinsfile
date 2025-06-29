pipeline {
    agent {
        docker {
            image 'maven:3.9.3-openjdk-17-slim'  // Official Maven + OpenJDK 17 image
            args '-v $HOME/.m2:/root/.m2'         // Cache Maven repo for faster builds
        }
    }

    stages {
        stage('Checkout code') {
            steps {
                echo 'Checking out source code from GitHub...'
                git url: 'https://github.com/ajithgitgit/Adactin_testing.git', branch: 'Update_frame'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the Maven project inside Docker...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests inside Docker...'
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
        failure {
            echo 'Build or tests failed!'
        }
    }
}
