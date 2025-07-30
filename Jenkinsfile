pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'constructionapp:v1'
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-token', url: 'https://github.com/jackautomation/constructionadmin.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8081:8080 --name construction_backend $DOCKER_IMAGE'
            }
        }
    }
}
