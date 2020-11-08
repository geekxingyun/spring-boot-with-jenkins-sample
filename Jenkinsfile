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
        post {
                always {
                    echo 'This will always run'
                }
                success {
                    echo 'This will run only if successful'
                }
                failure {
                    echo 'This will run only if failed'
                }
                unstable {
                    echo 'This will run only if the run was marked as unstable'
                }
                changed {
                    echo 'This will run only if the state of the Pipeline has changed'
                    echo 'For example, if the Pipeline was previously failing but is now successful'
                }
        }
    }
}