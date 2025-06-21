pipeline {
    agent any

    stages {
        stage('Checkout code') {
            steps {
                git url: 'https://github.com/ajithgitgit/Adactin_testing.git', branch: 'Update_frame'
            }
        }

        stage('building') {
            steps {
                echo 'Building the maven project'
                sh 'mvn clean compile'
            }
        }

        stage('test') {
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
