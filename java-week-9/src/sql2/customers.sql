CREATE TABLE customer (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE customer_order (
    id INT PRIMARY KEY,
    order_date DATE NOT NULL,
    customer_id INT NOT NULL,

    FOREIGN KEY (customer_id)
        REFERENCES customer(id)
);
CREATE TABLE category (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE product (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    category_id INT NOT NULL,

    FOREIGN KEY (category_id)
        REFERENCES category(id)
);