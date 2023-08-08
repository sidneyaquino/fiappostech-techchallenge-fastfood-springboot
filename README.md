<!-- TECH-CHALLENGE FIAP POSTECH: 2nd PHASE -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

<!-- PROJECT'S TITLE -->
<a name="readme-top"></a>
<h1 align="center">
  <a href="#"> TECH-CHALLENGE FIAP POSTECH - 2nd PHASE</a>
</h1>

<!-- PROJECT'S STATUS -->
<h4 align="center"> 
  Status: MAN AT WORK...
</h4>

<!-- TABLE OF CONTENTS DETAIL -->
<p align="center">
  <a href="#about-the-project">About</a> •
  <a href="#features">💻 Features</a> •
  <a href="#prerequisites">Prerequisites</a> •
  <a href="#requirements">Requirements</a> •
  <a href="#starting">Starting</a> •
  <a href="#license">:memo: License</a> •
  <a href="#contact">:mailbox_with_mail: Contact</a> •
  <a href="#acknowledgments">Acknowledgments</a>  
</p>

<!-- TABLE OF CONTENTS DETAIL -->
<details>
  <summary>Table of Contents Detail</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">:rocket: Built With</a></li>
      </ul>
    </li>
    <li><a href="#features">💻 Features</a></li>
    <li><a href="#prerequisites">Prerequisites</a></li>
    <li><a href="#requirements">Requirements</a></li>
    <li>
      <a href="#starting">Getting Started</a>
      <ul>
        <li><a href="#install">🛠️ Installation Steps</a></li>
        <li><a href="#running">:zap: Running...</a></li>
      </ul>
    </li>
    <li><a href="#license">:memo: License</a></li>
    <li><a href="#contact">:mailbox_with_mail: Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## About The Project

An order control system for a fast food restaurant, which will manage orders and stock.

#### __FIRST SPRINT__ / phase1 branch
__(1)__ A backend application (`monolithic`) developed using `Ports and Adapters Architecture` (_Hexagonal Architecture_), the APIs should have the following capabilities:
- Customer registration; 
- Customer identification by personal ID;
- Insert, update and delete products;
- Find products by category (`burger`, `drink`, `side` and `dessert`);
- Order Checkout (fake) - Only send the order to the queue received** after the checkout( successfully), initially we will use queues in any database.

Order Tracking (queries):
- `Received`** : Payment made successfully;
- `Preparing` : In progress in the kitchen;
- `Ready` : Available for pickup by the customer;
- `Finished` : Delivered to the customer.

__(2)__ The application must be delivered with a Dockerfile configured to run correctly. For validation we will have the following infra restrictions:
- 1 instance for database;
- 1 instance to run the application;


#### __SECOND SPRINT__ / phase2 branch







Let's do it?

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<a name="built-with"></a>
### :rocket: Built With
This project was developed with the following technology:

[![Springboot][springboot-shield]][springboot-url] [![Java][java-shield]][java-url] [![Swagger][swagger-shield]][swagger-url] [![Postgresql][postgresql-shield]][postgresql-url] [![Docker][docker-shield]][docker-url] [![Heroku][heroku-shield]][heroku-url]
<!-- [![Editor-Config][editor-config-shield]][editor-config-url] -->

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<a name="features"></a>
## 💻 Features

The project's structure is as follows:: 
```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── fiappostech
│   │   │           └── fastfood
│   │   │               ├── adapters
│   │   │               │   ├── inbound
│   │   │               │   │   └── dto
│   │   │               │   │       ├── request
│   │   │               │   │       └── response
│   │   │               │   └── outbound
│   │   │               │       ├── entity
│   │   │               │       ├── projection
│   │   │               │       └── repository
│   │   │               ├── application
│   │   │               │   ├── core
│   │   │               │   │   ├── domain
│   │   │               │   │   ├── usecase
│   │   │               │   │   └── valueobject
│   │   │               │   └── ports
│   │   │               │       ├── dto
│   │   │               │       │   ├── request
│   │   │               │       │   └── response
│   │   │               │       ├── exception
│   │   │               │       ├── inbound
│   │   │               │       └── outbound
│   │   │               └── config
│   │   │                   ├── exception
│   │   │                   └── swagger
│   │   └── resources
.   .
```
#### Adapters 
They are the implementation of your external dependencies (user interface/inbound and infrastructure/outbound)
- `inbound`: this is where all our controllers are.
- `outbound`: this is where all our external integrations are (repository, API integration and etc).

