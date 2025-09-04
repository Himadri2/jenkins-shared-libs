def call() {
    sh '''
        docker compose down
        docker system prune -a --volumes -f
        docker compose up -d --build
    '''
}
