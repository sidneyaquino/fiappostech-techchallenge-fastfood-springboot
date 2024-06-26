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
  STATUS: 🚧 Man At Work...
</h4>

<!-- TABLE OF CONTENTS DETAIL -->
<p align="center">
  <a href="#about-the-project">About</a> •
  <a href="#features">💻 Features</a> •
  <a href="#built-with">:rocket: Built With</a> •
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
        <li><a href="#prerequisites">Prerequisites</a></li>
      </ul>
    </li>
    <li><a href="#features">💻 Features</a></li>
    <li><a href="#built-with">:rocket: Built With</a></li>
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

---
### __FIRST SPRINT__ / phase1 branch
__(1)__ A backend application (`monolithic`):
- [x] Application should be developed using `Ports and Adapters Architecture` (_Hexagonal Architecture_). 

_The APIs should have the following capabilities_:
- [x] Customer registration; 
- [x] Customer identification by Personal ID;
- [x] Insert, update and delete Products;
- [x] Find Products by Category (`burger`, `drink`, `side` and `dessert`);
- [x] (fake) Order Checkout: send the order to the queue `received` after the checkout( successfully_), initially we will use queues in any database.

_Order Tracking (queries)_:
- [x] `received` : Payment made successfully;
- `preparing` : In progress in the kitchen;
- `ready` : Available for pickup by the customer;
- `finished` : Delivered to the customer.

__(2)__ The application must be delivered with `Dockerfile` and `docker-compose` configured to run correctly. For validation we will have the following infra restrictions:
- [x] 1 instance to run the `application`;
- [x] 1 instance for `database`.

---
### __SECOND SPRINT__ / phase2 branch
__(1)__ A backend application (`monolithic`):
- [x] Update the application developed in __phase1__ by refactoring the code to follow `Clean Code` and `Clean Architecture` standards.

_The APIs should have the following capabilities_:
- [x] Order Checkout: which should receive the Products Ordered and return the Order ID;
- [x] Check Order Payment Status: Payment has been approved or not;
- [x] `Webhook` to receive confirmation: Approved Payment or Declined Payment;
- [x] Order List should return Orders with their descriptions, sorted by Tracking with the following priority: 
>  **undelivered** : `ready`  **>**  `preparation`  **>**  `received`

**NOTE**: `finalized` tracking should NOT appear in the list;
- [x] Update the Order Tracking.

_Order Tracking (queries)_:
- `received` : Payment made successfully;
- [x] `preparing` : In progress in the kitchen;
- [x] `ready` : Available for pickup by the customer;
- [x] `finished` : Delivered to the customer.

__(2)__ The application must be delivered with `k8s files` configured to run correctly. 
- [x] `Deployment` or `HPA` of the application with at least 2 `Pods`.
- [x] Service for `LoadBalancer`;
- [x] Configuration of the database credential via `Secret`.

_For validation we will have the following infra restrictions_:
- [x] 2 instances minimal to run the application;
- [x] 1 instance for `database`.

---
Let's do it?

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Prerequisites

For this project you should to have basic konwledgement about: 
- Java, Spring Boot and Spring Framework;
- Http verbs, status codes, request and response;
- Request's parameters;
- SQL language fundation;
- Containers and Kubernetes;
- Git, Github and Linux.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<a name="features"></a>
## 💻 Features

