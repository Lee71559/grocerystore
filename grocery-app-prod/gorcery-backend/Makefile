
jar: 
	gradle build -x test
	gradle bootJar

docker-build: jar
	docker build -t grocery-backend .
	docker images

docker-push:
	docker login
	docker build -t xuefeng89/grocery-backend:v1 .
	docker push xuefeng89/grocery-backend:v1