package com.journal.journal.repository;

import com.journal.journal.model.GeneralLedger;
import com.journal.journal.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralLedgerRepository extends JpaRepository<GeneralLedger, Long> {
}
