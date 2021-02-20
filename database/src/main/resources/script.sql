DROP TABLE IF EXISTS carshop_storage.client;

CREATE TABLE carshop_storage.client
(
    id           BIGSERIAL PRIMARY KEY,
    login        CHARACTER VARYING (20) UNIQUE NOT NULL,
    password     CHARACTER VARYING (20),
    name         CHARACTER VARYING(30) NOT NULL,
    age          SERIAL,
    phone_number CHARACTER VARYING(15),
    email        CHARACTER VARYING(30)
);