package com.journal.journal.controller;

import com.journal.journal.model.Account;
import com.journal.journal.repository.AccountRepository;
import com.journal.journal.repository.JournalRepository;
import com.journal.journal.service.AccountService;
import com.journal.journal.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

// Annotation
@RestController
@RequestMapping("api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;


    // Save account
    @PostMapping("/accounts")
    public ResponseEntity<Account> saveAccount(
            @Valid @RequestBody Account account)
    {
        Account savedAccount = accountService.saveAccount(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    // Read account
    @GetMapping("/accounts")
    public List<Account> fetchAccountList()
    {
        return accountService.fetchAccountList();
    }

    // Update account
    @PutMapping("/accounts/{id}")
    public Account
    updateAccount(@RequestBody Account account,
                     @PathVariable("id") Long accountId)
    {
        return accountService.updateAccount(
                account, accountId);
    }


}
