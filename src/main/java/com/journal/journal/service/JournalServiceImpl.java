package com.journal.journal.service;

import com.journal.journal.model.Account;
import com.journal.journal.model.Journal;
import com.journal.journal.repository.AccountRepository;
import com.journal.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService{

    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Journal saveJournal(Journal journal) {
        Optional<Account> accountCr = Optional.ofNullable(accountRepository.findByAccountNo(journal.getAccountCr()));
        Optional<Account> accountDr = Optional.ofNullable(accountRepository.findByAccountNo(journal.getAccountDr()));

        if (accountCr.isPresent() && accountDr.isPresent()) {
            return journalRepository.save(journal);
        }

        return null;
    }

    @Override
    public Journal getJournalById(Long id) {
        Optional<Journal> journal = journalRepository.findById(id);
        if (journal.isPresent()) {
            return journal.get();
        }
        return null;
    }

    @Override
    public List<Journal> fetchJournalList() {
        return (List<Journal>)
                journalRepository.findAll();
    }

    @Override
    public Journal updateJournal(Journal journal, Long journalNo) {
        Optional<Account> accountCr = Optional.ofNullable(accountRepository.findByAccountNo(journal.getAccountCr()));
        Optional<Account> accountDr = Optional.ofNullable(accountRepository.findByAccountNo(journal.getAccountDr()));

        Optional<Journal> journal1 = journalRepository.findById(journalNo);

        if (accountCr.isPresent() && accountDr.isPresent() && journal1.isPresent()) {
            Journal originalJournal = journal1.get();

            if (Objects.nonNull(journal.getJournalDate()) && !"".equalsIgnoreCase(journal.getJournalDate())) {
                originalJournal.setJournalDate(journal.getJournalDate());
            }
            if (Objects.nonNull(journal.getDescription()) && !"".equalsIgnoreCase(journal.getDescription())) {
                originalJournal.setDescription(journal.getDescription());
            }
            if (Objects.nonNull(journal.getAmount()) && journal.getAmount() != 0) {
                originalJournal.setAmount(journal.getAmount());
            }
            if (Objects.nonNull(journal.getAccountDr()) && !"".equalsIgnoreCase(journal.getAccountDr())) {
                originalJournal.setAccountDr(journal.getAccountDr());
            }
            if (Objects.nonNull(journal.getAccountCr()) && !"".equalsIgnoreCase(journal.getAccountCr())) {
                originalJournal.setAccountCr(journal.getAccountCr());
            }
            if (Objects.nonNull(journal.getStatus()) && !"".equalsIgnoreCase(journal.getStatus())) {
                originalJournal.setStatus(journal.getStatus());
            }
            return journalRepository.save(originalJournal);
        }

        return null;
    }
}
