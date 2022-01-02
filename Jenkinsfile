pipeline {
    agent {
        docker { image 'openjdk:16-jdk-alpine' }
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew shadowJar'
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }
}