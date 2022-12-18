# CRUD EM JAVA
## Create, Read, Update, Delete
Desenvolvido com base no guia: Como fazer um CRUD Java com Mysql JDBC, de Cursos Kane Chan

* Feito o download do conector JDBC em: https://downloads.mysql.com/archives/c-j/
* Extraído o arquivo mysql-connector-java-8.0.30.jar para uma pasta local
* Instalação do conector na pasta do projeto (usando Eclipse):
  * Clicar com o botão da direita sobre a pasta do projeto;
  * Clicar em Build Path;
  * Clicar em Add External Archives;
  * Selecionar o arquivo .jar e clicar em Open.

Utiliza um script SQL para criação do banco de dados:
```create database agenda;
create table contatos(
	id int not null auto_increment primary key,
	nome varchar(40),
	idade int,
	dataCadastro date)
```

* Configurado para usar o servidor local (ApacheFriends XAMPP Version 8.1.10)

* Utiliza o padrão de projeto DAO (Data Access Object), que provê uma interface abstrata para o banco de dados. Isso permite que a aplicação interaja com o banco de dados sem que haja necessidade de expor seus detalhes.

* A classe Main contém exemplos das quatro operações: CREATE, READ, UPDATE e DELETE.