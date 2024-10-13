--DROP TABLE if EXISTS orders;
--DROP TABLE if EXISTS customers;

CREATE TABLE if NOT EXISTS customers (
    customer_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(255),
    email_address VARCHAR(255)
);

CREATE TABLE if NOT EXISTS orders (
    order_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    item_description VARCHAR(255),
    price_paid VARCHAR(255),
    status VARCHAR(255),
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

--ALTER TABLE orders AUTO_INCREMENT = 1000;
