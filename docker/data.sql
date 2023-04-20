CREATE DATABASE IF NOT EXISTS JOURNAL_APP;

USE JOURNAL_APP;

CREATE TABLE account(
    accountID int NOT NULL AUTO_INCREMENT,
    accountNo VARCHAR(100) NOT NULL,
    accountName VARCHAR(255) NOT NULL,
    PRIMARY KEY(accountNo)
);

--INSERT INTO account(accountNo, accountName) VALUES ("101", "Ledger");
--INSERT INTO account(accountNo, accountName) VALUES ("102", "Savings");
--INSERT INTO account(accountNo, accountName) VALUES ("103", "Current Account");