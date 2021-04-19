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
    user_id       BIGSERIAL PRIMARY KEY,
    login    VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) UNIQUE NOT NULL,
    email    VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE carshop_storage.user_info
(
user_info_id BIGSERIAL PRIMARY KEY,
    user_id           BIGINT REFERENCES carshop_storage.user (user_id),
    name         VARCHAR(30) NOT NULL,
    surname      VARCHAR(30) NOT NULL,
    age          INTEGER,
    phone_number VARCHAR(15),
    hobby        VARCHAR(200),
    birth_date   DATE,
    UNIQUE(user_id)
);

CREATE TABLE carshop_storage.admin
(
    admin_id BIGINT UNIQUE NOT NULL REFERENCES carshop_storage.user (user_id),
    salary  DECIMAL,
    role    VARCHAR(30) NOT NULL
);

CREATE TABLE carshop_storage.client
(
    client_id         BIGINT UNIQUE NOT NULL REFERENCES carshop_storage.user (user_id),
    last_order_date DATE,
    role            VARCHAR(20) NOT NULL
);

CREATE TABLE carshop_storage.producer
(
    producer_id            BIGSERIAL PRIMARY KEY,
    producer_name VARCHAR(30) NOT NULL,
    country_name  VARCHAR(20)
);

CREATE TABLE carshop_storage.car
(
    car_id            BIGSERIAL PRIMARY KEY,
    brand         VARCHAR(20) NOT NULL,
    model         VARCHAR(20) NOT NULL,
    car_body_type VARCHAR(10),
    engine_type   VARCHAR(10)
);

CREATE TABLE carshop_storage.spare_part
(
    spare_part_id              BIGSERIAL PRIMARY KEY,
    spare_part_name VARCHAR(30) NOT NULL,
    vendor_code     VARCHAR(30),
    producer_id     BIGINT REFERENCES carshop_storage.producer (producer_id),
    car_id          BIGINT REFERENCES carshop_storage.car (car_id),
    description     VARCHAR(100),
    price           NUMERIC(6, 2)
);

CREATE TABLE carshop_storage.spare_part_car
(
    spare_part_id BIGINT NOT NULL REFERENCES carshop_storage.spare_part (spare_part_id),
    car_id        BIGINT NOT NULL REFERENCES carshop_storage.car (car_id),
    UNIQUE (spare_part_id, car_id)
);

CREATE TABLE carshop_storage.order
(
    order_id           BIGSERIAL PRIMARY KEY,
    client_id    BIGINT REFERENCES carshop_storage.client (client_id),
    date         DATE,
    payment_form VARCHAR(20)
);

CREATE TABLE carshop_storage.order_spare_part
(
    order_id      BIGINT REFERENCES carshop_storage.order (order_id),
    spare_part_id BIGINT REFERENCES carshop_storage.spare_part (spare_part_id),
    UNIQUE (order_id, spare_part_id)
);

INSERT INTO carshop_storage.user (login, password, email)
VALUES ('Kimi_Raikkonen', 'Iceman', 'kimi@gmail.com'),
       ('Sebastian_Vettel', 'Finger', 'finger@gmail.com'),
       ('Alen_Prost', 'Professeur', 'profi@gmail.com'),
       ('Ronnie', 'Rocket', 'snoocker-club@gmail.com'),
       ('Niki_Lauda', 'Rat', 'rat@gmail.com'),
       ('James_Hunt', 'Hunt_the_shunt', 'jamesy@gmail.com'),
       ('Fanhio', 'Maestro', 'maestro@gmail.com'),
       ('Mansell', 'Lion', 'notfinger@gmail.com'),
       ('Niko_Rosberg', 'Brithney', 'niko@gmail.com'),
       ('Jack_Brabham', 'Black_Jack', 'jackie@gmail.com');

INSERT INTO carshop_storage.user_info (user_id, name, surname, age, phone_number, hobby, birth_date)
VALUES (1, 'Kimi', 'Raikkonen', 40, '2434-324-234', 'races, dogs, reading', '1980-10-17'),
       (2, 'Sebastian', 'Vettel', 35, '2467-266-235', 'races, relaxing', '1985-08-23'),
       (3, 'Alen', 'Prost', 70, '7622-671-235', 'gardening, science fiction', '1950-06-30'),
       (4, 'Ronnie', 'O Sullivan', 45, '3423-225-883', 'business, cars', '1975-03-15'),
       (5, 'Niki', 'Lauda', 85, '2144-224-788', 'music, planes', '1935-10-25'),
       (6, 'James', 'Hunt', 83, '2144-677-124', 'swimming, bicycles', '1937-02-27'),
       (7, 'Juan Manuel', 'Fanhio', 110, '1122-666-112', 'relaxing', '1910-05-21'),
       (8, 'Nigel', 'Mansell', 67, '3536-133-865', 'billiard, swimming', '1953-08-08'),
       (9, 'Niko', 'Rosberg', 35, '1244-583-367', 'mahjong, golf', '1985-06-12'),
       (10, 'Jack', 'Brabham', 94, '2435-167-754', 'dances', '1926-04-02');

