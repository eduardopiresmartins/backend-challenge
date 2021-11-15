# backend-challenge

## Introdução

<p> 🚀 Teste de BackEnd desenvolvido em Java com Spring 🚀 </p>

![Java Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Badge](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

<p> As camadas dessa aplicação estão separadas em Aplication e Domain. 
A camada de Application é responsável por manter tudo que for do contexto da aplicação, sendo para este projeto a exception e rota. </p> 

<p> Já a camada Domain ficará responsável pela regra de negócio como visto na bibliografia DDD Domain Driven Design de Martin Fowler. </p>

<p> O projeto é bastante robusto com a menor quantidade possível de libs, 
assim garantindo sua performance e facilidade de execução do mesmo além de fazer uso somente de libs oficiais como "lombok". </p>

<p> Para as validações criei uma annotation, dessa forma é possível reaproveitar para outras partes do projeto em qualquer Object, Value ou DTO. </p>

<p> Utilizei boas práticas, como o "clean-code", código legivel e desaclopado, também busquei retornar como response do request um Array de erros para que 
o front ou qualquer outro consumidor de API possa fazer uso do mesmo e obter um feedback do que precisamos para que as requisições da senha sejam cumpridas.

## Executando o projeto 📋

<p> Para baixar o projeto em sua máquina, faça uso do GitHub.

```
$ git clone https://github.com/eduardopiresmartins/backend-challenge
```

<p> Para executar o projeto, rode os comandos abaixo dentro da pasta raiz em que o projeto foi baixado: </p>

```
$ ./mvnw clean package spring-boot:repackage
$ java -jar target/password-validation-0.0.1-SNAPSHOT.jar
```

<p> Após rodar o projeto, podemos utilizar o Postman, para fazer as requisições da API. ⚙️ </P>

```
POST /api/passwords/validation HTTP/1.1
Host: localhost:8090
Content-Type: application/json

{
    "password": "AbTp9!fok"
}
```

<p> Response de sucesso esperado: </p>

```
POST /api/passwords/validation HTTP/1.1
Host: localhost:8090
Content-Type: application/json
Status Code: 200
Response:
true
```

<p> Response de erro esperado: <p/>

```POST /api/passwords/validation 
Host: localhost:8090
Content-Type: application/json
Status Code: 400

Response:
{
    "code": 400,
    "errors": [
        "A senha deve conter ao menos um caractere especial",
        "O campo senha deve ser preenchido",
        "A senha deve conter ao menos uma letra minuscula",
        "A senha não deve conter caracteres repetidos",
        "A senha deve conter ao menos uma letra maiúscula"
    ]
}
```

## Cenários (CURL)

### Sucesso

* Todos os requisitos contemplados

<p> Request </p>

```
curl --location --request POST 'http://localhost:8090/api/passwords/validation' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=B79B8E1AF094E155B7FBBE2A8C4CD79C' \
--data-raw '{
    "password": "AbTp9!fok"
}'
```

<p> Response: </p>

```
true
```

### Erro

* Senha vazia 

<p> Request: </p>

```
curl --location --request POST 'http://localhost:8090/api/passwords/validation' \
--header 'Content-Type: application/json' \
--data-raw '{}'
```

<p> Response: </p>

```
{
    "code": 400,
    "errors": [
        "A senha deve conter ao menos um digito",
        "A senha deve conter ao menos 9 caracteres",
        "A senha deve conter ao menos um caractere especial",
        "O campo senha deve ser preenchido",
        "A senha deve conter ao menos uma letra minuscula",
        "A senha não deve conter caracteres repetidos",
        "A senha deve conter ao menos uma letra maiúscula"
    ]
}
```

* Nove ou mais caracteres

<p> Request </p>

```
curl --location --request POST 'http://localhost:8090/api/passwords/validation' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=B79B8E1AF094E155B7FBBE2A8C4CD79C' \
--data-raw '{
    "password": "Ab9!f"
}'
```

<p> Response </p>

```
{
    "code": 400,
    "errors": [
        "A senha deve conter ao menos 9 caracteres"
    ]
}
```

* Ao menos 1 letra minúscula

<p> Request </p>

```
curl --location --request POST 'http://localhost:8090/api/passwords/validation' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=B79B8E1AF094E155B7FBBE2A8C4CD79C' \
--data-raw '{
    "password": "ABCDEFG9!HI"
}'
```

<p> Response </p>

```
{
    "code": 400,
    "errors": [
        "A senha deve conter ao menos uma letra minuscula"
    ]
}
```

* Ao menos 1 letra maiúscula

<p> Request </p>

```
curl --location --request POST 'http://localhost:8090/api/passwords/validation' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=B79B8E1AF094E155B7FBBE2A8C4CD79C' \
--data-raw '{
    "password": "AbTpv!fok"
}'
```

<p> Response: </p>

```
{
    "code": 400,
    "errors": [
        "A senha deve conter ao menos uma letra maiúscula"
    ]
}
```

* Ao menos 1 dígito

<p> Request: </p>

```
curl --location --request POST 'http://localhost:8090/api/passwords/validation' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=B79B8E1AF094E155B7FBBE2A8C4CD79C' \
--data-raw '{
    "password": "AbTpv!fok"
}'
```

<p> Response: </p>

```
{
    "code": 400,
    "errors": [
        "A senha deve conter ao menos um digito"
    ]
}

```

* Ao menos 1 caractere especial

<p> Request: </p>

```
curl --location --request POST 'http://localhost:8090/api/passwords/validation' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=B79B8E1AF094E155B7FBBE2A8C4CD79C' \
--data-raw '{
    "password": "AbTpv0fok"
}'
```

<p> Reponse:</p>

```
{
    "code": 400,
    "errors": [
        "A senha deve conter ao menos um caractere especial"
    ]
}
```

* Não possuir caracteres repetidos dentro do conjunto

<p> Request: </p>

```
curl --location --request POST 'http://localhost:8090/api/passwords/validation' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=B79B8E1AF094E155B7FBBE2A8C4CD79C' \
--data-raw '{
    "password": "AbTpv0!ook"
}'
```

<p> Response: </p>

```
{
    "code": 400,
    "errors": [
        "A senha não deve conter caracteres repetidos"
    ]
}
```

* Espaços em branco não devem ser considerados como caracteres válidos

<p> Request </p>

```
curl --location --request POST 'http://localhost:8090/api/passwords/validation' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=B79B8E1AF094E155B7FBBE2A8C4CD79C' \
--data-raw '{
    "password": "AbTpv0! ok"
}'
```

<p> Response </p>

```
{
    "code": 400,
    "errors": [
        "A senha não deve conter espaços"
    ]
}
```

<p> Todos os testes Unitários e de Integração estão dentro da pasta de test. Optei por criar os testes de integração contemplando todos os possíveis 
cenários a fim de garantir a integridade do contrato de response. </p>

---
⌨️ com ❤️ por [Eduardo Pires](https://www.linkedin.com/in/eduardopiresmartins/) 😊
