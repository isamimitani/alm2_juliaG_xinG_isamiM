pipeline {
    agent any
    parameters {
        choice(name: 'DEPLOY_ENV', choices: ['int', 'stage', 'prod'],  description: 'The target environment to deploy artifacts')
    }
    stages {       
        stage('Building project, running tests and publishing test results') {
            agent { 
                docker { image 'maven:3.6.2' }
            }   
            steps {
                sh 'mvn clean install'
            }
            post {
                always {            
                    junit 'target/surefire-reports/*.xml'
                    publishHTML([
                    allowMissing          : false,
                    alwaysLinkToLastBuild : false,
                    keepAll               : true,
                    reportDir             : 'target/site/jacoco/',
                    reportFiles           : 'index.html',
                    reportTitles          : "Tests coverage",
                    reportName            : "Tests coverage"
                    ])
                }
                success {
                    archive "target/fortuneTeller-1.0.war"
                }
            } 
        }         
       
        stage('Deploying artifacts to selected target'){
            agent any
            steps{
                sh 'export PATH=/opt/glassfish-4.1.1/bin/asadmin:$PATH'
                sh 'asadmin --port 4848 deploy --force --name fortuneTeller-${DEPLOY_ENV} --contextroot fortuneTeller-${DEPLOY_ENV} target/fortuneTeller-1.0.war'
            }
        } 
    }
}
