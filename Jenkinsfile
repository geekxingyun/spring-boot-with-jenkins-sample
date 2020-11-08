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
                                //sh 'javaw -jar ./build/libs/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar'
                                sh 'cp ./build/libs/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar /Users/zhaoqingfeng/documents/test'
                                sh 'cd /Users/zhaoqingfeng/documents/test'
                                sh 'nohup java -jar spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar &'
                                sh 'jps -l'

                                //sh 'chmod 777 ./start-deploy.sh'
                                //sh './start-deploy.sh'
                                //sh 'jps -l'
                            }
                        }
                    }
        }
    }
}