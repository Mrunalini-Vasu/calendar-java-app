pipeline {
    agent any

    environment {
        APP_NAME = 'calendar-app'
        IMAGE_NAME = 'calendar-java-app'
        REPO_URL = 'https://github.com/Mrunalini-Vasu/calendar-java-app.git'
    }

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main', url: "${REPO_URL}"
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Remove Old Container') {
            steps {
                script {
                    sh 'docker rm -f $APP_NAME || true'
                }
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker run -d --name $APP_NAME $IMAGE_NAME'
            }
        }
    }

    post {
        failure {
            echo 'Build failed. Cleaning up...'
            sh 'docker rm -f $APP_NAME || true'
        }
    }
}

