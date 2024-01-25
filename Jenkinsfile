
pipeline{

    agent any

    stages{

        stage('Build Jar'){
            steps{
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image'){
            steps{
                bat 'docker build -t=rajat725/sel .'
            }
        }

        stage('Push Image'){
            environment{
                // assuming you have stored the credentials with this name
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps{
                // There might be a warning.
                bat docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%
                bat 'docker push rajat725/sel'
            }
        }

    }

    post {
        always {
            bat 'docker logout'
        }
    }

}