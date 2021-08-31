# user-management

exercício API REST com métodos POST e GET

- list como banco de dados não persistente ✅
- metodo POST em /users com endereço opcional(O endereço vem vazio no JSON caso não mande nenhum, este é o padrão mesmo?) ✅
- metodo POST atraves da requisição pelo body por JSON ✅
- Gerado de forma randomica (de 0 a 10) ✅
- Retornar erro caso nome e sobrenome já constar na lista ✅
    - Consegui fazer uma validação direto no código no UserController, mas acredito que isto deveria ficar separado. Se der tempo vou refatorar.
- GET por id ✅
- Retornar 404 ao buscar id invalido ✅
    - Consegui fazer retornar status 404, porém o retorno é uma String, não uma exception. Até criei a exception e um "Advice" conforme a documentação do Spring, mas não consegui implementar

**Endpoints**

POST no /users: aceita formato JSON com os atributos name, surname e address.

GET no /users: lista todos os users criados

Get no /users/{id} retorna o usuario do respectivo ID
