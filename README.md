
docker build . --tag dockerpoc

docker system prune

docker run -p 80:8080 -it --rm dockerpoc:latest"# spring-mysql-docker-base" 
