create database employee_db;

use employee_db;

CREATE TABLE IF NOT EXISTS employees (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
second_name VARCHAR(100),
last_name VARCHAR(100) NOT NULL,
mother_last_name VARCHAR(100),
age INT,
sex VARCHAR(20),
date_of_birth DATE,
position VARCHAR(150),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
active boolean
);
