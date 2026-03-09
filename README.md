# Order API - Desafio Técnico

API REST para gerenciamento de pedidos desenvolvida em **Java com Spring
Boot**, utilizando **PostgreSQL** para persistência de dados e **Swagger
(OpenAPI)** para documentação.

O projeto implementa **CRUD completo de pedidos**, com transformação de
dados conforme solicitado no desafio.

------------------------------------------------------------------------

# Tecnologias

-   Java 17
-   Spring Boot
-   Spring Data JPA
-   PostgreSQL
-   Maven
-   Swagger / OpenAPI
-   Lombok

------------------------------------------------------------------------

# Arquitetura

O projeto segue **arquitetura em camadas**, padrão usado em empresas:

    controller  → endpoints da API
    service     → regras de negócio
    repository  → acesso ao banco
    entity      → entidades JPA
    dto         → objetos de transferência
    mapper      → conversão DTO ↔ Entity
    exception   → tratamento global de erros
    config      → configurações da aplicação

------------------------------------------------------------------------

# Estrutura do Projeto

    src/main/java/com/luizcrisanto/orderapi

    controller/
        OrderController.java

    service/
        OrderService.java

    repository/
        OrderRepository.java

    entity/
        Order.java
        Item.java

    dto/
        OrderRequestDTO.java
        OrderResponseDTO.java
        ItemRequestDTO.java
        ItemResponseDTO.java

    mapper/
        OrderMapper.java

    exception/
        GlobalExceptionHandler.java
        OrderNotFoundException.java

    config/
        OpenApiConfig.java

------------------------------------------------------------------------

# Configuração do Banco de Dados

Arquivo:

    src/main/resources/application.properties

Exemplo:

    spring.datasource.url=jdbc:postgresql://localhost:5432/orderdb
    spring.datasource.username=postgres
    spring.datasource.password=123456

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

    server.port=3000

------------------------------------------------------------------------

# Como executar o projeto

### 1. Clonar o repositório

    git clone https://github.com/seu-usuario/order-api-java-desafio.git

### 2. Entrar na pasta

    cd order-api-java-desafio

### 3. Rodar aplicação

Linux / Mac:

    ./mvnw spring-boot:run

Windows:

    mvnw spring-boot:run

Servidor inicia em:

    http://localhost:3000

------------------------------------------------------------------------

# Documentação da API

Swagger disponível em:

    http://localhost:3000/swagger-ui/index.html

Swagger permite testar todos os endpoints diretamente no navegador.

------------------------------------------------------------------------

# Endpoints

## Criar pedido

    POST /order

Exemplo request:

``` json
{
  "numeroPedido": "v10089015vdb-01",
  "dataCriacao": "2026-03-09T12:00:00Z",
  "valorTotal": 100.0,
  "items": [
    {
      "idItem": "1",
      "quantidadeItem": 2,
      "valorItem": 50
    }
  ]
}
```

------------------------------------------------------------------------

## Buscar pedido

    GET /order/{orderId}

------------------------------------------------------------------------

## Listar pedidos

    GET /order/list

------------------------------------------------------------------------

## Atualizar pedido

    PUT /order/{orderId}

------------------------------------------------------------------------

## Deletar pedido

    DELETE /order/{orderId}

------------------------------------------------------------------------

# Regras de Transformação

  Entrada          Saída
  ---------------- --------------
  numeroPedido     orderId
  valorTotal       value
  dataCriacao      creationDate
  idItem           productId
  quantidadeItem   quantity
  valorItem        price

Exemplo:

Entrada:

    numeroPedido: v10089015vdb-01

Resultado salvo:

    orderId: v10089015vdb

------------------------------------------------------------------------

# Tratamento Global de Erros

A API utiliza:

    @RestControllerAdvice

Exemplo resposta de erro:

``` json
{
 "timestamp": "2026-03-09T12:45:01",
 "status": 404,
 "error": "Not Found",
 "message": "Pedido não encontrado com id: v10089015vdb",
 "path": "/order/v10089015vdb"
}
```

------------------------------------------------------------------------

# Ajustes Profissionais (nível empresa)

Duas melhorias simples que deixam o projeto mais profissional.

## 1. Validação de DTO

Adicionar validações:

    @NotBlank
    @NotNull
    @NotEmpty
    @Valid

Exemplo:

``` java
@NotBlank(message = "numeroPedido é obrigatório")
private String numeroPedido;
```

------------------------------------------------------------------------

## 2. Padronização de erros da API

Estrutura de resposta de erro:

    timestamp
    status
    error
    message
    path

Implementado via `GlobalExceptionHandler`.

------------------------------------------------------------------------

# Autor

Luiz Crisanto\
Desenvolvedor Backend Java\
Recife - PE

GitHub: https://github.com/luizcrisantoo

LinkedIn: https://www.linkedin.com/in/luizcrisanto/
