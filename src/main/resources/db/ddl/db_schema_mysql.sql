-- Users table
CREATE TABLE IF NOT EXISTS user_entity
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255),
    phone    VARCHAR(255),
    enabled  BOOLEAN DEFAULT TRUE,
    role     VARCHAR(50) NOT NULL
);

-- Transactions table
CREATE TABLE IF NOT EXISTS transactions
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id VARCHAR(36) NOT NULL UNIQUE,
    type           VARCHAR(50) NOT NULL,
    category       VARCHAR(255),
    amount         DECIMAL(19, 2) NOT NULL,
    description    VARCHAR(1000),
    date           TIMESTAMP
); 