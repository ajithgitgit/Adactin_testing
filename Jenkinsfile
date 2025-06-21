pipeline {
    agent any

    environment {
        MAVEN_IMAGE = 'maven:3.9.6-eclipse-temurin-17'
    }

    stages {
        stage('Checkout code') {
            steps {
                echo 'Cloning the repository.......'
                git url: 'https://github.com/ajithgitgit/Adactin_testing.git', branch: 'Update_frame'
            }
        }

        stage('building') {
            steps {
                echo 'Building the maven project'
                 bat 'mvn clean compile'
            }
        }

        stage('test') {
            steps {
                echo 'Testing the website'
               bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}


