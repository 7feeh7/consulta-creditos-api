# consulta-creditos-api

API RESTful para consulta de créditos fiscais, com front-end Angular, mensageria Kafka, containerizados com Docker. Projeto seguindo boas práticas de Clean Code, SOLID e MVC.

## Tecnologias

- [Node.js](https://nodejs.org/en/)
- [TypeScript](https://www.typescriptlang.org/)
- [Express](https://expressjs.com/pt-br/)
- [MongoDB](https://www.mongodb.com/)
- [Redis](https://redis.io/)
- 
- 
- [Java 21+](https://www.java.com/pt-BR/)
- [Spring Data JPA / Hibernate](https://spring.io/projects/spring-data)
- [PostgreSQL](https://www.postgresql.org/)
- [Angular 17+](https://angular.dev/)
- [Apache Kafka](https://kafka.apache.org/)
- [Docker](https://www.docker.com/)
- [JUnit & Mockito](https://junit.org/)

## Arquitetura

Abaixo, um diagrama simplificado mostrando o uso do projeto:

<img width="1393" height="660" alt="consulta-creditos-api" src="https://github.com/user-attachments/assets/1789ca60-b730-4803-9747-419a576b1b00" />

## Features

- [x] Consultar créditos por número da NFS-e
- [x] Consultar crédito por número do crédito
- [x] Dados mockados em PostgreSQL via script
- [x] Eventos publicados em Kafka a cada consulta
- [x] Front-end Angular para busca e exibição dos dados
- [x] API e frontend containerizados com Docker
- [x] Documentação com Swagger
- [x] Testes unitários com JUnit e Mockito

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- Docker & Docker Compose
- (Opcional) Java 21+ e Maven
- (Opcional) Node.js e Angular CLI

## Instalação rápida (com Docker)

1. Clonar o repositório:

   ```bash
   git clone https://github.com/7feeh7/checkout-service.git
   ```

2. Subindo o projeto com Docker:

   ```bash
   docker-compose up --build
   ```

3. Agora deve estar em execução:
- API: http://localhost:8080
- Frontend: http://localhost:4200
- Swagger: http://localhost:8080/swagger-ui.html
- Banco: localhost:5433 (postgres/postgres, base: creditos)
- Kafka: localhost:9092

## Documentação

A documentação da API deve esta indisponível no link local: http://localhost:8080/swagger-ui.html.

## Contribuindo

Contribuições para o projeto são bem vindas! Pra contribuir com o projeto, siga estas etapas:

1. De um fork no repositorio.
2. Crie uma nova branch para sua feature ou bug fix.
3. Faça suas alterações, confirmando e pressionando conforme necessário.
4. Envie uma solicitação pull com uma descrição detalhada de suas alterações.

## Contato

Para qualquer dúvida ou consulta, entre em contato com [Felipe](mailto:felipe.pires.soaresti@gmail.com).

Sinta-se à vontade para entrar em contato conosco se tiver algum comentário, sugestão ou se encontrar algum problema ao usar o projeto. Sua opinião é valiosa para nós e nos ajuda a melhorar a aplicação.
