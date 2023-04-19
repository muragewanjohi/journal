package com.journal.journal.service;

import com.journal.journal.model.Account;
import com.journal.journal.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    //Save Account
    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    //Lists all accounts
    @Override
    public List<Account> fetchAccountList() {
        return (List<Account>)
                accountRepository.findAll();
    }

    //Update account
    @Override
    public Account updateAccount(Account account, Long accountNo) {
        Account depDB
                = accountRepository.findById(accountNo)
                .get();

        if (Objects.nonNull(account.getAccountName())
                && !"".equalsIgnoreCase(
                account.getAccountName())) {
            depDB.setAccountName(
                    account.getAccountName());
        }

        if (Objects.nonNull(
                account.getAccountName())
                && !"".equalsIgnoreCase(
                account.getAccountName())) {
            depDB.setAccountName(
                    account.getAccountName());
        }

        if (Objects.nonNull(account.getAccountName())
                && !"".equalsIgnoreCase(
                account.getAccountName())) {
            depDB.setAccountName(
                    account.getAccountName());
        }

        return accountRepository.save(depDB);
    }

    @Override
    public void deleteAccountById(Long accountNo) {
        accountRepository.deleteById(accountNo);
    }
}
