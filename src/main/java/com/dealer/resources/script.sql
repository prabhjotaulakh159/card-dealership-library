DROP TABLE programming_cars;
DROP TABLE programming_programming_employees;
DROP TABLE programming_programming_customers;

CREATE TABLE programming_cars (
    type        VARCHAR2(100)       NOT NULL,
    model       VARCHAR2(100)       NOT NULL,
    year        NUMBER(4)           NOT NULL,
    color       VARCHAR2(100)       NOT NULL,
    price       NUMBER(10)          NOT NULL,
    voltage     NUMBER(4)                   ,
    charger     VARCHAR2(100)               ,
    max_pass    NUMBER(2)                   ,
    num_beds    NUMBER(2)                   ,
    kitchen     NUMBER(2)                   
);

CREATE TABLE programming_employees (
    name             VARCHAR2(100)  NOT NULL,
    phone_number     VARCHAR2(15)   NOT NULL,
    salary           NUMBER(10)     NOT NULL
);

CREATE TABLE programming_customers (
    name         VARCHAR2(100)  NOT NULL,
    phone_number VARCHAR2(15)   NOT NULL
);

INSERT INTO programming_customers (name, phone_number) VALUES ('Alice Brown', '1112223333');
INSERT INTO programming_customers (name, phone_number) VALUES ('Charlie Davis', '4445556666');
INSERT INTO programming_customers (name, phone_number) VALUES ('Emma Garcia', '7778889999');
INSERT INTO programming_customers (name, phone_number) VALUES ('Frank Harris', '1234567890');
INSERT INTO programming_customers (name, phone_number) VALUES ('Noah One', '5556667777');
INSERT INTO programming_customers (name, phone_number) VALUES ('Noah Two', '8476324589');
INSERT INTO programming_employees (name, phone_number, salary) VALUES ('Swetha Rajagopal', '5143333333', 1000000);
INSERT INTO programming_employees (name, phone_number, salary) VALUES ('Michelle Banh', '5145555555', 500000);
INSERT INTO programming_employees (name, phone_number, salary) VALUES ('Prabhjot Aulakh', '5141111111', 100000);
INSERT INTO programming_employees (name, phone_number, salary) VALUES ('Safin Haque', '5142222222', 100000);
INSERT INTO programming_employees (name, phone_number, salary) VALUES ('Sam Imberman', '5144444444', 60000);
INSERT INTO programming_cars (type, model, year, color, price) VALUES ('Car', 'Toyota Corolla', 2005, 'Red', 8000);
INSERT INTO programming_cars (type, model, year, color, price) VALUES ('Car', 'Honda CR-V', 2015, 'Black', 15000);
INSERT INTO programming_cars (type, model, year, color, price) VALUES ('Car', 'Ford Mustang', 2005, 'White', 12000);
INSERT INTO programming_cars (type, model, year, color, price) VALUES ('Car', 'Honda Civic', 2002, 'Orange', 2000);
INSERT INTO programming_cars (type, model, year, color, price) VALUES ('Car', 'Dodge Journey', 2016, 'Green', 4000);
INSERT INTO programming_cars (type, model, year, color, price) VALUES ('Car', 'Volkswagen', 2018, 'Yellow', 23000);
INSERT INTO programming_cars (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'Tesla Model 3', 2020, 'Blue', 45000, 480, 'Supercharger');
INSERT INTO programming_cars (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'BMW i3', 2018, 'Silver', 25000, 360, 'Wall Connector');
INSERT INTO programming_cars (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'Range Rover', 2023, 'Black', 80000, 4000, 'Wall Supercharger');
INSERT INTO programming_cars (type, model, year, color, price, voltage, charger) VALUES ('Electric', 'Nissan Leaf', 2021, 'White', 100000, 400, 'Nissan I6 Charger');
INSERT INTO programming_cars (type, model, year, color, price, max_pass, num_beds, kitchen) VALUES ('Recreational', 'Airstream Basecamp', 2021, 'Silver', 40000, 4, 2, 0);
INSERT INTO programming_cars (type, model, year, color, price, max_pass, num_beds, kitchen) VALUES ('Recreational', 'Krystal Ship', 2006, 'Beige', 8000, 2, 1, 1);

COMMIT;
/