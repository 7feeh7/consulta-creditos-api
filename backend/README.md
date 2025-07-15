# Consulta de Créditos API

API RESTful desenvolvida em Spring Boot para consulta de créditos constituídos, conforme desafio técnico.

## Funcionalidades

- Consultar créditos por número da NFS-e
- Consultar crédito por número do crédito constituído
- Documentação interativa com Swagger

## Tecnologias

- [Java 21](https://www.java.com/pt-BR/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA / Hibernate](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL](https://www.postgresql.org/) (via Docker)
- [Docker](https://www.docker.com/)
- [Swagger](https://swagger.io/)
- JUnit, Mockito (testes)

## Pré-requisitos

- [Docker](https://www.docker.com/)
- [Java 21+](https://adoptium.net/) (para rodar localmente fora do Docker)
- [Maven](https://maven.apache.org/) 

## Rodando o projeto

1. Suba o banco de dados (PostgreSQL) com Docker

   docker-compose up -d

   O banco estará disponível em localhost:5433 (confira no seu docker-compose).

2. Rode a aplicação Spring Boot

   Com Maven wrapper:
      ./mvnw spring-boot:run

   Ou rode a aplicação diretamente pela IDE (IntelliJ, Eclipse, VSCode).

3. Acesse a API

   Documentação Swagger UI:
   http://localhost:8080/swagger-ui.html
   ou
   http://localhost:8080/swagger-ui/index.html

   Endpoints principais:
     - Consultar créditos por NFS-e:
       GET /api/creditos/{numeroNfse}
     - Consultar crédito por número:
       GET /api/creditos/credito/{numeroCredito}

4. Executando os testes

   ./mvnw test

## Configuração do Banco (application.properties)

- URL: jdbc:postgresql://localhost:5433/creditos
- Usuário: postgres
- Senha: postgres

O script de criação da tabela e dados iniciais está no diretório /scripts.

Documentação da API

Acesse o Swagger para visualizar e testar todos os endpoints e modelos da API.

## Observações

- Este projeto é parte de um desafio técnico e não representa uma aplicação pronta para produção.
- Testes automatizados de service e controller estão implementados.
- Em caso de dúvidas, consulte o código ou abra uma issue!
