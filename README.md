
# MovieHub

MovieHub is a simple web application that allows users to browse a list of movies and view detailed information about each title.

This repository contains the backend API, built with Java & Spring Boot, which provides the data consumed by the React frontend.

## Project Structure
```
src/main/java/...
   ├── controller
   ├── rest_controller
   ├── model
   ├── repository
   ├── service
   ├── security
   └── SpringBackendMovieApplication.java
   src/main/resources
   ├── templates
   └── static
```
## Run Locally

Clone the project

```bash
  git clone https://github.com/arielmusa/plaza-todo.git
```

Go to the project directory

```bash
  cd my-project
```

Run the project

```bash
mvn install
mvn spring-boot:run
```

The admin backoffice is accessible at:
http://localhost:8080/login
