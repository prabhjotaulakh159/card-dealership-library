DROP TABLE car;
DROP TABLE car_test;
DROP TABLE employee;
DROP TABLE employee_test;
DROP TABLE customer;
DROP TABLE customer_test;

CREATE TABLE car (
    id          NUMBER              GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type        VARCHAR2(100)       NOT NULL,
    model       VARCHAR2(100)       NOT NULL,
    year        NUMBER(4)           NOT NULL,
    color       VARCHAR2(100)       NOT NULL,
    price       NUMBER(10)          NOT NULL,
    voltage     NUMBER(4)           DEFAULT 0,
    charger     VARCHAR2(100)               ,
    max_pass    NUMBER(2)           DEFAULT 0,
    num_beds    NUMBER(2)           DEFAULT 0,
    kitchen     NUMBER(2)           DEFAULT 0
);

CREATE TABLE employee (
    name             VARCHAR2(100)  NOT NULL,
    phone_number     VARCHAR2(15)   NOT NULL,
    salary           NUMBER(10)     NOT NULL
);

CREATE TABLE customer (
    name         VARCHAR2(100)  NOT NULL,
    phone_number VARCHAR2(15)   NOT NULL
);

CREATE TABLE car_test (
    id          NUMBER              GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type        VARCHAR2(100)       NOT NULL,
    model       VARCHAR2(100)       NOT NULL,
    year        NUMBER(4)           NOT NULL,
    color       VARCHAR2(100)       NOT NULL,
    price       NUMBER(10)          NOT NULL,
    voltage     NUMBER(4)           DEFAULT 0,
    charger     VARCHAR2(100)               ,
    max_pass    NUMBER(2)           DEFAULT 0,
    num_beds    NUMBER(2)           DEFAULT 0,
    kitchen     NUMBER(2)           DEFAULT 0
);

CREATE TABLE employee_test (
    name             VARCHAR2(100)  NOT NULL,
    phone_number     VARCHAR2(15)   NOT NULL,
    salary           NUMBER(10)     NOT NULL
);

CREATE TABLE customer_test (
    name         VARCHAR2(100)  NOT NULL,
    phone_number VARCHAR2(15)   NOT NULL
);

INSERT INTO car (type, model, year, color, price) VALUES ('Car', 'Toyota Corolla', 2005, 'Red', 8000);
INSERT INTO car (type, model, year, color, price) VALUES ('Car', 'Honda CR-V', 2015, 'Black', 15000);
INSERT INTO car (type, model, year, color, price) VALUES ('Car', 'Ford Mustang', 2005, 'White', 12000);
INSERT INTO car (type, model, year, color, price) VALUES ('Car', 'Honda Civic', 2002, 'Orange', 2000);
INSERT INTO car (type, model, year, color, price) VALUES ('Car', 'Dodge Journey', 2016, 'Green', 4000);
INSERT INTO car (type, model, year, color, price) VALUES ('Car', 'Volkswagen', 2018, 'Yellow', 23000);
INSERT INTO car (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'Tesla Model 3', 2020, 'Blue', 45000, 480, 'Supercharger');
INSERT INTO car (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'BMW i3', 2018, 'Silver', 25000, 360, 'Wall Connector');
INSERT INTO car (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'Range Rover', 2023, 'Black', 80000, 4000, 'Wall Supercharger');
INSERT INTO car (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'Nissan Leaf', 2021, 'White', 100000, 400, 'Nissan I6 Charger');
INSERT INTO car (type, model, year, color, price, max_pass, num_beds, kitchen) VALUES ('Recreational', 'Airstream Basecamp', 2021, 'Silver', 40000, 4, 2, 0);
INSERT INTO car (type, model, year, color, price, max_pass, num_beds, kitchen) VALUES ('Recreational', 'Krystal Ship', 2006, 'Beige', 8000, 2, 1, 1);

