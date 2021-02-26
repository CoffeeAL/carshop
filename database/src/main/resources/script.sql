DROP TABLE IF EXISTS carshop_storage.order_spare_part;
DROP TABLE IF EXISTS carshop_storage.order;
DROP TABLE IF EXISTS carshop_storage.spare_part_car;
DROP TABLE IF EXISTS carshop_storage.spare_part;
DROP TABLE IF EXISTS carshop_storage.car;
DROP TABLE IF EXISTS carshop_storage.producer;
DROP TABLE IF EXISTS carshop_storage.user_info;
DROP TABLE IF EXISTS carshop_storage.client;
DROP TABLE IF EXISTS carshop_storage.admin;
DROP TABLE IF EXISTS carshop_storage.user CASCADE;

CREATE TABLE carshop_storage.user
(
    id       BIGSERIAL PRIMARY KEY,
    login    CHARACTER VARYING(20) UNIQUE NOT NULL,
    password CHARACTER VARYING(20),
    email    CHARACTER VARYING(30)
);

CREATE TABLE carshop_storage.user_info
(
    user_id      BIGINT REFERENCES carshop_storage.user (id),
    name         CHARACTER VARYING(30) NOT NULL,
    surname      CHARACTER VARYING(30) NOT NULL,
    age          INTEGER,
    phone_number CHARACTER VARYING(15),
    hobby        CHARACTER VARYING(200),
    birth_date   DATE
);

CREATE TABLE carshop_storage.admin
(
    user_id BIGINT REFERENCES carshop_storage.user (id),
    salary  DECIMAL,
    role    CHARACTER VARYING NOT NULL
);

CREATE TABLE carshop_storage.client
(
    client_id       BIGINT REFERENCES carshop_storage.user (id),
    last_order_date DATE,
    role            CHARACTER VARYING(20) NOT NULL,
    UNIQUE (client_id)
);

CREATE TABLE carshop_storage.producer
(
    id            BIGSERIAL PRIMARY KEY,
    producer_name CHARACTER VARYING(30) NOT NULL,
    country_name  CHARACTER VARYING(20)
);

CREATE TABLE carshop_storage.car
(
    id            BIGSERIAL PRIMARY KEY,
    brand         CHARACTER VARYING(20),
    model         CHARACTER VARYING(20),
    car_body_type CHARACTER VARYING(10),
    engine_type   CHARACTER VARYING(10)
);

CREATE TABLE carshop_storage.spare_part
(
    id              BIGSERIAL PRIMARY KEY,
    spare_part_name CHARACTER VARYING(30) NOT NULL,
    vendor_code     CHARACTER VARYING(30),
    producer_id     BIGINT REFERENCES carshop_storage.producer (id),
    car_id          BIGINT REFERENCES carshop_storage.car (id),
    description     CHARACTER VARYING(100),
    price           NUMERIC(6, 2)
);

CREATE TABLE carshop_storage.spare_part_car
(
    spare_part_id BIGINT NOT NULL REFERENCES carshop_storage.spare_part (id),
    car_id        BIGINT NOT NULL REFERENCES carshop_storage.car (id),
    UNIQUE (spare_part_id, car_id)
);

CREATE TABLE carshop_storage.order
(
    id           BIGSERIAL PRIMARY KEY,
    client_id    BIGINT REFERENCES carshop_storage.client (client_id),
    date         DATE,
    payment_form CHARACTER VARYING(20)
);

CREATE TABLE carshop_storage.order_spare_part
(
    order_id      BIGINT REFERENCES carshop_storage.order (id),
    spare_part_id BIGINT REFERENCES carshop_storage.spare_part (id),
    UNIQUE (order_id, spare_part_id)
);