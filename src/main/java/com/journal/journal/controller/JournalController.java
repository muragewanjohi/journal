package com.journal.journal.controller;

import com.journal.journal.model.Journal;
import com.journal.journal.service.general_ledger.GeneralLedgerService;
import com.journal.journal.service.journal.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1")
public class JournalController {

    @Autowired
    private JournalService journalService;
    @Autowired
    private GeneralLedgerService generalLedgerService;

    @PostMapping("/journal")
    public ResponseEntity<?> saveJournal(@RequestBody Journal journal) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        Journal journal1 = journalService.saveJournal(journal);
        if(journal1!= null){
            generalLedgerService.saveGeneralLedger(journal);
            return new ResponseEntity<Journal>(journal, HttpStatus.CREATED);
        }else{
            map.put("message", "Invalid accounts");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/journal")
    public List<Journal> getAllJournals() {
        return journalService.fetchJournalList();
    }

    @GetMapping("/journal/{id}")
    public ResponseEntity<Journal> get(@PathVariable("id") Long id) {

        try {
            Journal journal = journalService.getJournalById(id);
            return new ResponseEntity<Journal>(journal, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Journal>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/journal/reverse/{id}")
    public ResponseEntity<?> reverseJournal(@PathVariable("id") Long id) {

        Map<String, Object> map = new LinkedHashMap<String, Object>();

        Journal journal = journalService.getJournalById(id);
        if(journal!= null){
            journal.setStatus("REVERSED");
            journalService.saveJournal(journal);
            map.put("message", "Transaction Reversed");

            generalLedgerService.saveGeneralLedger(journal);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.put("message", "Invalid account");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/journal/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Journal journal) {

        try {
            Journal ifJournalExists = journalService.getJournalById(id);
            journalService.updateJournal(journal, id);
            return new ResponseEntity<Journal>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
