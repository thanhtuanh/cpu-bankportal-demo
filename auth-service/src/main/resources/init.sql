-- init.sql für authdb

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'USER',
    enabled BOOLEAN DEFAULT TRUE
);

INSERT INTO users (username, password, role) VALUES
('admin', 'admin', 'ADMIN'),
('user1', 'user1', 'USER'),
('user2', 'user2', 'USER');
