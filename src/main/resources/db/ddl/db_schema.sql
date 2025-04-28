CREATE TABLE `user` (
                        `user_id` int PRIMARY KEY,
                        `nick_name` varchar(255),
                        `email` varchar(255),
                        `password_hash` varchar(255)
);

CREATE TABLE `budget` (
                          `budget_id` int PRIMARY KEY,
                          `user_id` int,
                          `name` varchar(255),
                          `start_date` date,
                          `end_date` date
);

CREATE TABLE `transactionType` (
                                   `transactionType_id` int PRIMARY KEY,
                                   `cash` decimal,
                                   `bankAccount_id` varchar(255),
                                   `otherBank_id` varchar(255)
);

CREATE TABLE `otherBank` (
                             `otherBank_id` int PRIMARY KEY,
                             `otherBank_name` varchar(255)
);

CREATE TABLE `bankAccount` (
                               `bank_id` varchar(255),
                               `bankAcount_name` varchar(255)
);

CREATE TABLE `bank` (
                        `bank_id` int PRIMARY KEY,
                        `name` varchar(255),
                        `card_id` varchar(255)
);

CREATE TABLE `category` (
                            `category_id` int PRIMARY KEY,
                            `food` varchar(255),
                            `rent` varchar(255),
                            `salary` varchar(255),
                            `other` varchar(255)
);

CREATE TABLE `transaction` (
                               `transaction_id` int PRIMARY KEY,
                               `budget_id` int,
                               `transactionType_id` int,
                               `amount` decimal,
                               `income` double,
                               `expense` double,
                               `date` date,
                               `description` text
);

CREATE TABLE `card` (
                        `card_id` int PRIMARY KEY,
                        `cardName` varchar(255),
                        `cardType` varchar(255)
);

CREATE TABLE `budget_user` (
                               `budget_user_id` int PRIMARY KEY,
                               `user_id` varchar(255),
                               `budget_id` varchar(255)
);

ALTER TABLE `budget` ADD FOREIGN KEY (`budget_id`) REFERENCES `budget_user` (`budget_id`);

ALTER TABLE `user` ADD FOREIGN KEY (`user_id`) REFERENCES `budget_user` (`user_id`);

ALTER TABLE `transaction` ADD FOREIGN KEY (`transaction_id`) REFERENCES `category` (`category_id`);

ALTER TABLE `transaction` ADD FOREIGN KEY (`budget_id`) REFERENCES `budget` (`budget_id`);

ALTER TABLE `transactionType` ADD FOREIGN KEY (`transactionType_id`) REFERENCES `transaction` (`transactionType_id`);

ALTER TABLE `bankAccount` ADD FOREIGN KEY (`bank_id`) REFERENCES `transactionType` (`bankAccount_id`);

ALTER TABLE `otherBank` ADD FOREIGN KEY (`otherBank_id`) REFERENCES `transactionType` (`otherBank_id`);

ALTER TABLE `bank` ADD FOREIGN KEY (`bank_id`) REFERENCES `bankAccount` (`bank_id`);

ALTER TABLE `card` ADD FOREIGN KEY (`card_id`) REFERENCES `bank` (`card_id`);
