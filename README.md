## Springboot application for transactions
An application that handles the creation of bank accounts and the transactions between them

## Installation and first steps

### Configuration of the Database - postgreSQL 
The project is using postgreSQL for the management of the data. There is a docker-compose file which is located
inside the project, and uses the latest image of the postgres.
Execute it as following: `docker-compose up -d`\
After that, a docker container, with the name `postgres_con`, will start in the background which
contains the latest `postgres` image. The port that the container is listening to, is `5432`, and a
volume folder will be created in the root path of your machine, in a folder named `docker-postgres-container-data`.
The volume name is `transactions-project_postgres_data` and can be found by executing the command:\
`docker volume ls`.

You will need a database management tool in order to connect to the database, and perform some queries for checking\
the state of the database. Recommended tools are: `pgAdmin4` or `DBeaver`. You may use other tool that you\
are more familiarized with it.

### Start the application 
Now that you have set up the database, in order to record the new data, open a new terminal inside the Intellij
and run `mvn clean install` in order to install the dependencies that the project is using. You can use a console
to execute this command, just make sure you are the root folder of the project. When the configuration is completed,
you can run the application by clicking the green button on the Intellij, or you can run the following command from terminal:\
`mvn spring-boot:run`.\
If the process was successful you will see a message in the logs like: `Tomcat started on port(s): 8080 (http) with context path ''`.
As the previous message implies, the application is listening to the `localhost:8080` port.
The tables in the database, are already prefilled with some custom data. You can check that, by open the database management tool
and perform a select query to the tables of the project:
`select * from accounts` & `select * from transactions_details` will show the custom data that are already in database.


### Perform API calls
In order to check the application's functionality, you can use the `postman` tool to perform some api calls.\
The first API is: `/accounts/create` and can be tested by performing a POST request with the following data:\

