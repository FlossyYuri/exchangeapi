<div id="top"></div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://exchange-rate-yuri.herokuapp.com/swagger-ui.html">
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1200px-Spring_Framework_Logo_2018.svg.png" alt="Logo" height="80">
  </a>

<h3 align="center"><strong>Exchange Rate API</strong></h3>

  <p align="center">
    An app that allows you to store people and their contacts.
    <br />
    <a href="https://exchange-rate-yuri.herokuapp.com/swagger-ui.html">Open API Documentation</a>
    ·
    <a href="mailto:emerson.yur@gmail.com">Get in touch</a>
  </p>
</div>


<!-- ABOUT THE PROJECT -->

## About The Project


An RestAPI that allows you to consult currencies exchange rates and manage Currencies, Rate And History.


### Built With

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Project Lombok](https://projectlombok.org/)
- [H2 Database Engine](https://www.h2database.com/html/main.html)
- [ExchangeRate-API](https://www.exchangerate-api.com/)
- [SpringDoc OpenAPI](https://springdoc.org/)
- [Swagger UI](https://swagger.io/)


<!-- GETTING STARTED -->

## Getting Started
To get a local copy up and running follow these simple steps:

### Prerequisites
Before trying to run the project you should have installed [Adopt Open JDK](https://adoptopenjdk.net/) And [Maven](https://maven.apache.org/download.cgi).

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/FlossyYuri/exchangeapi.git
   ```

2. Enter the backend folder
   ```sh
   cd exchangeapi
   ```
3. Install maven packages and Build Jar
   ```sh
   mvnw clean install -DskipTests
   ```
4. Run Project
   ```sh
   java -jar target/exchangeapi-0.0.1-SNAPSHOT.jar
   ```
5. Access API from
   ```sh
   http://localhost:8080
   ```
6. Access API Documentation From
   ```sh
   http://localhost:8080/swagger-ui.html
   ```

<!-- Requirements -->

## Requirements

- [x] Manage Currencies
    - [x] Currency CRUD
    - [x] Fetch currencies from Exchange Rate API
    - [x] Save Currencies in memory on Start
    - [x] Validate Fields (With custom Error Handling)
- [x] Manage Rates
    - [x] Rate CRUD
    - [x] Fetch USD Exchange rate with all currencies
    - [ ] Calculate Exchange rate for other currencies
    - [x] Validate Fields (With custom Error Handling)
- [x] Manage History
  - [x] Register history
  - [x] Find history data by code
- [x] Get exchange rate by Pair of currency codes
- [x] Get the latest Exchange Rates of a currency
- [x] Implement Swagger Documentation

<!-- CONTACT -->

## Contact

Émerson Yuri Cuambe - [LinkedIn](https://www.linkedin.com/in/emerson-yuri-1b9562113/) - [Email](email@email_client.com)

Project Link: [https://exchange-rate-yuri.herokuapp.com/swagger-ui.html/](https://exchange-rate-yuri.herokuapp.com/swagger-ui.html)

<p align="right">(<a href="#top">back to top</a>)</p>
