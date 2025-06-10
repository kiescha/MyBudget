INSERT INTO transactions (id, transaction_id, type, category, amount, description, date)
VALUES (1, 'b17b56e3-2e3c-4a9b-bf5c-a12345678901', 'INCOME', 'Salary', 2500.00, 'Monthly salary',
        '2025-06-01 08:00:00'),
       (2, 'f69d1e6e-61a9-4c5f-9bd0-b12345678902', 'EXPENSE', 'Groceries', 150.75, 'Weekly food shopping',
        '2025-06-02 17:30:00'),
       (3, 'a01dc29d-fc12-4b1b-9011-c12345678903', 'EXPENSE', 'Transport', 60.00, 'Gas refill', '2025-06-03 09:00:00'),
       (4, 'c3e15b57-d29d-4e4c-93e6-d12345678904', 'INCOME', 'Freelance', 600.00, 'Side project payment',
        '2025-06-04 19:15:00'),
       (5, 'e1bd9b3e-0cb1-4b95-97cb-e12345678905', 'EXPENSE', 'Utilities', 120.50, 'Electricity bill',
        '2025-06-05 12:00:00');

-- Reset the auto-increment sequence to continue after the highest ID
ALTER TABLE transactions ALTER COLUMN id RESTART WITH 6;
