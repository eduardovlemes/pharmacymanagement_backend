CREATE TABLE "drug" (
id bigserial primary key,
drug_name varchar(150) not null,
lab varchar(150) not null,
dosage varchar(4) not null,
description varchar(255),
price decimal not null,
type varchar(100) not null
)