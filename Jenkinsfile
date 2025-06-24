pipeline {
    agent any

    stages {
        stage('Checkout code') {
            steps {
                // Use default Git installation, no gitTool specified
                git url: 'https://github.com/ajithgitgit/Adactin_testing.git', branch: 'Update_frame'
            }
        }

        stage('Building') {
            steps {
                echo 'Building the maven project'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests'
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
