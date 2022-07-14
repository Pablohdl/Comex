### Reflita: o código melhorou? Se sim, em qual aspecto? Se não, qual a raiz do problema? 

Acredito que a organização do código melhorou um pouco,mas achei essa arquitetura um pouco confusa, e talvez em um projeto grande pode ser prejudicial no entedimento dos desenvolvedor, pois com essa arquitetura o cliente consegue entender do que se trata a aplicação em pouco tempo,mas para um desenvolvedor vai acabar sendo mais trabalhoso pois tem muito código que talvez nao seja necessario, deixando assim o projeto maior do que deveria ser.

### DDD

### 1.Quais padrões táticos do DDD cada classe implementa?
    As classes possuem linguagem ubíqua, deixando assim mais claro o entendimento para futuros clientes.
### 2.Quais os agregados da aplicação, qual sua raiz e que classes os compõem?
    A classe de perfil depende do agregado Usuario para o funcionamento.
### 3.Quais contextos delimitados existem?
    Acredito que a classe pedido é o maior exemplo,pois possuem metodos de inserir,alterar,deletar e o principal contexto é que esses pedidos são feitos por Clientes, então a classe pedidos está altamente conectada com a classe de clientes.