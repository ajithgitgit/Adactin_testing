pipeline {
    agent any

    stages {
        stage('Checkout code') {
            steps {
                git url: 'https://github.com/ajithgitgit/Adactin_testing.git', branch: 'Update_frame'
            }
        }

        stage('Check Maven version') {
            steps {
                sh 'mvn -version'
            }
        }

        stage('Building') {
            steps {
                echo 'Building the maven project'
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running tests'
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Publishing test reports'
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
