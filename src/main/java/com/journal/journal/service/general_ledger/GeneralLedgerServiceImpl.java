package com.journal.journal.service.general_ledger;

import com.journal.journal.model.Account;
import com.journal.journal.model.GeneralLedger;
import com.journal.journal.model.Journal;
import com.journal.journal.repository.AccountRepository;
import com.journal.journal.repository.GeneralLedgerRepository;
import com.journal.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralLedgerServiceImpl implements GeneralLedgerService{

    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private GeneralLedgerRepository generalLedgerRepository;

    @Override
    public GeneralLedger saveGeneralLedger(Journal journal) {

        Optional<Account> accountDr = Optional.ofNullable(accountRepository.findByAccountNo(journal.getAccountDr()));
        String accountName= accountDr.get().getAccountName();

        String postingDate = journal.getJournalDate();
        String description= journal.getDescription();
        Double amount = journal.getAmount();
        String postingType = "DR";
        Long journalId = journal.getId();

        GeneralLedger dr = new GeneralLedger(null,postingDate,accountName,description,amount,postingType,journalId);
        generalLedgerRepository.save(dr);

        Optional<Account> accountCr = Optional.ofNullable(accountRepository.findByAccountNo(journal.getAccountCr()));
        accountName= accountCr.get().getAccountName();

        postingType = "CR";

        GeneralLedger cr = new GeneralLedger(null,postingDate,accountName,description,amount,postingType,journalId);
        generalLedgerRepository.save(cr);

        return cr;
    }

    @Override
    public GeneralLedger reverseGeneralLedger(Journal journal) {
        Optional<Account> accountDr = Optional.ofNullable(accountRepository.findByAccountNo(journal.getAccountDr()));
        String accountName= accountDr.get().getAccountName();

        String postingDate = journal.getJournalDate();
        String description= journal.getDescription();
        Double amount = journal.getAmount();
        String postingType = "CR";
        Long journalId = journal.getId();

        GeneralLedger dr = new GeneralLedger(null,postingDate,accountName,description,amount,postingType,journalId);
        generalLedgerRepository.save(dr);

        Optional<Account> accountCr = Optional.ofNullable(accountRepository.findByAccountNo(journal.getAccountCr()));
        accountName= accountCr.get().getAccountName();

        postingType = "DR";

        GeneralLedger cr = new GeneralLedger(null,postingDate,accountName,description,amount,postingType,journalId);
        generalLedgerRepository.save(cr);

        return cr;
    }

    @Override
    public GeneralLedger getGeneralLedgerById(Long id) {
        Optional<GeneralLedger> generalLedger = generalLedgerRepository.findById(id);
        if (generalLedger.isPresent()) {
            return generalLedger.get();
        }
        return null;
    }

    @Override
    public List<GeneralLedger> fetchGeneralLedgerList() {
        return (List<GeneralLedger>)
                generalLedgerRepository.findAll();
    }


}
