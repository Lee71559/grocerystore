# Team Project: Wing Chun
### Project Name: SJSU Grocery Store
>Team Members
> * Veida Hernandez
> * Shan Shan Lee
> * Roneil Sembrano
> * Xuefeng Xu
### Individual Journal:
* [Veida's Journal](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/payment-process/README.md)
* [Shan Shan's Journal](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/README.md)
* [Roneil's Journal](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/login%20/customers_react/customers-app/README.md)
* [Xuefeng's Journal](https://github.com/nguyensjsu/cmpe172-xuefengxu-21/tree/main/project)

## Team Journal:
## Journal Entry 1 (10/28/21):
* Meeting to decide what application to make. 
* Outline discussed. 
* [Outline](https://docs.google.com/document/d/1v2LwkCpgsHF44LANG7kGLdtiJFuB_MHvlEOpWBn36Sk/edit?usp=sharing)
* Work split up for research. 
## Journal Entry 2 (11/4/21):
* Work split reassigned 
* Task created and assigned
* React application created 
## Journal Entry 3 (11/11/21):
* Meet to disscuse team progress.
* Ro working on spring-boot portion
* Shan has completed assignment and is working on react portion
* Veida has completed assignment and is working on react portion
* Xuefeng has completed assignment
* Scheduled next meeting for Sunday, will be working on deployment
## Journal Entry 4 (11/14/21)
* Late meeting Sunday night.
* Discussed flow of our project.
* Made sure we all understood how our project willl flow.
* Ro login/ register will happen first, Shan catalog , Veidas payment, and Xuefeng will back office portals.
* Database will be implemented by Xuefeng on google cloud
* Everyone is still working on their tasks.
* Flow Chart ![alt text](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/images/images1.png)
## Journal Entry 5 (11/18/21)
* Meet to discuss progress. Shan is re working the database inorder to connect order id to an entire order.
* Ro is working on his login/logout in spring
* Xuefeng has updated the flow chart and provided new charts.
* Veida has resolved her issue with react and is moving on to deployment.
* Flow Chart Update ![alt text](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/images/images2.png)
* Other Charts ![alt text](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/images/images3.png)
## Journal Entry 6 (11/28/21)
* Meet to discuss progress. All teammates code was pushed to git. Xuefeng will be working on SQL database, RabbitMQ, and Kong API.
* Next meeting we will deploy on Google Cloud.
## Journal Entry 6 (12/4/21)
* Meet to discuss deployment. Xuefeng wanted everyone to push working code. Veida combined all frontend react into one project. 
* Xuefeng tested all the backend and attempted to deploy on cloud.

---
# Project
> Build a Google Cloud Hosted Enterprise Application for a "Real" or "Fictitious" Corporation to support the Order and Payment Processing for Products or Services.  
> Your team may select any Company and any Product or Services, but must meet the following functional and technical requirements:
![alt text](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/images/Homescreen.JPG)
## Functional Requirements

### Front Office Portal: 
> A "Front Office" Web Application that allows customers to 
> * sign-up for accounts 
> * browse product catalog or offerings
> * place and pay for orders using credit cards.

### Back Office Portals: 
> * One or more "Back Office" Web Applications that supports "help desk" functions (your team may chose what functions to implement -- for example, refund/returns, help customers reset password, etc...)

### REST APIs: 
> Back Office and Front Office Applications should integration with "Backends" using one or more REST APIs.

## Technical Requirements
> Your team's solution must be implemented in Java Spring and be deployable as Docker Containers on Google Cloud VM's and/or Kubernetes Engine (GKE).  Also, your team > will be assigned a Team Repository in our GitHub Organization.  All team members must be committing work to GitHub, making weekly Individual Status Reports as 
> (Markdown GitHub Files) along with using GitHub's Team Task Board to track your progress.

## Software Stack & Tools
> * Must use Spring Framework (Spring MVC, Spring JPA, Etc...)
>   * For Back Office Portal(s)
>   * For REST APIs
>   * For customer facing Front Office Portal, team can chose front end Tech Stack
>   * For Example:  Node.js + Javascript/React
   
## Development Tools
> * Builds must be done with Gradle 5.6
> * Version of Java should be JDK 11
## Database & Middleware Requirements
> * MySQL Database 8.0
> * RabbitMQ
> * Kong API Gateway
> * Credit Card Payments Support
>   * Integration with CyberSource Payment Gateway
---
## ScreenShots:
* Front Office Portal (20 points)
  * New User Sign-Up
    *  ![alt text](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/images/Signup.png)
    *  ![alt text](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/images/Signin.png)
  * Browse Catalog
  * Order Processing
    *  ![alt text](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/images/Checkoutscreen.JPG)
  * Payment Processing
    *  ![alt text](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/images/Cybersource.JPG)

* Back Office Portal (20 points)
  * Help Desk Function
* REST APIs (20 points)
* Microservices Design (5 points)
* Microservices Deployment (5 points)
* Kong API Gateway (10 points)
* Integration with CyberSource Payments (20 points)
* Cloud Deployment on GCP/Kubernetes (20 points)
* MySQL Database 8.0 (10 points)
* RabbitMQ (10 points)
