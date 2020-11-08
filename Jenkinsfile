pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew task build clean'
                sh './gradlew task build bootJar'
                //sh './gradlew assemble'
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
                            retry(1) {
                                sh 'cp ./build/libs/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar /Users/zhaoqingfeng/documents/deploy/dev/'
                                sh 'cp ./start-deploy.sh /Users/zhaoqingfeng/documents/deploy/dev/'
                                sh 'cd /Users/zhaoqingfeng/documents/deploy/dev'
                                sh 'chmod 777 ./start-deploy.sh'
                                sh './start-deploy.sh'
                                sh 'jps -l'
                            }
                        }
                    }
        }
    }
}