DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'USER',
    enabled BOOLEAN DEFAULT TRUE
);


INSERT INTO users (username, password_hash, role) VALUES
('admin',  '$2a$10$Jyuu4.1Y5oTPOalO491nN.sdl1WuXdQ3VPmRSQZoAEGmq/yqpUAJi', 'ADMIN'),
('testuser',  '$2a$10$zG8ZoRi5.tKXij6M0zod7eCN4DwVm7uf9Te2zSk9HbLly2RvOpMey', 'USER');
