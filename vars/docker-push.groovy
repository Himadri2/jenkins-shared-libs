def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialsId:"DockerHubCred", passwordVariable:"DockerHubPass", usernameVariable:"DockerHubUser")]){
    sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPass}"
  }
  sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
}
