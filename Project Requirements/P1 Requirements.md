# Project 1

For Project 1, you will build a RESTful API that integrates with several other applications. You are also tasked with building these additional applications; each of these should have its own, unique data source(s). At least one of these additions must be a SOAP service.

The only application the client should interface with is your primary RESTful API. This means that all data must flow through this API, which then interacts with your other services.

You are allowed to come up with your own idea for your application, but your trainer must approve the idea. 

Some suggestions for application ideas include:

- Reimbursement Management System API
- Product Research and Development API
- Hotel Booking System API
- Airline Ticketing System API

## Required Features

- [ ] Documentation (all methods should have basic documentation)
- [ ] Unit testing (at least 30 unit tests)
- [ ] Logging
- [ ] 1 Java application that will serve as a public-facing REST API
- [ ] At least 2 additional Java applications that will handle parts of the logic
- [ ] At least 1 of the applications must be a SOAP service
- [ ] All services must have their own, unique data source(s)

## Stretch Goals
- [ ] Distributed transactions using a Spring JTA implementation
- [ ] At least 1 JMS Topic for applications to communicate
- [ ] At least 1 JMS Queue for applications to communicate

## Required Technologies

- [ ] Java
- [ ] JUnit
- [ ] Mockito
- [ ] Logback
- [ ] Git SCM (on GitHub)
- [ ] Spring Framework
- [ ] Spring Data JPA
- [ ] Spring JMS Template
- [ ] ActiveMQ
- [ ] REST
- [ ] SOAP
- [ ] Spring Transactions (JTA)

## Submitting Ideas for Trainer Approval

- Select a project idea and submit it to your trainer for approval. Be sure to include:
  - The (minimum) 3 applications that you will be using to handle business logic
  - Explanation of how REST, SOAP, JTA , and JMS will/could be used
- Once approved, create a new repository within this GitHub organization (naming convention: `firstname_lastname_p1`)

## Presentation

- [ ] 5 minute live demonstration of project