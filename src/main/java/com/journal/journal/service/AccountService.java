package com.journal.journal.service;

import com.journal.journal.model.Account;

import java.util.List;

public interface AccountService {

    // Save operation
    Account saveAccount(Account account);

    // Read operation
    List<Account> fetchAccountList();

    // Update operation
    Account updateAccount(Account account,
                          Long accountNo);


}
