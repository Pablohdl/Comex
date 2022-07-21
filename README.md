### Comex

### Lidando com Pagamentos.

### 1.Você criará um serviço separado ou fará no seu projeto atual?
    O serviço sera separado, pois houve a separação entre loja e estoque,entao por isso o processo de lidar com pagamentos deve ser um serviço único,pois caso haja problema será separado dos pedidos.
### 2.O Banco de Dados será separado ou será o mesmo do seu projeto atual??
    O banco de dados será separado, para que o fluxo de pagamento seja diferente do de pedido.
### 3.Você precisará de um API Gateway? Se sim, quais as responsabilidades dessa peça da sua arquitetura?
    Sim, o API Gateway é muito importante pra questão de segurança da aplicação, pois é sempre necessário uma autenticação para o serviço requisitado.
### 4.O sistema de notas fiscais será um projeto separado do de pagamentos ou os times serão unidos?
    O sistema de notas fiscais sera separado da de pagamentos, pois a geração de nota fiscal vai ocorrer de forma assincrona, e se caso houver algum problema na geração da nota fiscal, não vai atrapalhar o funcionamento de pedidos e nem de pagamentos.