INSERT INTO car_test (type, model, year, color, price) VALUES ('Car', 'Toyota Corolla', 2005, 'Red', 8000);
INSERT INTO car_test (type, model, year, color, price) VALUES ('Car', 'Honda CR-V', 2015, 'Black', 15000);
INSERT INTO car_test (type, model, year, color, price) VALUES ('Car', 'Ford Mustang', 2005, 'White', 12000);
INSERT INTO car_test (type, model, year, color, price) VALUES ('Car', 'Honda Civic', 2002, 'Orange', 2000);
INSERT INTO car_test (type, model, year, color, price) VALUES ('Car', 'Dodge Journey', 2016, 'Green', 4000);
INSERT INTO car_test (type, model, year, color, price) VALUES ('Car', 'Volkswagen', 2018, 'Yellow', 23000);
INSERT INTO car_test (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'Tesla Model 3', 2020, 'Blue', 45000, 480, 'Supercharger');
INSERT INTO car_test (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'BMW i3', 2018, 'Silver', 25000, 360, 'Wall Connector');
INSERT INTO car_test (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'Range Rover', 2023, 'Black', 80000, 4000, 'Wall Supercharger');
INSERT INTO car_test (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'Nissan Leaf', 2021, 'White', 100000, 400, 'Nissan I6 Charger');
INSERT INTO car_test (type, model, year, color, price, max_pass, num_beds, kitchen) VALUES ('Recreational', 'Airstream Basecamp', 2021, 'Silver', 40000, 4, 2, 0);
INSERT INTO car_test (type, model, year, color, price, max_pass, num_beds, kitchen) VALUES ('Recreational', 'Krystal Ship', 2006, 'Beige', 8000, 2, 1, 1);

INSERT INTO employee (name, phone_number, salary) VALUES ('Swetha Rajagopal', '5143333333', 1000000);
INSERT INTO employee (name, phone_number, salary) VALUES ('Michelle Banh', '5145555555', 500000);
INSERT INTO employee (name, phone_number, salary) VALUES ('Prabhjot Aulakh', '5141111111', 100000);
INSERT INTO employee (name, phone_number, salary) VALUES ('Safin Haque', '5142222222', 100000);
INSERT INTO employee (name, phone_number, salary) VALUES ('Sam Imberman', '5144444444', 60000);

INSERT INTO employee_test (name, phone_number, salary) VALUES ('Swetha Rajagopal', '5143333333', 1000000);
INSERT INTO employee_test (name, phone_number, salary) VALUES ('Michelle Banh', '5145555555', 500000);
INSERT INTO employee_test (name, phone_number, salary) VALUES ('Prabhjot Aulakh', '5141111111', 100000);
INSERT INTO employee_test (name, phone_number, salary) VALUES ('Safin Haque', '5142222222', 100000);
INSERT INTO employee_test (name, phone_number, salary) VALUES ('Sam Imberman', '5144444444', 60000);

INSERT INTO customer (name, phone_number) VALUES ('Alice Brown', '1112223333');
INSERT INTO customer (name, phone_number) VALUES ('Charlie Davis', '4445556666');
INSERT INTO customer (name, phone_number) VALUES ('Emma Garcia', '7778889999');
INSERT INTO customer (name, phone_number) VALUES ('Frank Harris', '1234567890');
INSERT INTO customer (name, phone_number) VALUES ('Noah One', '5556667777');
INSERT INTO customer (name, phone_number) VALUES ('Noah Two', '8476324589');

INSERT INTO customer_test (name, phone_number) VALUES ('Alice Brown', '1112223333');
INSERT INTO customer_test (name, phone_number) VALUES ('Charlie Davis', '4445556666');
INSERT INTO customer_test (name, phone_number) VALUES ('Emma Garcia', '7778889999');
INSERT INTO customer_test (name, phone_number) VALUES ('Frank Harris', '1234567890');
INSERT INTO customer_test (name, phone_number) VALUES ('Noah One', '5556667777');
INSERT INTO customer_test (name, phone_number) VALUES ('Noah Two', '8476324589');


COMMIT;
/

SELECT * FROM car;