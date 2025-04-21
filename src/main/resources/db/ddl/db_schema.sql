Table users {
  user_id int [primary key]
  name varchar
  email varchar
  password_hash varchar
}

Table budgets {
  budget_id int [primary key]
  user_id int
  name varchar
  start_date date
  end_date date
}

Table accounts {
  account_id int [primary key]
  user_id int
  cash decimal
  balance decimal
  bank_id int
}
Table bank {
  bank_id int [primary key]
  name varchar
  card varchar
}

Table categories {
  category_id int [primary key]
  food varchar
  rent varchar
  salary varchar
  other varchar
}


Table transactions {
  transaction_id int [primary key]
  budget_id int
  account_id int
  category_id int
  amount decimal
  income double
  expense double
  date date
  description text

}
ref: budgets.budget_id > users.user_id
ref: accounts.account_id > users.user_id
ref: transactions.category_id > categories.category_id
ref: transactions.budget_id < budgets.budget_id
ref: transactions.account_id > accounts.account_id
ref: accounts.bank_id < bank.bank_id


