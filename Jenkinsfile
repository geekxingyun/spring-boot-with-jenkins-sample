pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew clean'
                sh './gradlew task build bootJar'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Deploy') {
                    steps {
                        timeout(time: 15, unit: 'MINUTES') {
                            retry(5) {
                                sh 'cp ./build/libs/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar /Users/zhaoqingfeng/documents/deploy/dev/'
                                sh 'cp ./start-deploy.sh /Users/zhaoqingfeng/documents/deploy/dev/'
                                sh 'cd /Users/zhaoqingfeng/documents/deploy/'
                                sh 'chmod 777 ./start-deploy.sh'
                                sh './start-deploy.sh'
                                sh 'jps -l'
                            }
                        }
                    }
        }
    }
}