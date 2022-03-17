# enjoyit
Mapeamento ORM com JPA (Hibernate) para atividade Enterprise Connection

Aplicaçao Webservice Java Restful com JAX-RS

Clonar o projeto com a branch main, basta adicionar a aplicação a um servidor Tomcat e subir o mesmo

Consultar o endpoint: http://localhost:8080/enjoyit/rest/cliente/11942426652 , este telefone já está cadastrado no banco de dados, a validação do input foi feita com regex
portanto, aceita valores como: 11942426652, (11) 94242-6652, 11 942426651, etc.

As bebidas e o cliente foram cadastrados via endpoints POST, caso queira testar, também está funcionando, porém cadastrar primeiro as bebidas e depois cadastrar o cliente 
e elas automaticamente serão atribuídas a ele.

Retorno esperado:

![image](https://user-images.githubusercontent.com/62717114/158907548-b4b9c263-5336-4b82-9416-846c09c9b1be.png)

Também exite um endpoint que busca todos os clientes, basta chamar a url: http://localhost:8080/enjoyit/rest/cliente

Retorno esperado:

![image](https://user-images.githubusercontent.com/62717114/158907634-2d5b29bf-f056-49ea-b2bd-eae1f95d57cc.png)
