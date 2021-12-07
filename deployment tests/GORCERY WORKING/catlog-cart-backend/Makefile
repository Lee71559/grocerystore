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

run: jar
	echo Starting Spring at:  http://localhost:8080
	java -jar build/libs/grocery-1.0.jar

# Docker

docker-build: jar
	docker build -t grocery .
	docker images

docker-run: docker-build
	docker run --network grocery -e "MYSQL_HOST=mysql" --name grocery -td -p 80:8080 grocery	
	docker ps

docker-clean:
	docker stop grocery
	docker rm grocery
	docker rmi grocery

docker-shell:
	docker exec -it grocery bash 

docker-push:
	docker login
	docker build -t --platform linux/amd64,linux/arm64 lee71559/grocery:v1 -t lee71559/grocery:v1 .
	docker push lee71559/grocery:v1

docker-push-amd64:
	docker buildx ls
	docker buildx create --use
	docker buildx build --platform linux/amd64,linux/arm64 --push -t lee71559/grocery:v1 .

docker-mysql:
	docker run --platform linux/x86_64 -d --network grocery --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cmpe172 mysql:8.0

# Compose

network-ls:
	docker network ls 

network-create:
	docker network create --driver bridge grocery

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale grocery=2 -d

compose-down:
	docker-compose down 	

lb-stats:
	echo "user = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost

mysql-up:
	docker-compose up -d mysql

lb-up:
	docker-compose up -d lb

gumball-up:
	docker-compose up -d --scale gumball=2 -d


# Pod

pod-run:
	kubectl apply -f pod.yaml

pod-list:
	kubectl get pods

pod-desc:
	kubectl describe pods spring-gumball

pod-delete:
	kubectl delete -f pod.yaml

pod-shell:
	kubectl exec -it spring-gumball -- /bin/bash

pod-logs:
	kubectl logs -f spring-gumball

# Deployment

deployment-create:
	kubectl create -f deployment.yaml --save-config 

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=spring-gumball

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f deployment.yaml

deployment-delete:
	kubectl delete deployment spring-gumball-deployment

# Service

service-create:
	kubectl create -f service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service spring-gumball -o wide

service-delete:
	kubectl delete service spring-gumball

# Ingress

ingress-apply:
	kubectl apply -f ingress.yaml

ingress-ip:
	kubectl get ingress spring-gumball-ingress




