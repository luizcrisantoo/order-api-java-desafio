# Order API - Desafio Técnico

API REST para gerenciamento de pedidos desenvolvida em **Java com Spring
Boot** e **PostgreSQL**.

Este projeto foi desenvolvido como solução para um desafio técnico que
originalmente solicitava uma API em **Node.js**.\
A implementação foi realizada em **Java**, mantendo a mesma lógica de
negócio e requisitos funcionais do desafio.

------------------------------------------------------------------------

# Tecnologias utilizadas

-   Java 17
-   Spring Boot
-   Spring Data JPA
-   PostgreSQL
-   Maven
-   Swagger / OpenAPI
-   Lombok

------------------------------------------------------------------------

# Arquitetura do projeto

O projeto segue uma arquitetura em camadas comum em aplicações backend
profissionais.

Controller → Service → Repository → Database

## Estrutura de pacotes

controller\
service\
repository\
entity\
dto\
mapper\
exception

### Descrição das camadas

**Controller**\
Responsável por expor os endpoints da API.

**Service**\
Contém a lógica de negócio da aplicação.

**Repository**\
Responsável pela comunicação com o banco de dados utilizando Spring Data
JPA.

**Entity**\
Representação das tabelas do banco de dados.

**DTO**\
Objetos utilizados para transporte de dados entre cliente e API.

**Mapper**\
Responsável por transformar DTOs em Entities e vice-versa.

------------------------------------------------------------------------

# Banco de dados

Banco utilizado:

PostgreSQL

Nome do banco:

orderdb

------------------------------------------------------------------------

# Configuração do banco

Arquivo:

src/main/resources/application.properties

Exemplo de configuração:

spring.datasource.url=jdbc:postgresql://localhost:5432/orderdb
spring.datasource.username=postgres spring.datasource.password=123456

spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

------------------------------------------------------------------------

# Executando o projeto

## 1 - Clonar o repositório

git clone https://github.com/luizcrisantoo/order-api-java-desafio

## 2 - Entrar na pasta do projeto

cd orderapi

## 3 - Executar a aplicação

./mvnw spring-boot:run

A aplicação iniciará em:

http://localhost:3000

------------------------------------------------------------------------

# Estrutura da API

## Criar pedido

POST /order

### Exemplo de request

```json
{
  "numeroPedido": "v10089015vdb-01",
  "valorTotal": 10000,
  "dataCriacao": "2023-07-19T12:24:11",
  "items": [
    {
      "idItem": "2434",
      "quantidadeItem": 1,
      "valorItem": 1000
    }
  ]
}
------------------------------------------------------------------------

# Transformação de dados

O desafio exige que os dados recebidos sejam transformados antes de
serem armazenados no banco.

  Campo recebido   Campo salvo
  ---------------- --------------
  numeroPedido     orderId
  valorTotal       value
  dataCriacao      creationDate
  idItem           productId
  quantidadeItem   quantity
  valorItem        price

------------------------------------------------------------------------

# Endpoints da API

  Método   Endpoint      Descrição
  -------- ------------- -------------------------
  POST     /order        Criar novo pedido
  GET      /order/{id}   Buscar pedido por id
  GET      /order/list   Listar todos os pedidos
  PUT      /order/{id}   Atualizar pedido
  DELETE   /order/{id}   Remover pedido

------------------------------------------------------------------------

# Documentação da API

A API possui documentação interativa utilizando **Swagger (OpenAPI)**.

Após iniciar o projeto, acesse:

http://localhost:3000/swagger-ui.html

------------------------------------------------------------------------

# Melhorias implementadas

-   Arquitetura em camadas
-   DTO para separação entre API e banco
-   Transformação de dados entre request e entidade
-   Integração com PostgreSQL
-   Documentação automática da API com Swagger
-   Estrutura de commits organizada

------------------------------------------------------------------------

# Autor

Luiz Crisanto\
Desenvolvedor Backend Java

LinkedIn\
https://www.linkedin.com/in/luizcrisanto/
