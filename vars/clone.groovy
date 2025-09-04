def call(String url, String branch){
  echo "cloning the application"
  git url: "${url}", branch: "${branch}"
  echo "cloning code successful"
}
