-- init.sql für accounts

DROP TABLE IF EXISTS account;

CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    owner VARCHAR(100) NOT NULL,
    balance NUMERIC(10, 2) NOT NULL
);

INSERT INTO account (owner, balance) VALUES
('Alice', 1500.00),
('Bob', 800.50),
('Charlie', 200.00);
