CREATE TABLE "user" (
id bigserial primary key,
email varchar(150) not null unique,
password varchar(255) not null
)