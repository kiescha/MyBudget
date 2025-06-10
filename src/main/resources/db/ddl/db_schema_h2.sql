CREATE TABLE transactions
(
    id          INT PRIMARY KEY auto_increment,
    transaction_id UUID NOT NULL UNIQUE,
    type        VARCHAR(50) NOT NULL,
    category    VARCHAR(255),
    amount      DECIMAL(19, 2) NOT NULL,
    description VARCHAR(1000),
    date        TIMESTAMP
);

-- Set the initial ID sequence to 1
ALTER TABLE transactions ALTER COLUMN id RESTART WITH 1;