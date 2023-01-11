# M2P2 - PharmacyManagement

- Para rodar o programa localmente, e com a devida interação com o banco de dados, você precisará ir em:

```
src / main / resources / application.properties 
```

- Dentro de application.properties inserir o seguinte comando:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/pharmacy_management
spring.datasource.port=5432
spring.datasource.username=postgres
spring.datasource.password=
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.globally_quoted_identifiers=true

spring.datasource.testWhileIdle=true
spring.datasource.validationQuery=SELECT 1
```
Obs.: o campo "password" deve ser preenchido com a senha do seu banco de dados Postgres.

- No Postgres, criar o databases com o nome "pharmacy_management", da seguinte forma:

```
Servers / PostgreSQL15 / Create / Database / pharmacy_management
```

- No IntellJ, dar o RUN no programa.

- Usar o PostMan para fazer as operações nos endpoints.
