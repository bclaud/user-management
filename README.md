# user-management

exercício API REST com métodos POST e GET

- list como banco de dados não persistente ✅
- metodo POST em /users com endereço opcional ✅
- metodo POST atraves da requisição pelo body por JSON ✅
- ID Gerado de forma randomica (de 0 a 50) ✅
- Retornar erro caso nome e sobrenome já constar na lista ✅
- GET por id ✅
- Retornar 404 ao buscar id invalido ✅
</br></br>

# Requisitos
- Git

- JDK-11

ou 

- Docker se for rodar pela imagem
</br></br>

# Como executar

Clone este repositório
```git
git clone git@github.com:bclaud/user-management.git
```

Execute a aplicação entrando no diretório do projeto e então executando através dos comandos abaixo:
```bash
cd users
./mvnw spring-boot:run
```

ou utilize a imagem disponivel no docker hub 🐋
```bash
docker pull baclaud/dockerhub:usermanagementimage
docker run -p 8080:8080 -d --name usermanagement baclaud/usermanagement-slim:latest
```
 

**Endpoints**

POST no /api/v1/users: aceita formato JSON com os atributos name, surname e address.

GET no /api/v1/users: lista todos os users criados

Get no /api/v1/users/{id} retorna o usuario do respectivo ID

Com a aplicação rodando, acesse http://localhost:8080/swagger-ui/ para conferir as especificações completas 