#### Application
Here we have all our classes that don't have any dependency, including framework dependencies.
- `core/domain`: this is where all __domains__ are.
- `core/usecase`: this is where the implementation of the internal services (__usecases__) are.
- `core/valueobjects`: this is where all __value objects__ are.
- `ports/inbound`: this is where our `input interfaces`, that represents our internal services (usecases) are.
- `ports/outbound`: this is where our `output interfces`, that represents external services are. Note that here we do not have any naming connected to the technologies.

#### Disclaimer
This is only an way of how to implement the structure of the ports and adapters architecture (hexagonal architecture).

Your biggest concern should be to make good use of the concepts of ports and adapters, which is fully connected with the inversion of dependencies. Furthermore, it is important to respect the fact that your internal services (usecases), interfaces (ports) and domains must not have any external dependencies (including with the framework).

The idea is that your business rule is fully protected from these external factors.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Prerequisites

For this project you should to have basic konwledgement about: 
- Java and Springboot / Spring;
- Http verbs, request and response;
- Basic knowledgement about request's parameters;
- Basic knowledgement about SGDB;

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Requirements

For this project you will need:
- `Docker` ||
- `JDK 17` &&
- `PostegreSql 15`.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<a name="starting"></a>
## Getting Start
To get a local copy and run the project with `Docker`, follow these simple steps.

<a name="install"></a>
### 🛠️ Installation Steps
1. Clone the repository
```Bash
git clone git@github.com:sidneyaquino/fiappostech-techchallenge-fastfood-springboot.git
```
2. Go into the project folder

<a name="running"></a>
### :zap: Runnig...
In the projet folder execute the commands:
```bash
docker compose up     # download the app and database images and then run them.
```
or
```bash
docker compose build  # build app image.
docker compose up     # download only the database image and then run them.
```
or
```bash
docker compose -f docker-compose-dev.yml up   # download the database and jdk17 images, then run the database and build app with the command `./mvnw springboot:run`
```
Then it's now possible to access the project here: http://localhost:8080/swagger-ui/index.html

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<a name="license"></a>
## :memo: License
This project is under the MIT license. See the file [LICENSE](LICENSE.md) for more details.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<a name="contact"></a>
## :mailbox_with_mail: Contact
Made by *Sidney Aquino*, **get in Touch!**  [![LinkedIn][linkedin-shield]][linkedin-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Acknowledgments
>[FIAP POSTECH - Postgraduate Diploma in Software Architecture (360 Hours)](https://postech.fiap.com.br/curso/software-architecture/)

`Master` practical knowledge of `software development` and `architecture` to work on projects with high levels of complexity using `microservices`, `containers`, `serverless applications`, `secure development` and more. Expand your `technical knowledge`, incorporate the latest skills and prepare for the next phase of your `software development` career.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[java-shield]: https://img.shields.io/badge/Java-17-C74634?style=for-the-badge&logo=openjdk&logoColor=white
[java-url]: https://openjdk.org/

<!-- Color 6db33f or 43853D -->
[springboot-shield]: https://img.shields.io/badge/SpringBoot-3.1-6db33f?style=for-the-badge&logo=springboot&logoColor=white
[springboot-url]: https://spring.io/

[postgresql-shield]: https://img.shields.io/badge/Postgresql-15-336791?style=for-the-badge&logo=postgresql&logoColor=white
[postgresql-url]: https://www.postgresql.org/

<!-- Dark Color 384d54 and 0db7ed -->
[docker-shield]: https://img.shields.io/badge/Docker-384d54?style=for-the-badge&logo=docker&logoColor=white
[docker-url]: https://www.docker.com/

[heroku-shield]: https://img.shields.io/badge/Heroku-6567a5?style=for-the-badge&logo=heroku&logoColor=white
[heroku-url]: http://www.heroku.com/

[swagger-shield]: https://img.shields.io/badge/Swagger-2.1-19b6b5?style=for-the-badge&logo=swagger&logoColor=white
[swagger-url]: https://springdoc.org/

[editor-config-shield]: https://img.shields.io/badge/Editor%20Config-E0EFEF?style=for-the-badge&logo=editorconfig&logoColor=000
[editor-config-url]: https://editorconfig.org/

<!-- [linkedin-shield]: https://img.shields.io/badge/-LinkedIn-0db7ed.svg?style=for-the-badge&logo=linkedin&colorB=555 -->
[linkedin-shield]: https://img.shields.io/badge/Linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white
[linkedin-url]: https://de.linkedin.com/in/sidneydeaquino