CREATE TABLE "pharmacy" (
id bigserial primary key,
corporate_name varchar(255) not null,
cnpj varchar(14) not null unique,
trade_name varchar (255) not null,
email varchar (150) not null,
phone varchar(10),
cellphone varchar(11) not null
)