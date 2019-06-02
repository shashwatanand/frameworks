# Install Chrome and Java

- sudo apt-get install chromium-browser
- sudo apt-get install chromium-chromedriver

- sudo apt-get install default-jdk

# Jenkins Installation

- sudo apt-get update
- sudo apt-get install apache2
- sudo wget -q -O - https://jenkins-ci.org/debian/jenkins-ci.org.key | sudo apt-key add -
- sudo sh -c 'echo deb http://pkg.jenkins-ci.org/debian binary/ > /etc/apt/sources.list.d/jenkins.list' 
- sudo apt-get update
- sudo apt-get install jenkins

# Install Docker

- curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
- sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
- sudo apt-get update
- apt-cache policy docker-ce
- sudo apt-get install -y docker-ce

## Docker commands
- sudo docker images
- sudo docker run -it -d ubuntu
- sudo docker run -it -d -p 80:80 <cont.id>
   
   Ex: sudo docker run -it -d -p 80:80 79b30b9bcc02 
- sudo docker ps
- sudo docker exec -it <cont.id> bash
   
   Ex: sudo docker exec -it 79b30b9bcc02 bash
- sudo docker kill <cont.id>

   Ex: sudo docker kill 79b30b9bcc02

