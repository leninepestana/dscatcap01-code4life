## DSCatalog trabalho capítulo 1
### Enunciado
📝 Criação de projeto Spring Boot 2.4.x contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo:
-	Busca paginada de recursos
-	Busca de recurso por id
-	Inserir novo recurso
-	Atualizar recurso
-	Apagar recurso

O projeto deverá estar com um ambiente de testes configurado com acesso a Base Dados H2, deverá usar Maven como gerenciador de dependência, e Java 11 como linguagem.

## Modelo Conceitual
![Client diagram](https://user-images.githubusercontent.com/22635013/134638920-1ccbd8c8-0f04-47aa-9a06-b061c58e08b8.jpg)

> O projeto deverá fazer um seed de pelo menos 10 clientes com dados SIGNIFICATIVOS (não é para usar dados sem significado como “Nome 1”, “Nome 2”, etc.).

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
## Autor
Lenine Ferrer de Pestana <br />
Email: leninepestana@gmail.com