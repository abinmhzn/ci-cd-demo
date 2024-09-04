pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/abinmhzn/ci-cd-demo.git'
            }
        }

        stage('Build WAR') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("abinmhzn/java-form-app")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
                        dockerImage.push()
                    }
                }
            }
        }

        stage('Deploy to webserver') {
            steps {
                sshagent(['webserver-ssh-credentials-id']) {
                    sh '''
                        ssh vagrant@ansible-host 'docker pull abinmhzn/java-form-app && docker run -d -p 8083:8080 abinmhzn/java-form-app'
                    '''
                }
            }
        }
    }
}

