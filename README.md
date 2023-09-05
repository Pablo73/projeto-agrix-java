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




  