Project summary diagram:
```
+-----------------+
| 1. Interface    | Contains communication components:
| Adapters Layer  | controllers, presenters and gateways.
|                 |
| - Presenter     | Receives and returns data to internal api (user interface).
|   (Controller)  | 
| - Gateway       | It's a middleware for external dependencies,
|   (Repository)  | when communicating with the database.
+-----------------+
        │
        v 
+-----------------+
| 2. Application/ | Responsible for implementing 
| Use Cases Layer | the application's business logic.
|                 |
| - Interactor /  | Interactor is the component that implements a UseCase,
|   UseCase       | contains the business logic that coordinates the flow.
| - Exception     | Error handling for business rules.
+-----------------+
        │
        v 
+-----------------+
| 3. Domain /     | 
| Entities Layer  | Enterprise Business Rules.
| - Entity        | 
| - Value Object  | 
| - DTO           | Anemic entities used outside the domain.
| (Data Transfer) | (protects business rules)
+-----------------+
        ^
        │ 
+-----------------+
| 4. Frameworks & | It is responsible for communicating with external systems. 
| Drives Layer    | that provide concrete implementations of the interfaces.
|                 |
| - Web Framework | 
|   (API)         | Presenter handles HTTP requests and returns HTTP responses 
| - Database      | 
|   (Repository)  | Persistence
+-----------------+
```

The project's structure is as follows:: 
```
:
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── fiappostech
│   │   │           └── fastfood
│   │   │               ├── adapter
│   │   │               │   ├── gateway
│   │   │               │   │   ├── .. 
│   │   │               │   │   :   
│   │   │               │   └── presenter
│   │   │               │       ├── ..
│   │   │               │       :
│   │   │               ├── application
│   │   │               │   ├── exception
│   │   │               │   └── usecase
│   │   │               │       ├── ..
│   │   │               │       :
│   │   │               ├── domain
│   │   │               │   ├── entity
│   │   │               │   ├── valueobject
│   │   │               │   └── dto
│   │   │               │       ├── ..
│   │   │               │       :
│   │   │               └── infrastructure
│   │   │                   ├── api
│   │   │                   │   ├── ..
│   │   │                   │   :
│   │   │                   ├── config
│   │   │                   │   ├── ..
│   │   │                   │   :
│   │   │                   ├── exception
│   │   │                   └── persistence
│   │   │                       ├── ..
│   │   │                       :
│   │   └── resources
│   │       └── db
│   │           └── migration
:   :
```
Here we have the packages with all our classes that `DON'T have any dependencies`, including libraries and the framework dependencies.

#### 1. Interface Adapters Layer (adapter)
**Broker** for external dependencies.
- `adapter/presenter`: this is where all our controllers (user interface) are.
- `adapter/gateway`: this is where all our repositories (database persistence) are.
#### 2. Application Bussines Rules Layer (application)
- `application/usecase`: this is where all our interactors (implementing __usecases__) are.
#### 3. Enterprise Bussines Rules Layer (domain)
- `domain/entity`: this is where all __domains__ are.
- `domain/valueobject`: this is where all __value objects__ are.
- `domain/dto`: this is where our `abstraction` entity, that represents __entities__  outside the domain (protects business rules). 

Now we have the packages with all our classes that `HAVE library and/or framework dependencies`, such as web, ui, devices, datababe and external interfaces.
#### 4. Frameworks & Drives Layer (infrastructure)
**Implementation** of external integration dependencies.
- `infrastructure/api`: this is where all our api controllers (user interface) are located.
- `infrastructure/persistence`: this is where our entire persistence repository (database) is located.
---

#### Disclaimer
This is only an way of how to implement the structure of the Clean Architecture.

The main focus should be on making good use of the concepts of separation of concerns, independence from frameworks and libraries, testability, dependency inversion, outer layers depend on inner layers (as per the direction of the arrows) and domain-centred design. It's important to respect the fact that the domain, application and adapter layers can't have any external dependencies (including with the focus on the framework).

<span style="display:block;text-align:center">![Similarities between hexagonal architecture (ports and adapters) and clean architecture ](./assets/archtectures.png)</span>

The idea is that your business rule is fully protected from these external factors, understand the architectures, their similarities, adapt them to your needs and "*Go Horse!!*".  ;-)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<a name="built-with"></a>
## :rocket: Built With
This project was developed with the following technology:

[![Springboot][springboot-shield]][springboot-url] [![Java][java-shield]][java-url] [![Maven][maven-shield]][maven-url] [![Swagger][swagger-shield]][swagger-url] [![flyway][flyway-shield]][flyway-url] [![Postgresql][postgresql-shield]][postgresql-url] [![K6][k6-shield]][k6-url] [![Podman][podman-shield]][podman-url] [![kubernetes][kubernetes-shield]][kubernetes-url] [![openshift][openshift-shield]][openshift-url]


