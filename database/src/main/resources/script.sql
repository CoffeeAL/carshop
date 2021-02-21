DROP TABLE IF EXISTS carshop_storage.order;
DROP TABLE IF EXISTS carshop_storage.spare_part;
DROP TABLE IF EXISTS carshop_storage.car;
DROP TABLE IF EXISTS carshop_storage.engine_type;
DROP TABLE IF EXISTS carshop_storage.brand;
DROP TABLE IF EXISTS carshop_storage.car_body;
DROP TABLE IF EXISTS carshop_storage.producer;
DROP TABLE IF EXISTS carshop_storage.country;
DROP TABLE IF EXISTS carshop_storage.cabinet;
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

CREATE TABLE carshop_storage.cabinet
(
    id             SERIAL PRIMARY KEY,
    client_id      BIGINT REFERENCES carshop_storage.client (id)
);

CREATE TABLE carshop_storage.country
(
    id           SERIAL PRIMARY KEY,
    country_name CHARACTER VARYING(30) UNIQUE NOT NULL
);

CREATE TABLE carshop_storage.producer
(
    id            BIGSERIAL PRIMARY KEY,
    producer_name CHARACTER VARYING(30) NOT NULL,
    country_id    INTEGER REFERENCES carshop_storage.country (id)
);

CREATE TABLE carshop_storage.car_body
(
    id            SERIAL PRIMARY KEY,
    car_body_type CHARACTER VARYING(10) NOT NULL
);

CREATE TABLE carshop_storage.engine_type
(
    id   SERIAL PRIMARY KEY,
    type CHARACTER VARYING(10)
);

CREATE TABLE carshop_storage.brand
(
    id         SERIAL PRIMARY KEY,
    brand_name CHARACTER VARYING(30),
    country_id INTEGER REFERENCES carshop_storage.country (id)
);

CREATE TABLE carshop_storage.car
(
    id             SERIAL PRIMARY KEY,
    brand_id       INTEGER REFERENCES carshop_storage.brand (id),
    model          CHARACTER VARYING(20),
    car_body_id    INTEGER REFERENCES carshop_storage.car_body (id),
    engine_type_id INTEGER REFERENCES carshop_storage.engine_type (id)
);

CREATE TABLE carshop_storage.spare_part
(
    id              SERIAL PRIMARY KEY,
    spare_part_name CHARACTER VARYING(30) NOT NULL,
    vendor_code     CHARACTER VARYING(30),
    producer_id     INTEGER REFERENCES carshop_storage.producer (id),
    car_id          INTEGER REFERENCES carshop_storage.car (id),
    description     CHARACTER VARYING(100),
    price           NUMERIC(6, 2)
);

CREATE TABLE carshop_storage.order
(
    id            BIGSERIAL PRIMARY KEY,
    client_id     BIGINT REFERENCES carshop_storage.client (id),
    spare_part_id INTEGER REFERENCES carshop_storage.spare_part (id),
    date          DATE
);