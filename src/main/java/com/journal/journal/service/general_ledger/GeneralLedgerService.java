package com.journal.journal.service.general_ledger;

import com.journal.journal.model.GeneralLedger;
import com.journal.journal.model.Journal;

import java.util.List;

public interface GeneralLedgerService {
    GeneralLedger saveGeneralLedger(Journal journal);

    GeneralLedger reverseGeneralLedger(Journal journal);

    GeneralLedger getGeneralLedgerById(Long id);

    // Read operation
    List<GeneralLedger> fetchGeneralLedgerList();

    // Update operation not allowed
    /*GeneralLedger updateGeneralLedger(GeneralLedger generalLedger,
                          Long generalLedgerNo);*/
}
