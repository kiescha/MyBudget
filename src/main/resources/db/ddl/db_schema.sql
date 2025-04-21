CREATE TABLE "users" (
                         "user_id" int PRIMARY KEY,
                         "name" varchar,
                         "email" varchar,
                         "password_hash" varchar
);

CREATE TABLE "budgets" (
                           "budget_id" int PRIMARY KEY,
                           "user_id" int,
                           "name" varchar,
                           "start_date" date,
                           "end_date" date
);

CREATE TABLE "accounts" (
                            "account_id" int PRIMARY KEY,
                            "user_id" int,
                            "cash" decimal,
                            "balance" decimal,
                            "bank_id" int
);

CREATE TABLE "bank" (
                        "bank_id" int PRIMARY KEY,
                        "name" varchar,
                        "card" varchar
);

CREATE TABLE "categories" (
                              "category_id" int PRIMARY KEY,
                              "food" varchar,
                              "rent" varchar,
                              "salary" varchar,
                              "other" varchar
);

CREATE TABLE "transactions" (
                                "transaction_id" int PRIMARY KEY,
                                "budget_id" int,
                                "account_id" int,
                                "category_id" int,
                                "amount" decimal,
                                "income" double,
                                "expense" double,
                                "date" date,
                                "description" text
);

ALTER TABLE "budgets" ADD FOREIGN KEY ("budget_id") REFERENCES "users" ("user_id");

ALTER TABLE "accounts" ADD FOREIGN KEY ("account_id") REFERENCES "users" ("user_id");

ALTER TABLE "transactions" ADD FOREIGN KEY ("category_id") REFERENCES "categories" ("category_id");

ALTER TABLE "budgets" ADD FOREIGN KEY ("budget_id") REFERENCES "transactions" ("budget_id");

ALTER TABLE "transactions" ADD FOREIGN KEY ("account_id") REFERENCES "accounts" ("account_id");

ALTER TABLE "bank" ADD FOREIGN KEY ("bank_id") REFERENCES "accounts" ("bank_id");
