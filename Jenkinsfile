pipeline {
    agent any

    environment {
        // Assuming you have stored the credentials with this ID
        DOCKER_HUB = credentials('dockerhub-creds')
    }

    stages {
        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps {
                bat 'docker build -t rajat725/sel .'
            }
        }

        stage('Push Image') {
            steps {
                script {
                    // Securely pass the Docker Hub password
                    bat "docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%"
                    bat 'docker push rajat725/sel'
                }
            }
        }
    }

    post {
        always {
            script {
                bat 'docker logout'
            }
        }
    }
}
