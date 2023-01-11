ALTER TABLE pharmacy ADD COLUMN address_id bigint;
ALTER TABLE pharmacy ADD FOREIGN KEY (id_address) REFERENCES address(id);