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




docker-build:jar
	docker build -t login-backend .
	docker images

docker-run: docker-build
	docker run  --network grocerydb --name login-backend -td -p 3000:8080 login-backend 	
	docker ps


