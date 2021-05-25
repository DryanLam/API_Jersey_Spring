def containerName = "${env.JOB_NAME}-${env.BUILD_NUMBER}".replace('-', '_').replace('/', '_')

def impactedTC = ""

pipeline {
    agent none
    
    tools {
        // Install & add "M3" to the path.
        maven "M3"
    }
    
    stages {
        
        stage('T.I.A') {
            agent {
                label 'Test-Linux'
            }
            
            steps {
                git branch: 'kataconnect', credentialsId: '7436167f-f5d5-45f6-ac3e-fd63bfe1c5b8', url: 'https://github.com/DryanLam/API_Jersey_Spring.git'
                
                script {
                    withEnv(['GROOVY_HOME=/home/ubuntu/groovy/groovy-3.0.8', 'MONGO_DB=54.251.60.125']) {
                        impactedTC += sh(returnStdout: true, script: '$GROOVY_HOME/bin/groovy -Dmongodb.host=$MONGO_DB impactDetection.groovy').trim()
                        println(impactedTC)
                    }
                }
            }
        } // End -State:Detection
        
        stage('Build') {
            agent {
                label 'Test-Linux'
            }
            
            steps {
                git branch: 'kataconnect', credentialsId: '7436167f-f5d5-45f6-ac3e-fd63bfe1c5b8', url: 'https://github.com/DryanLam/API_Jersey_Spring.git'
                
                sh "mvn clean package"
                stash includes: 'target/*.jar', name: 'app'
            }
            
            post {
                always {
                    cleanWs()
                }
            }
        } // End -State:Build
        
        stage('Deploy') {
            agent {
                label 'Test-Linux'
            }
            
            steps {
                unstash 'app'
                sh "docker run -t -d --rm  -p 7000:7000 --name ${containerName} maven:3.6.3-adoptopenjdk-8 /bin/bash"
                sh "docker cp target/WS-App-SNAPSHOT.jar ${containerName}:/home/"
                sh "docker exec ${containerName} java -jar /home/WS-App-SNAPSHOT.jar > /dev/null &"
            }
            
            post {
                always {
                    cleanWs()
                }
            }
        } // End - State:Deploy
        
        stage('Test') {
            agent {
                label 'Test-Win-01'
            }
            steps {
                git branch: 'kataconnect', credentialsId: '7436167f-f5d5-45f6-ac3e-fd63bfe1c5b8', url: 'https://github.com/DryanLam/Kat.git'
                bat "echo ${impactedTC}"
                bat "katalonc -noSplash -runMode=console -projectPath=\"${env.WORKSPACE}\\KataConnect.prj\" -testSuitePath=\"Test Suites/Regression\" -browserType=\"Chrome\" -apiKey=9e5b8d61-eb77-4038-8225-eb7fe6341ea1 -g_API_URL=\"http://52.77.177.13:7000/api\" -g_TAGS=\"${impactedTC}\" --config -webui.autoUpdateDrivers=true"
            }
        }// End - Test

        stage('TearDown') {
            agent {
                label 'Test-Linux'
            }
            steps {
                sh "docker rm -f \$(docker ps -q)"
            }
        }// End -Clean
        
    }
}