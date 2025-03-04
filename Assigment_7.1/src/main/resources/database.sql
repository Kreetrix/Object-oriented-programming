-- Drop the database if it exists
DROP DATABASE IF EXISTS currency_converter;

CREATE DATABASE currency_converter;

USE currency_converter;

DROP TABLE IF EXISTS currencies;

CREATE TABLE currencies (
    abbreviation VARCHAR(3) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    conversion_rate DECIMAL(10, 6) NOT NULL
);

INSERT INTO currencies (abbreviation, name, conversion_rate) VALUES
         ('USD', 'US Dollar', 1.000000),
         ('EUR', 'Euro', 0.940000),

DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT, INSERT, UPDATE, DELETE ON currency_converter.currencies TO 'appuser'@'localhost';

FLUSH PRIVILEGES;