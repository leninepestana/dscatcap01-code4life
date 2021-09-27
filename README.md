## DSCatalog
### 📝 Descrição
Projeto Spring Boot 2.4.4 contendo um CRUD completo de web services REST para acesso a um recurso de clientes, contendo as cinco operações básicas:
-	Busca paginada de recursos
-	Busca de recurso por id
-	Inserir novo recurso
-	Atualizar recurso
-	Apagar recurso

Projeto configurado em ambiente de testes com acesso a Base Dados H2, uso do Maven como gerenciador de dependência, e Java 11 como linguagem.

## Competências
-	Criar projeto Spring Boot
-	Criar monorepo Git
-	Organizar o projeto em camadas
    -	Controlador REST
    -	Serviço
    -	Acesso a dados (Repository)
-	Criar entidades
-	Configurar perfil de teste do projeto
-	Seeding da base de dados
-	Criar web services REST
    -	Parâmetros de rota @PathVariable
    -	Parâmetros de requisição @RequestParam
    -	Corpo de requisição @RequestBody
    -	Resposta da requisição ResponseEntity<T>
-	Padrão DTO
-	CRUD completo
-	Tratamento de exceções
-	Postman (coleções, ambientes)
-	Dados de auditoria
-	Paginação de dados
-	Associações entre entidades (N-N)

## Modelo Conceitual
![Client diagram](https://user-images.githubusercontent.com/22635013/134638920-1ccbd8c8-0f04-47aa-9a06-b061c58e08b8.jpg)

> O projeto faz um seed de 40 clientes com dados SIGNIFICATIVOS e.g. (Nome: Afonso Manuel Garrido Joaquim, CPF: 7513698418, Salário: 6500.0, Data de nascimento: 1980-07-13T20:50:07.123450Z, Filhos: 2).

## Dependências Maven

```bash
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>

<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
## Parâmetros de paginação

```bash
@RequestParam(value = "page", defaultValue = "0") Integer page,
@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
@RequestParam(value = "direction", defaultValue = "DESC") String direction

```

## Arquivos de configuração

### application.properties

```bash
spring.profiles.active=test

spring.jpa.open-in-view=false
```
### application-test.properties

```bash
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
## Testes manuais no Postman

### Busca paginada de clientes


`GET /clients?page=0&linesPerPage=6&direction=ASC&orderBy=name`
```bash
{
    "content": [
        {
            "id": 11,
            "name": "Afonso Manuel Garrido Joaquim",
            "cpf": "7513698418",
            "income": 6500.0,
            "birthDate": "1980-07-13T20:50:07.123450Z",
            "children": 2
        },
        {
            "id": 32,
            "name": "Alexandra Neto Silva",
            "cpf": "1235497891",
            "income": 6500.0,
            "birthDate": "2010-01-19T17:35:30.010Z",
            "children": 0
        },
        {
            "id": 30,
            "name": "Anastácio José Silva",
            "cpf": "1598362379",
            "income": 6100.0,
            "birthDate": "1999-12-10T10:30:30.010Z",
            "children": 3
        },
        {
            "id": 34,
            "name": "André Manuel de Jesus Assador",
            "cpf": "1234562379",
            "income": 6370.0,
            "birthDate": "1989-06-10T10:30:30.010Z",
            "children": 1
        },
        {
            "id": 36,
            "name": "Antónia da Piedade Oliveira",
            "cpf": "1886562379",
            "income": 6200.0,
            "birthDate": "2004-03-10T10:30:30.010Z",
            "children": 0
        },
        {
            "id": 31,
            "name": "Carla Garrido Gaspar",
            "cpf": "7513698418",
            "income": 6500.0,
            "birthDate": "1980-07-13T20:50:07.123450Z",
            "children": 2
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageSize": 6,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 40,
    "totalPages": 7,
    "size": 6,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 6,
    "empty": false
}
```

### Busca de cliente por id
`GET /clients/4`

```bash
{
    "id": 4,
    "name": "Joana Margarida Narciso",
    "cpf": "1234562379",
    "income": 6370.0,
    "birthDate": "1989-06-10T10:30:30.010Z",
    "children": 1
}
```
### Inserção de novo cliente
`POST /clients`
```bash
{
    "name": "Luís Miguel Armeiro",
    "cpf": "8621458732",
    "income": "6000.0",
    "birthDate" : "1977-07-13T20:50:07.123450Z",
    "children" : 4
}
```
### Atualização de cliente
`PUT /clients/1`
```bash
{
    "name": "Luís Miguel Antunes",
    "cpf": "8621458732",
    "income": "6000.0",
    "birthDate" : "1977-07-13T20:50:07.123450Z",
    "children" : 5
}
```
### Deleção de cliente
`DELETE /clients/1`



## Autor
Lenine Ferrer de Pestana <br />
Email: leninepestana@gmail.com