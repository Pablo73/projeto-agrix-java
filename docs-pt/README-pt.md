# Agrix - Aplicação de Gerenciamento de Fertilizantes e Cultivos #

O Agrix é uma aplicação de gerenciamento de fertilizantes e cultivos que permite aos agricultores e agrônomos registrar informações sobre fertilizantes, cultivos e suas associações. Esta aplicação foi desenvolvida com o objetivo de simplificar o processo de gerenciamento de recursos agrícolas.

## Funcionalidades Principais ##

- **Cadastro de Fertilizantes:** Registre informações detalhadas sobre os fertilizantes, incluindo nome, marca e composição.
- **Cadastro de Cultivos:** Registre informações sobre os cultivos, como nome, área plantada, data de plantio e data de colheita.
- **Associação de Fertilizantes a Cultivos:** Associe fertilizantes específicos a cultivos para rastrear o uso de fertilizantes em cada cultivo.
- **Autenticação de Usuários:** Os usuários podem se autenticar na aplicação para acessar funcionalidades protegidas por autenticação.

## Tecnologias Utilizadas ##

- **Spring Boot:** O backend da aplicação é desenvolvido em Java com o framework Spring Boot, proporcionando um ambiente de desenvolvimento robusto.
- **Spring Security:** O Spring Security é usado para lidar com autenticação e autorização de usuários.
- **JWT (JSON Web Tokens):** JWT é utilizado para gerar tokens de autenticação seguros.
- **Hibernate:** O Hibernate é usado para mapear objetos Java para o banco de dados relacional.
- **H2 Database:** O H2 Database é usado para armazenar dados em teste.
- **Maven:** Maven é utilizado para gerenciar as dependências do projeto.
- **BCrypt:** Todas as senhas dos usuários são armazenadas de forma segura com criptografia.
- **Banco de Dados PostgreSQL:** Agrix utiliza o banco de dados PostgreSQL para armazenar todas as informações relacionadas a cultivos, fertilizantes e usuários.

## Configuração do Ambiente de Desenvolvimento ##

Para configurar e executar o projeto em um ambiente de desenvolvimento local, siga as etapas abaixo:

1. Clone este repositório para o seu ambiente local:
```bash
git clone https://github.com/seu-usuario/agrix.git
```
2. Navegue até o diretório do projeto:
```bash
cd agrix
```
3. Execute o projeto usando o Maven:
```bash
./mvnw spring-boot:run
```


## Deploy ##

A aplicação Agrix foi implantada na plataforma Fly.io e está disponível no seguinte link:
https://wild-surf-9544.fly.dev

## Rotas da API ##

Aqui estão as principais rotas da API do Agrix, juntamente com uma breve explicação de cada uma delas:

1. Cadastro de Pessoas: **(POST /persons)**
- Permite o cadastro de novas pessoas, incluindo informações como nome de usuário e senha.
- **Exemplo de requisição:**
```bash
{
  "username": "Doutor Manhattan",
  "password": "senhasecreta",
  "role": "ADMIN"
}
```

2. Autenticação de Usuários: **(POST /auth/login)**
- Permite que os usuários façam login na aplicação, fornecendo nome de usuário e senha. Retorna um token de autenticação válido.
-  **Exemplo de requisição:**
```bash
{
  "username": "Doutor Manhattan",
  "password": "senhasecreta"
}
```

3. Cadastro de Fertilizantes: **(POST /farms)**
- Permite o cadastro de uma nova fazenda, fornecendo informações como nome e tamanho.
-  **Exemplo de requisição:**
```bash
{
  "name": "Fazendinha de partículas radioativas",
  "size": 5
}
```

4. Cadastro de Fertilizantes: **(POST /fertilizers)**
- Permite o cadastro de novos fertilizantes, fornecendo informações como nome, marca e composição.
-  **Exemplo de requisição:**
```bash
{
  "name": "Compostagem",
  "brand": "Feita no colisor de hádrons",
  "composition": "Restos de particulas"
}
```

5. Detalhes de um Fertilizante: **(POST /farms/{farmId}/crops)**
- Permite o cadastro de uma nova plantação, fazendo relação com uma fazenda.
-  **Exemplo de requisição:**
```bash
{
  "name": "Couve-flor radioativas ",
  "plantedArea": 5.43,
  "plantedDate": "2022-12-05",
  "harvestDate": "2023-06-08"
}
```

6. Associação de Fertilizantes a Cultivos: **(POST /crops/{cropId}/fertilizers/{fertilizerId})**
- Associa um fertilizante específico a um cultivo, permitindo o rastreamento do uso de fertilizantes em cada cultivo.

7. **(GET /farms)** - Retorna a lista de fazendas.

9. **(GET /farms/{id})** - Retorna uma fazenda pelo seu ID.

11. **(GET /farms/{farmId}/crops)** - Retorna uma fazenda pelo seu ID e as plantações associadas.
12. **(GET /crops)** - Retorna uma lista com todas as plantações.
13. **(GET /crops/{id})** - Retorna uma plantação pelo seu ID.
14. **(GET /crops/search)** - Permite realizar uma pesquisa ou consulta no sistema para obter informações específicas sobre culturas agrícolas.
15. **(GET /fertilizers)** - Retorna uma lista com todos os fertilizantes.
16. **(GET /fertilizers/{id})** - Retorna um fertilizante pelo seu ID.
17. **(GET /crops/{cropId}/fertilizers)** - Retorna uma plantação pelo seu ID e a relação de fertilizantes.



  








  



