pipeline{
environment{
        docker_image = ""
        M2_HOME = '/opt/maven'
    }
    agent any
	stages{
		stage("Git pull")
		{
			steps
			{ 
			git url:'https://github.com/Mokshananda-Reddy/RoomUp',branch:'main'
			}
		}

        stage(' Maven Build'){
            steps{
                dir('RoomUp_BackEnd') {
                      sh 'pwd'
                      sh 'java --version'
                      //sh 'rm -rf ~/.m2/repository'
                      sh 'ls /opt'
                      sh 'ls /opt/apache-maven-3.8.8'
                      sh 'echo $MAVEN_HOME'
                      sh 'echo $PATH'
                      sh '${M2_HOME}/bin/mvn --version'
                      sh "${M2_HOME}/bin/mvn clean install -e"
                      sh 'docker-compose --version'
                    }
            }
        }
stage("Running React Tests")
	 	{
			steps
			{
			    dir('RoomUp_FrontEnd') {
				echo "running react tests"
				sh "npm install --force"
				sh "npm test"
			    }
			}
		}
stage("Build roomup Backend Docker Image")
		{
			steps
			{
			    dir('RoomUp_BackEnd') {
			    sh "docker rmi parvparikh/roomup_backend"
			    echo "build roomup backend docker Image"
			    script {
                    docker_backend_image = docker.build "parvparikh/roomup_backend:latest"
                }
			    }
			    
			    
			}
		}
		 
		stage("Build roomup Frontend Docker Image")
		{
			steps
			{
    			dir('RoomUp_FrontEnd') {
    			    sh "docker rmi parvparikh/roomup_frontend"
                    echo "build roomup frontend docker Image"
                    script {
                        docker_frontend_image = docker.build "parvparikh/roomup_frontend:latest"
                    }
    			    }
			}
		}


		stage("Push Frontend Docker Image to Docker Hub")
		{
			steps
			
			{ 	echo "Push frontend Docker Image to Docker Hub"
				script {
                    docker.withRegistry('', 'docker') {
                        docker_frontend_image.push()
                    }
			}
		}
		}
				stage("Push Beckend Docker Image to Docker Hub")
		{
			steps
			
			{ 	echo "Push Beckend Docker Image to Docker Hub"
			 script {
                    docker.withRegistry('', 'docker') {
                        docker_backend_image.push()
                    }	
			}
		}
		}
		stage("Removing Docker Images from Local")
		{
			steps
			{ 	echo "Removing Docker Images from Local"
				sh "docker rmi parvparikh/roomup_backend"
				sh "docker rmi parvparikh/roomup_frontend"	
				}
		}
		stage("Deploy and Run Images")
		{
			steps
			{
				echo "Deploy and Run Images"
				ansiblePlaybook(credentialsId: 'docker', inventory: 'inventory', playbook:'playbook.yml')
			}
		}
	}
}


