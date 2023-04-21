package com.journal.journal.controller;

import com.journal.journal.model.GeneralLedger;
import com.journal.journal.model.Journal;
import com.journal.journal.service.general_ledger.GeneralLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1")
public class GeneralLedgerController {

    @Autowired
    private GeneralLedgerService generalLedgerService;

    @GetMapping("/ledger")
    public List<GeneralLedger> getAllGeneralLedgers() {
        return generalLedgerService.fetchGeneralLedgerList();
    }

    @GetMapping("/ledger/{id}")
    public ResponseEntity<GeneralLedger> get(@PathVariable("id") Long id) {

        try {
            GeneralLedger generalLedger = generalLedgerService.getGeneralLedgerById(id);
            return new ResponseEntity<GeneralLedger>(generalLedger, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<GeneralLedger>(HttpStatus.NOT_FOUND);
        }

    }
}
