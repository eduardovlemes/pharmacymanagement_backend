CREATE TABLE "pharmacy" (
id bigserial primary key,
corporate_name varchar(255) not null,
cnpj varchar(18) not null unique,
trade_name varchar (255) not null,
email varchar (150) not null,
phone varchar(13),
cellphone varchar(14) not null
)