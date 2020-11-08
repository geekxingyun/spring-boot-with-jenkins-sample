pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Deploy') {
                    steps {
                        timeout(time: 3, unit: 'MINUTES') {
                            retry(5) {
                                sh 'nohup java -jar ./build/libs/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar &'
                            }
                        }
                    }
        }
    }
}