CREATE TABLE transactions
(
    id          INT PRIMARY KEY,
    transaction_id UUID NOT NULL,
    type        VARCHAR(50) NOT NULL,
    category    VARCHAR(255),
    amount      DECIMAL(19, 2) NOT NULL,
    description VARCHAR(1000),
    date        TIMESTAMP
);