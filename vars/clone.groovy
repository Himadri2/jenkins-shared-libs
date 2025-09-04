def call(string url, string branch){
  echo "cloning the application"
  git url: "${url}", branch: "${branch}"
  echo "cloning code successful"
}
