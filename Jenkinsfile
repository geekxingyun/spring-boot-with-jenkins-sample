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
                                sh 'cp ./build/libs/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar /Users/zhaoqingfeng/documents/deploy/test/'
                                sh 'cp ./build/libs/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar /Users/zhaoqingfeng/documents/deploy/uat/'
                                sh 'JENKINS_NODE_COOKIE=dontKillMe nohup java -jar /Users/zhaoqingfeng/documents/deploy/dev/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &'
                                sh 'JENKINS_NODE_COOKIE=dontKillMe nohup java -jar /Users/zhaoqingfeng/documents/deploy/test/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar --spring.profiles.active=test &'
                                sh 'JENKINS_NODE_COOKIE=dontKillMe nohup java -jar /Users/zhaoqingfeng/documents/deploy/uat/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar --spring.profiles.active=uat &'
//                                    sh 'JENKINS_NODE_COOKIE=dontKillMe nohup java -jar ./build/libs/spring-boot-with-jenkins-sample-0.0.1-SNAPSHOT.jar &'
//                                 sh 'chmod 777 ./start-deploy.sh'
//                                 sh './start-deploy.sh'
                                sh 'jps -l'
                                sh 'echo deploy success'

                            }
                        }
                    }
        }
    }
}