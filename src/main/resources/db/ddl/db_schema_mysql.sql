CREATE TABLE IF NOT EXISTS transactions
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id VARCHAR(36) NOT NULL,
    type        VARCHAR(50) NOT NULL,
    category    VARCHAR(255),
    amount      DECIMAL(19, 2) NOT NULL,
    description VARCHAR(1000),
    date        TIMESTAMP
); 