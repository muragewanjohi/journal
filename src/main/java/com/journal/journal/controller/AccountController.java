package com.journal.journal.controller;

import com.journal.journal.model.Account;
import com.journal.journal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

// Annotation
@RestController
public class AccountController {

    // Annotation
    @Autowired
    private AccountService accountService;

    // Save operation
    @PostMapping("/departments")
    public Account saveAccount(
            @Valid @RequestBody Account account)
    {
        return accountService.saveAccount(account);
    }

    // Read operation
    @GetMapping("/accounts")
    public List<Account> fetchAccountList()
    {
        return accountService.fetchAccountList();
    }

    // Update operation
    @PutMapping("/accounts/{id}")
    public Account
    updateAccount(@RequestBody Account account,
                     @PathVariable("id") Long accountId)
    {
        return accountService.updateAccount(
                account, accountId);
    }

    // Delete operation
    @DeleteMapping("/accounts/{id}")
    public String deleteAccountById(@PathVariable("id")
                                       Long accountId)
    {
        accountService.deleteAccountById(
                accountId);
        return "Deleted Successfully";
    }
}
