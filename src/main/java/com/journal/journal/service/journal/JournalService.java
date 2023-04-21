package com.journal.journal.service.journal;

import com.journal.journal.model.Account;
import com.journal.journal.model.Journal;

import java.util.List;

public interface JournalService {
    Journal saveJournal(Journal journal);

    Journal getJournalById(Long id);

    // Read operation
    List<Journal> fetchJournalList();

    // Update operation
    Journal updateJournal(Journal journal,
                          Long journalNo);
}
