# user-management

exercício API REST com métodos POST e GET

- list como banco de dados não persistente ✅
- metodo POST em /users com endereço opcional(O endereço vem vazio no JSON caso não mande nenhum, este é o padrão mesmo?) ✅
- metodo POST atraves da requisição pelo body por JSON ✅
- Gerado de forma randomica (de 0 a 50) ✅
- Retornar erro caso nome e sobrenome já constar na lista ✅
- GET por id ✅
- Retornar 404 ao buscar id invalido ✅
 

**Endpoints**

POST no /api/v1/users: aceita formato JSON com os atributos name, surname e address.

GET no /api/v1/users: lista todos os users criados

Get no /api/v1/users/{id} retorna o usuario do respectivo ID

Com a aplicação rodando, acesse http://localhost:8080/swagger-ui/ para conferir as especificações completas 