<!-- [![prometheus][prometheus-shield]][prometheus-url]  -->
<!-- [![grafana][grafana-shield]][grafana-url] -->
<!-- [![Editor-Config][editor-config-shield]][editor-config-url] -->

#### **Spring**  ([spring.io](https://spring.io/))

-   **[Bean Validation](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html)**
-   **[Lombok](https://projectlombok.org/)**
-   **[Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)**
-   **[Spring Boot Devtools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)**
-   **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)**
-   **[Spring Web MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)**

> See the file:  [pom.xml](https://github.com/sidneyaquino/fiappostech-techchallenge-fastfood-springboot/blob/main/pom.xml)

#### **Utility Software**

-   Editor:  **[Visual Studio Code](https://code.visualstudio.com/)** 
-   API Client:  **[Postman](https://www.postman.com/)** or **[RESTClient for VSCode](https://www.postman.com/)**
-   Markdown:  **[Obsidian](https://obsidian.md/)** or **[Markdown Preview Enhanced](https://github.com/shd101wyy/vscode-markdown-preview-enhanced)**
-   Database Manager:  **[DbGate](https://dbgate.org/)**
-   Container Tool:  **[Podman](https://podman.io/)** or **[Docker](https://www.docker.com/)**
-   Kubernetes:  **[Minikube](https://minikube.sigs.k8s.io/docs/)** and **[k9s](https://k9scli.io/)**
-   Terminal emulator:  **[Alacritty](https://alacritty.org/)**
-   Command Line: **[asdf](https://asdf-vm.com/)**, **[git](https://git-scm.com/)**, **[helm](https://helm.sh/)**, **[kubectl](https://kubernetes.io/docs/reference/kubectl/)**, **[oc](https://docs.openshift.com/container-platform/4.11/cli_reference/openshift_cli/getting-started-cli.html)**, **[stern](https://github.com/stern/stern)**, **[dive](https://gochronicles.com/dive/)**, **[grype](https://github.com/anchore/grype)**, **[trivy](https://aquasecurity.github.io/trivy)**  and others...

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Requirements

For run this project, you will need:
- `docker v24` __&&__ `docker-compose v2.20` __||__
- `docker v24` __&&__ `minikube v1.30` __&&__ `kubectl v1.27`

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

---
<a name="running"></a>
### :zap: Runnig...

##### 1.1. __Docker__ - smart choice! o/
In the projet folder execute the commands:
```bash
docker-compose up     # download the app and database images and then run them.
```
or
```bash
docker-compose build  # build app image.
docker-compose up     # download only the database image and then run them.
```

Then it's now possible to access the project here: http://localhost:8080/swagger-ui/index.html

or

##### 1.2. __Kubernetes__ - best choice! \o/
In the projet folder execute the commands:
```bash
minikube start --container-runtime=containerd
minikube addons enable csi-hostpath-driver
minikube addons enable volumesnapshots
minikube addons enable metrics-server
kubectl apply -f k8s/infra/data-pvc.yaml
kubectl apply -f k8s/data
kubectl apply -f k8s/app
minikube tunnel --bind-address='localhost'
```
Then it's now possible to access the project here: http://localhost:8080/swagger-ui/index.html

---
##### 2. __API access using Postman__ 
You can fork the "_Public Postman Workspace_" here: [![Fastfood WorkSpace][fastfood-workspace-shield]][fastfood-workspace-url]

It is also possible to import a copy or fork each collection individually:

[![Customers Collection][customers-collection-shield]][customers-collection-url] [![Orders Collection][orders-collection-shield]][orders-collection-url] [![Payment Collection][payment-collection-shield]][payment-collection-url] [![Products Collection][products-collection-shield]][products-collection-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<a name="license"></a>
## :memo: License
This project is under the MIT license. See the file [LICENSE](https://github.com/sidneyaquino/fiappostech-techchallenge-fastfood-springboot/blob/main/LICENSE) for more details.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<a name="contact"></a>
## :mailbox_with_mail: Contact
Made by *Sidney Aquino*, **get in Touch!**  [![LinkedIn][linkedin-shield]][linkedin-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Acknowledgments
>[FIAP POSTECH - Postgraduate Diploma in Software Architecture (360 hours in 1 year)](https://postech.fiap.com.br/curso/software-architecture/)

`Master` practical knowledge of `software development` and `architecture` to work on projects with high levels of complexity using `microservices`, `containers`, `serverless applications`, `secure development` and more. Expand your `technical knowledge`, incorporate the latest skills and prepare for the next phase of your `software development` career.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[java-shield]: https://img.shields.io/badge/Java-21-C74634?style=for-the-badge&logo=openjdk&logoColor=white
[java-url]: https://openjdk.org/

[maven-shield]: https://img.shields.io/badge/Maven-3.9-EE3A43?style=for-the-badge&logo=apache&logoColor=white
[maven-url]: https://maven.apache.org/

<!-- Color 6db33f or 43853D -->
[springboot-shield]: https://img.shields.io/badge/SpringBoot-3.2-6db33f?style=for-the-badge&logo=springboot&logoColor=white
[springboot-url]: https://spring.io/projects/spring-boot

[postgresql-shield]: https://img.shields.io/badge/Postgresql-16-336791?style=for-the-badge&logo=postgresql&logoColor=white
[postgresql-url]: https://www.postgresql.org/

[flyway-shield]: https://img.shields.io/badge/Flyway-9.22-cc0000?style=for-the-badge&logo=flyway&logoColor=white
[flyway-url]: https://flywaydb.org/

<!-- Dark Color 384d54 and 0db7ed -->
[docker-shield]: https://img.shields.io/badge/Docker-24-384d54?style=for-the-badge&logo=docker&logoColor=white
[docker-url]: https://www.docker.com/

[podman-shield]: https://img.shields.io/badge/Podman-4.6-8d33a3?style=for-the-badge&logo=podman&logoColor=white
[podman-url]: https://podman.io/

[heroku-shield]: https://img.shields.io/badge/Heroku-6567a5?style=for-the-badge&logo=heroku&logoColor=white
[heroku-url]: http://www.heroku.com/

[openshift-shield]: https://img.shields.io/badge/OpenShift-CC0000?style=for-the-badge&logo=redhat&logoColor=white
[openshift-url]: https://developers.redhat.com/developer-sandbox

[kubernetes-shield]: https://img.shields.io/badge/Kubernetes-0f3074?style=for-the-badge&logo=kubernetes&logoColor=white
[kubernetes-url]: https://kubernetes.io/

[swagger-shield]: https://img.shields.io/badge/Swagger-2.2-19b6b5?style=for-the-badge&logo=swagger&logoColor=white
[swagger-url]: https://springdoc.org/

[prometheus-shield]: https://img.shields.io/badge/Prometheus-dd4f2a?style=for-the-badge&logo=prometheus&logoColor=black
[prometheus-url]: https://prometheus.io/

[grafana-shield]: https://img.shields.io/badge/Grafana-ff671d?style=for-the-badge&logo=grafana&logoColor=black
[grafana-url]: https://grafana.com/

[k6-shield]: https://img.shields.io/badge/k6-0.47-7d64ff?style=for-the-badge&logo=k6&logoColor=white
[k6-url]: https://k6.io/

[editor-config-shield]: https://img.shields.io/badge/Editor%20Config-E0EFEF?style=for-the-badge&logo=editorconfig&logoColor=000
[editor-config-url]: https://editorconfig.org/

<!-- [linkedin-shield]: https://img.shields.io/badge/-LinkedIn-0db7ed.svg?style=for-the-badge&logo=linkedin&colorB=555 -->
[linkedin-shield]: https://img.shields.io/badge/Linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white
[linkedin-url]: https://de.linkedin.com/in/sidneydeaquino

<!-- Postman Workspace & Collections -->
[fastfood-workspace-shield]: https://img.shields.io/badge/Fastfood-ff6c37?style=for-the-badge&logo=postman&logoColor=white
[fastfood-workspace-url]: https://www.postman.com/sidneyaquino/workspace/fiappostech-techchallenge-fastfood-springboot

[customers-collection-shield]: https://img.shields.io/badge/Customers-262626?style=for-the-badge&logo=postman&logoColor=white
[customers-collection-url]: https://god.gw.postman.com/run-collection/1122292-f0346b97-be41-4775-bb4b-7a82ac1f8779?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D1122292-f0346b97-be41-4775-bb4b-7a82ac1f8779%26entityType%3Dcollection%26workspaceId%3D2ada5531-a649-402c-ad26-977b88d19424#?env%5BDev%20-%20Local%5D=W3sia2V5IjoidXJsIiwidmFsdWUiOiJsb2NhbGhvc3Q6ODA4MCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoibG9jYWxob3N0OjgwODAiLCJzZXNzaW9uSW5kZXgiOjB9LHsia2V5IjoicG9ydCIsInZhbHVlIjoiODA4MCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiODA4MCIsInNlc3Npb25JbmRleCI6MX1d

[orders-collection-shield]: https://img.shields.io/badge/Orders-262626?style=for-the-badge&logo=postman&logoColor=white
[orders-collection-url]: https://god.gw.postman.com/run-collection/1122292-5be35a0c-e38c-4bb0-9436-c3046e750359?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D1122292-5be35a0c-e38c-4bb0-9436-c3046e750359%26entityType%3Dcollection%26workspaceId%3D2ada5531-a649-402c-ad26-977b88d19424#?env%5BDev%20-%20Local%5D=W3sia2V5IjoidXJsIiwidmFsdWUiOiJsb2NhbGhvc3Q6ODA4MCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoibG9jYWxob3N0OjgwODAiLCJzZXNzaW9uSW5kZXgiOjB9LHsia2V5IjoicG9ydCIsInZhbHVlIjoiODA4MCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiODA4MCIsInNlc3Npb25JbmRleCI6MX1d

[payment-collection-shield]: https://img.shields.io/badge/Payment-262626?style=for-the-badge&logo=postman&logoColor=white
[payment-collection-url]: https://app.getpostman.com/run-collection/1122292-704611bf-7a1e-4328-865f-f9430f594a24?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D1122292-704611bf-7a1e-4328-865f-f9430f594a24%26entityType%3Dcollection%26workspaceId%3D2ada5531-a649-402c-ad26-977b88d19424#?env%5BDev%20-%20Local%5D=W3sia2V5IjoidXJsIiwidmFsdWUiOiJsb2NhbGhvc3Q6ODA4MCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoibG9jYWxob3N0OjgwODAiLCJzZXNzaW9uSW5kZXgiOjB9XQ==

[products-collection-shield]: https://img.shields.io/badge/Products-262626?style=for-the-badge&logo=postman&logoColor=white
[products-collection-url]: https://god.gw.postman.com/run-collection/1122292-bd981efd-7ffd-4d70-b1b5-92b721dd49ae?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D1122292-bd981efd-7ffd-4d70-b1b5-92b721dd49ae%26entityType%3Dcollection%26workspaceId%3D2ada5531-a649-402c-ad26-977b88d19424#?env%5BDev%20-%20Local%5D=W3sia2V5IjoidXJsIiwidmFsdWUiOiJsb2NhbGhvc3Q6ODA4MCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoibG9jYWxob3N0OjgwODAiLCJzZXNzaW9uSW5kZXgiOjB9LHsia2V5IjoicG9ydCIsInZhbHVlIjoiODA4MCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiODA4MCIsInNlc3Npb25JbmRleCI6MX1d