INSERT INTO carshop_storage.admin (admin_id, salary, role)
VALUES (7, 5000.0, 'Main admin'),
       (1, 3500.0, 'Admin'),
       (4, 3000.0, 'Admin');

INSERT INTO carshop_storage.client (client_id, last_order_date, role)
VALUES (2, '2020-12-23', 'Ordinary client'),
       (3, '2020-12-16', 'Ordinary client'),
       (5, '2021-01-14', 'Ordinary client'),
       (6, '2021-02-15', 'Ordinary client'),
       (8, '2021-02-18', 'Ordinary client'),
       (9, '2020-11-11', 'Ordinary client'),
       (10, '2020-09-28', 'Ordinary client');

INSERT INTO carshop_storage.producer (producer_name, country_name)
VALUES ('Pirelli', 'Italy'),
       ('Tokico', 'Japan'),
       ('TRW', 'Germany'),
       ('Bosch', 'Germany'),
       ('Patron', 'China'),
       ('Stellox', 'Germany'),
       ('Brembo', 'Italy'),
       ('Allegro', 'Poland'),
       ('Hudson cycle', 'United Kingdom'),
       ('Tubor', 'Russia');

INSERT INTO carshop_storage.car (brand, model, car_body_type, engine_type)
VALUES ('Citroen', 'C2', 'Hatchback', 'Petrol'),
       ('Volkswagen', 'Passat', 'Sedan', 'Diesel'),
       ('Tesla', 'Model S', 'Sedan', 'Electro'),
       ('Renault', 'Espace', 'Minivan', 'Petrol'),
       ('Skoda', 'Kodiaq', 'Crossover', 'Diesel'),
       ('Hummer', 'H1', 'Crossover', 'Petrol'),
       ('Ford', 'Mustang', 'Coupe', 'Petrol'),
       ('Lincoln', 'Town car', 'Limo', 'Diesel'),
       ('Fiat', 'Brava', 'Hatchback', 'Diesel'),
       ('Chevrolet', 'Bolt', 'Hatchback', 'Electro');

INSERT INTO carshop_storage.spare_part (spare_part_name, vendor_code, producer_id, car_id, description, price)
VALUES ('Tyre', 'jbglj242dg', 1, 3, 'The best tyre', 230.42),
       ('Damper', 'dfhbcvdg26sg', 2, 2, 'The best damper', 24.42),
       ('Brakes', 'adhnc4235fh', 3, 9, 'The best brakes', 523.46),
       ('Accumulator', 'adh34ljgadjld', 4, 7, 'The best accumulator', 678.23),
       ('Rear axle', 'hfbc2345c3', 5, 5, 'The best rear axle', 43.36),
       ('Radiator', 'blcj24ljx', 6, 1, 'The best radiator', 532.67),
       ('Brakes', 'fgb662cv', 7, 8, 'Classic brakes', 352.35),
       ('Engine', 'dgbc734gxv', 8, 8, 'dobry silnik', 325.46),
       ('Wheel', 'sdgc12f', 9, 10, 'Wheel from UK', 34.55),
       ('Accumulator', '24dg46sg5', 10, 6, 'Русский аккумулятор', 199.99);

INSERT INTO carshop_storage.spare_part_car (spare_part_id, car_id)
VALUES (1, 6),
       (2, 5),
       (3, 1),
       (4, 8),
       (5, 2),
       (6, 10),
       (7, 7),
       (8, 3),
       (9, 4),
       (10, 9);

INSERT INTO carshop_storage.order (client_id, date, payment_form)
VALUES (2, '2020-12-23', 'Cash'),
       (3, '2020-12-16', 'Card'),
       (5, '2021-01-14', 'Online'),
       (6, '2021-02-15', 'Cash'),
       (8, '2021-02-18', 'Card'),
       (9, '2020-11-11', 'Card'),
       (10, '2020-09-28', 'Online');

INSERT INTO carshop_storage.order_spare_part (order_id, spare_part_id)
VALUES (1, 6),
       (1, 8),
       (2, 6),
       (3, 1),
       (3, 9),
       (3, 10),
       (4, 2),
       (4, 7),
       (5, 3),
       (5, 1),
       (6, 4),
       (7, 2);