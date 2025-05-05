-- 1. Enum for user roles
CREATE TYPE client_role AS ENUM ('owner', 'editor', 'viewer');

-- 2. Users
CREATE TABLE client (
                        client_id SERIAL PRIMARY KEY,
                        nick_name VARCHAR(255),
                        email VARCHAR(255) UNIQUE,
                        password_hash VARCHAR(255)
);

-- 3. Budgets
CREATE TABLE budget (
                        budget_id SERIAL PRIMARY KEY,
                        name VARCHAR(255),
                        start_date DATE,
                        end_date DATE
);

-- 4. Budget <-> User join with role
CREATE TABLE budget_client (
                             budget_client_id SERIAL PRIMARY KEY,
                             client_id INT NOT NULL,
                             budget_id INT NOT NULL,
                             role client_role DEFAULT 'viewer',
                             CONSTRAINT fk_user FOREIGN KEY (client_id) REFERENCES client (client_id),
                             CONSTRAINT fk_budget FOREIGN KEY (budget_id) REFERENCES budget (budget_id),
                             UNIQUE (client_id, budget_id)
);

-- 5. Categories
CREATE TABLE category (
                          category_id SERIAL PRIMARY KEY,
                          name VARCHAR(255)
);

-- 6. Cards
CREATE TABLE card (
                      card_id SERIAL PRIMARY KEY,
                      card_name VARCHAR(255),
                      card_type VARCHAR(255)
);

-- 7. Banks
CREATE TABLE bank (
                      bank_id SERIAL PRIMARY KEY,
                      name VARCHAR(255),
                      card_id INT,
                      FOREIGN KEY (card_id) REFERENCES card(card_id)
);

-- 8. Bank accounts (owned by users)
CREATE TABLE bank_account (
                              bank_account_id SERIAL PRIMARY KEY,
                              account_name VARCHAR(255),
                              client_id INT NOT NULL,
                              bank_id INT,
                              FOREIGN KEY (client_id) REFERENCES client(client_id),
                              FOREIGN KEY (bank_id) REFERENCES bank(bank_id)
);

-- 9. Other bank providers / digital wallets
CREATE TABLE other_bank (
                            other_bank_id SERIAL PRIMARY KEY,
                            name VARCHAR(255)
);

-- 10. Payment methods
CREATE TYPE payment_type AS ENUM ('cash', 'bank', 'otherBank');

CREATE TABLE payment_method (
                                method_id SERIAL PRIMARY KEY,
                                type payment_type NOT NULL,
                                bank_account_id INT,
                                other_bank_id INT,
                                FOREIGN KEY (bank_account_id) REFERENCES bank_account(bank_account_id),
                                FOREIGN KEY (other_bank_id) REFERENCES other_bank(other_bank_id)
);

-- 11. Transactions
CREATE TABLE transaction (
                             transaction_id SERIAL PRIMARY KEY,
                             budget_id INT NOT NULL,
                             client_id INT NOT NULL,
                             method_id INT,
                             category_id INT,
                             amount DECIMAL(10,2) NOT NULL,
                             income DECIMAL(10,2) DEFAULT 0,
                             expense DECIMAL(10,2) DEFAULT 0,
                             date DATE,
                             description TEXT,
                             FOREIGN KEY (budget_id) REFERENCES budget(budget_id),
                             FOREIGN KEY (client_id) REFERENCES client(client_id),
                             FOREIGN KEY (method_id) REFERENCES payment_method(method_id),
                             FOREIGN KEY (category_id) REFERENCES category(category_id)
);
