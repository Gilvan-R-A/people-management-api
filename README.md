<h1 align="center">
   People Management API
</h1>

Este projeto é uma API RESTful construída em **Java** com **Spring Boot** utilizando **JPA** para persistência de dados e **H2** para o banco de dados em memória. Ele permite gerenciar informações de pessoas realizando operações CRUD (criar, listar, atualizar e excluir) registros de pessoas, bem como realizar a busca por ID.   

## Tecnologias Utilizadas   

- **Java 11**: Linguagem de programação utilizada para o desenvolvimento da API.
- **Spring Boot 2.7.1**: Framework utilizado para criação da API RESTful.
- **H2 Database**: Banco de dados em memória utilizado para desenvolvimento e testes.
- **Spring Data JPA**: Para interações com o banco de dados utilizando JPA (Java Persistence API).
- **Lombok**: Biblioteca que reduz o boilerplate code (como getters, setters, constructors).
- **MapStruct**: Biblioteca para mapeamento entre objetos (como DTOs e entidades).

## Funcionalidades   

- **Criar pessoa**: Permite adicionar uma nova pessoa ao banco de dados.
- **Listar todas as pessoas**: Retorna uma lista de todas as pessoas registradas.
- **Buscar por ID**: Permite buscar uma pessoa pelo seu ID.
- **Atualizar pessoa**: Permite atualizar as informações de uma pessoa existente.
- **Excluir pessoa**: Permite excluir uma pessoa do banco de dados.   



## Estrutura do Projeto   

O projeto é organizado da seguinte forma:   

```   
personapi/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── one/
│   │   │   │   └── digitalInnovation/
│   │   │   │       └── personapi/
│   │   │   │           ├── controller/        # Controladores REST
│   │   │   │           │   ├── PersonController.java
│   │   │   │           │   └── PersonControllerDocs.java
│   │   │   │           ├── dto/               # Data Transfer Objects
│   │   │   │           │   ├── request/
│   │   │   │           │   │   ├── PersonDTO.java
│   │   │   │           │   │   └── PhoneDTO.java
│   │   │   │           │   └── response/
│   │   │   │           │       └── MessageResponseDTO.java
│   │   │   │           ├── entity/            # Entidades JPA
│   │   │   │           │   ├── Person.java
│   │   │   │           │   └── Phone.java
│   │   │   │           ├── exception/         # Exceções personalizadas
│   │   │   │           │   └── PersonNotFoundException.java
│   │   │   │           ├── mapper/            # Mapeadores
│   │   │   │           │   └── PersonMapper.java
│   │   │   │           ├── repository/        # Repositórios JPA
│   │   │   │           │   └── PersonRepository.java
│   │   │   │           ├── service/           # Serviços
│   │   │   │           │   └── PersonService.java
│   │   ├── resources/    # Arquivos de configuração
│   │   │   └── application.properties
├── pom.xml               # Arquivo de configuração do Maven
├── Dockerfile            # Configurações Docker
├── docker-compose.yml    # Configurações Docker Compose
```   

 ## Como Rodar (com Maven)  

### Pré-requisitos   

- **Java 11** ou superior instalado.
- **Maven** para gerenciamento de dependências e construção do projeto.   

## Rodando a aplicação (Opção 1)  

1. Clone o repositório:   

```   
git clone https://github.com/Gilvan-R-A/people-management-api.git
```   

2. Navegue até o diretório do projeto:   

```   
cd personapi
```   

3. Execute o comando Maven para rodar a aplicação:   

```   
mvn spring-boot:run
```   

4. A API estará disponível em **http://localhost:8080/api/v1/people**   

 ## Executando com Docker (Opção 2)   

 Além de rodar localmente com Maven, você pode executar a API via Docker.   

 ### Pré-requisitos   

 - Docker e Docker Compose instalados.  

 ```   
 # Clone o repositório
git clone https://github.com/Gilvan-R-A/people-management-api.git
cd people-management-api/personapi

# Build da imagem
docker-compose build

# Subir o container
docker-compose up -d 

# Parar o container
docker-compose down
```   
A aplicação estará disponível em http://localhost:8080/api/v1/people   

## Testes   

Você pode testar os endpoints por ferramentas como Postman e Insomnia.   
Também pode interagir pelo H2 Database Console: http://localhost:8080/h2-console   

- JDBC URL: jdbc:h2:mem:testdb
- Usuário: sa
- Senha: (em branco)


## Endpoints   

**1. Criar uma pessoa**   
- **POST** /api/v1/people   
- Corpo da requisição:   

```   
{
    "firstName": "João",
    "lastName": "Silva",
    "cpf": "12345678901",
    "birthDate": "1990-01-01",
    "phones": [
        {
            "type": "MOBILE",
            "number": "987654321"
        }
    ]
}
```   

- Resposta:   

```   
{
    "message": "Created person with ID 1"
}
```   

**2. Listar todas as pessoas   
- **GET** /api/v1/people   
- Resposta:   

```   
[
    {
        "id": 1,
        "firstName": "João",
        "lastName": "Silva",
        "cpf": "12345678901",
        "birthDate": "1990-01-01",
        "phones": [
            {
                "type": "MOBILE",
                "number": "987654321"
            }
        ]
    }
]
```   

**3. Buscar pessoa por ID**   
- **GET** /api/v1/people/{id}   
- Resposta:   

```   
{
    "id": 1,
    "firstName": "João",
    "lastName": "Silva",
    "cpf": "12345678901",
    "birthDate": "1990-01-01",
    "phones": [
        {
            "type": "MOBILE",
            "number": "987654321"
        }
    ]
}
```   

**4. Atualizar uma pessoa**   
- **PUT** /api/v1/people/{id}   
- Corpo da requisição:   

```   
{
    "firstName": "João",
    "lastName": "Silva Updated",
    "cpf": "12345678901",
    "birthDate": "1990-01-01",
    "phones": [
        {
            "type": "MOBILE",
            "number": "987654322"
        }
    ]
}
```   
- Resposta:   

```   
{
    "message": "Updated person with ID 1"
}
```   

**5. Excluir uma pessoa**   
- **DELETE** /api/v1/people/{id}   
- Resposta:   

```   
{
    "message": "Person with ID 1 deleted"
}
```   

## Contribuição   

Sinta-se à vontade para contribuir para este projeto! Abra uma issue ou envie um pull request para sugerir melhorias.

