# Gradle:
all: clean

clean:
	gradle clean

compile:
	gradle build

test:
	gradle test

jar: 
	gradle build -x test
	gradle bootJar



# Docker
create-network:
	docker network create grocerydb

docker-mysql: create-network
	docker run -d --network grocerydb --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cmpe172 mysql:8.0

mysql: 
	docker run -d --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cmpe172 mysql:8.0

excute-mysql:
	docker exec -it mysql bash

docker-build:jar
	docker build -t db-management .
	docker images

docker-run: docker-build
	docker run  --network grocerydb -e "MYSQL_HOST=mysql" --name db-management -td -p 80:8080 db-management	
	docker ps

compose-up:
	docker-compose up --scale dbmanagement=1 -d
