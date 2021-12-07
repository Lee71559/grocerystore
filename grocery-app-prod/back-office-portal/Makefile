
jar: 
	gradle build -x test
	gradle bootJar

docker-build: jar
	docker build -t back-office-portal .
	docker images

docker-push:
	docker login
	docker build -t xuefeng89/back-office-portal:v1 .
	docker push xuefeng89/back-office-portal:v1