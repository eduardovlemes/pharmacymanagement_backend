CREATE TABLE "address" (
id bigserial primary key,
postalcode varchar(8) not null,
street varchar(200) not null,
number int not null,
district varchar(100) not null,
city varchar(100) not null,
state varchar(100) not null,
address_compl varchar(150),
latitude decimal(8,6) not null,
longitude decimal(9,6) not null
)