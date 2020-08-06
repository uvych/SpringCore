BEGIN;

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255) , price bigint);
INSERT INTO product (title, price) VALUES
('Book', 150),
('Laptop', 60000),
('Phone', 30000);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, name VARCHAR(255), age bigint);
INSERT INTO users (name, age) VALUES
('Alexander', 19),
('Bob', 23),
('Jon', 88);

COMMIT;