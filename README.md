# Backend Engineer Assessment

**Finconecta**

## Part 1: Coding Exercises 

## Exercise 1: Java Spring CRUD Operations with MongoDB and PostgreSQL

A CRUD was created for 2 simple entities
User and Product, for the user the CRUD was created in MongoDB and for the product it was created in PostgreSQL, both were implemented with reactive programming with Spring WebFlux

## Exercise 2: AWS Infrastructure

The template is path src/main/resources/templates

## Part 2: Theoretical Questions

### Java Spring Framework
_a. Explain the concept of Dependency Injection (DI) and its importance in Spring._

Dependency Injection is a design pattern that allows an object's dependencies to be provided by an external container (ex: Library) rather than the object creating them itself.

The importance in spring: 
Decoupling: DI reduces coupling between components, making code maintenance and evolution easier.

Reusable code: Components can be reused in different contexts without having to modify them.

Easier testing: DI makes it easier to create unit tests.

Flexible configuration: With DI, it is easy to change dependency implementations without modifying the codebase.

_b. What is the difference between Spring MVC and Spring Boot? When would you choose
one over the other?_

Key differences:

Configuration: Spring MVC requires manual configuration, while Spring Boot uses default conventions and auto-configuration.

Embedded Server: Spring Boot includes an embedded server (such as Tomcat), while in Spring MVC, the server must be configured separately.

Autonomous Applications: Spring Boot allows you to create autonomous applications that can easily run without the need for an external application container.

When to choose one over the other:

Spring MVC: If you need fine-grained control over your application configuration or are working in an environment where there is already a configuration in place for web applications.

Spring Boot: If you are looking for speed in development, ease of configuration, and want to take advantage of a microservices-based approach or standalone applications.

### Databases: MongoDB and PostgreSQL

_a. Describe the main differences between MongoDB and PostgreSQL in terms of data
model, querying, and scalability._

#### Data Model:
MongoDB: It is a document-oriented NoSQL database. Data is stored in BSON documents (a binary representation of JSON) within collections. This allows for a more flexible data structure, ideal for hierarchical data.

PostgreSQL: It is a relational database (SQL). Data is stored in tables with rows and columns, following a defined schema that ensures data integrity through relationships, primary and foreign keys.

#### Queries:
MongoDB: It uses a specific query language based on JSON. It is ideal for queries that require flexibility and for operations that manipulate hierarchical data.

PostgreSQL: It uses SQL, a standard language for structured queries. It is very powerful for complex operations, joins, and guarantees referential integrity.

##### Scalability:
MongoDB: Designed to scale horizontally, that is, distributing data across multiple nodes (sharding).

PostgreSQL: While stronger at vertical scalability, it also supports some horizontal scalability with techniques such as replication and partitioning.

_b. When would you choose MongoDB over PostgreSQL, and vice versa, for a project?_

#### MongoDB: 

When a flexible or dynamic data schema is needed.

If the application handles large volumes of unstructured or semi-structured data.

When high horizontal scalability is required.

For real-time applications, such as recommendation systems, big data analytics, etc.

#### PostgreSQL:

When data integrity and transactional consistency are needed.

If the application requires complex SQL operations or queries involving joins and subqueries.

If strong support for advanced features such as ACID transactions, stored functions, triggers, etc. is needed.

### AWS Infrastructure
_a. Describe the difference between EC2 and ECS in AWS._

EC2 is a service that provides virtual machines in the cloud, offering full control over the computing environment, including the operating system, network, and storage. It is ideal for applications that need customization and control at the infrastructure level.

ECS is a service that allows you to run and manage Docker containers. ECS manages container orchestration, making it easy to deploy, scale, and monitor containerized applications without worrying about the underlying infrastructure.

In summary:
EC2 is a Virtual machines with full control over the infrastructure and ECS a Docker container orchestration and management, abstract of the infrastructure.

_b. How would you implement high availability and fault tolerance in an AWS
environment?_

To implement high availability and fault tolerance on AWS, you could follow these steps:

#### Regions and Availability Zones (AZs):
Deploy resources across multiple availability zones within a region to avoid single points of failure.
Use end-to-end load balancers (ELBs) to distribute traffic across instances in different AZs.

#### Auto Scaling:
Configure Auto Scaling to automatically launch new instances when load increases and terminate instances when load decreases, ensuring that sufficient resources are always available.

#### Databases:
Use Amazon RDS with Multi-AZ for relational databases, which ensures that a database replica is always available in another AZ in the event of a failure.
Set up replication to databases such as DynamoDB or MongoDB Atlas for high availability.

#### Backup and Recovery:
Implement regular backups of critical data.
Use Amazon S3 for data storage with replication across multiple AZs.

### Microservices and Kubernetes
_a. What are microservices, and what are the benefits of using a microservices
architecture?_

Microservices are an architectural style where an application is built as a set of small, autonomous services that run independently. Each microservice focuses on a specific functionality and communicates with other microservices through lightweight APIs, usually over HTTP/REST or asynchronous messaging.

Benefits: Independent Scalability: Each microservice can be scaled independently based on demand.

Isolated Deployment: Allows individual microservices to be deployed, updated, and rolled back without affecting the entire application.

Resilience: The failure of one microservice does not necessarily compromise the operation of the entire application.

Agile Development: Different teams can develop and deploy microservices independently, facilitating continuous delivery.

Heterogeneous Technology: Each microservice can be implemented in a different language or technology depending on the requirements of its specific functionality.

_b. Explain the role of Kubernetes in deploying and managing microservices. How does it
facilitate scalability and resilience?_

Kubernetes is an open source platform for container orchestration that automates the deployment, scaling, and operation of containerized applications. It is especially useful for managing microservices architectures.

Facilitating Scalability and Resilience: Automatic Scaling: Kubernetes can automatically scale microservice instances called pods.

Self-Repair: It constantly monitors the state of containers and can restart those that fail, ensuring continuous availability.

Fault Isolation: If a node fails, Kubernetes redistributes containers to other available nodes in the cluster, ensuring service continuity.

Configuration and Secrets Management: Facilitates centralized management of configurations and secret information.

## Part 3: Bonus Exercise (Optional)

### Exercise 4: Kubernetes Deployment

All yaml files in the root project