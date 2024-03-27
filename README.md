# Exemplo de Projeto API CRUD com o Framework Quarkus.

Este projeto serve como uma base de estudo para criar uma aplicação com o framework Quarkus. Ele implementa um CRUD utilizando o ORM Panache para simplificar o acesso aos dados, juntamente com RESTEasy para criar serviços RESTful, REST Client para consumir serviços REST externos e Flyway para gerenciar as migrações de banco de dados de forma automatizada. Ao seguir este exemplo, os desenvolvedores podem aprender a utilizar essas tecnologias em conjunto para construir aplicações Java eficientes e modernas com o Quarkus.

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Quarkus](https://pt.quarkus.io/)
- [Resteasy](https://pt.quarkus.io/guides/resteasy)
- [Pesteasy-Client](https://quarkus.io/guides/resteasy-client)
- [Panache](https://pt.quarkus.io/guides/hibernate-orm-panache)
- [Lombok](https://projectlombok.org/)


## R Running the application in dev mode

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

