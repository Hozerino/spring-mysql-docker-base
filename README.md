# Spring MySQL Docker | Base Project
Base project used to start SpringBoot+MySQL+Docker+Docker-Compose applications.
It contains `.bat` scripts to make the creation of containers easier for Windows users.
Will soon add `.sh` scripts as well.  
  
## Useful commands:
### - Running docker-compose MySQL only
```
docker-compose up db
```

### - Build project and prepare database (consider having the database docker up)
```
gradlew clean build flywayRepair flywayMigrate
```

### - Build docker project image
```
docker build . --no-cache --tag dockerpoc
```

### - Prune untagged/unnamed docker images
```
docker system prune -f
```
### - Clear database docker-compose container (you can check it with `
docker volume ls`)
```
docker-compose down
docker-compose rm
docker volume prune
```

### - Run application docker (without database)
```
docker run -p 80:8080 -it --rm dockerpoc:latest
```

### - Run whole docker-compose (database and application images)
```
docker-compose up --rm
```
